package coder.behzod.bigtutorial.data.storage

import android.annotation.SuppressLint
import android.content.Context
import coder.behzod.bigtutorial.domain.models.GetUserModel
import coder.behzod.bigtutorial.domain.models.SaveUserModel

private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
private const val FIRSTNAME_KEY = "FIRSTNAME_KEY"
private const val LASTNAME_KEY = "LASTNAME_KEY"
private const val DEFAULT_LAST_NAME = "DEFAULT_NAME"
private const val DEFAULT_FIRST_NAME = "DEFAULT_NAME"
class SharedPreferenceStorage(private val ctx:Context):UserStorage {
    val sharedPref = ctx.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    @SuppressLint("CommitPrefEdits")
    override fun save(user: UserModel): Boolean {
        sharedPref.edit().putString(FIRSTNAME_KEY,user.firstName)
        sharedPref.edit().putString(LASTNAME_KEY,user.lastName)
        return true
    }

    override fun get(): UserModel {
        val firstName = sharedPref.getString(FIRSTNAME_KEY, DEFAULT_FIRST_NAME)?:DEFAULT_FIRST_NAME
        val lastName = sharedPref.getString(LASTNAME_KEY, DEFAULT_LAST_NAME)?:DEFAULT_LAST_NAME
        return UserModel(firstName,lastName)
    }
}