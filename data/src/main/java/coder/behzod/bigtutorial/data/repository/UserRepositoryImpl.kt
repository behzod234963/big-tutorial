package coder.behzod.bigtutorial.data.repository

import android.content.Context
import coder.behzod.bigtutorial.data.models.GetUserModel
import coder.behzod.bigtutorial.data.models.SaveUserModel
import coder.behzod.bigtutorial.data.shared_pref_instance.SharedPreference
import coder.behzod.bigtutorial.domain.repository.UserRepository

class UserRepositoryImpl(private val ctx:Context):UserRepository {
    val sharedPref = SharedPreference(ctx)
    override fun saveUser(user: SaveUserModel):Boolean {
        sharedPref.saveString(user.name)
        return user.name.isNotEmpty()
    }
    override fun getUser(): GetUserModel {
        val getData = sharedPref.getString()
        val getLastName = sharedPref.getSecondString()
        return GetUserModel(getData,getLastName)
    }
}