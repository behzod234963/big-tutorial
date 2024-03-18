package coder.behzod.bigtutorial.data.repository

import coder.behzod.bigtutorial.data.storage.UserModel
import coder.behzod.bigtutorial.data.storage.UserStorage
import coder.behzod.bigtutorial.domain.models.GetUserModel
import coder.behzod.bigtutorial.domain.models.SaveUserModel
import coder.behzod.bigtutorial.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage):UserRepository {

    override fun saveUser(saveUser: SaveUserModel):Boolean {
        val user = UserModel(firstName = saveUser.name, lastName = "")
        return userStorage.save(user)
    }
    override fun getUser(): GetUserModel {
        val user = userStorage.get()
        val getUser = GetUserModel(firstName = user.firstName, lastName = user.lastName)
        return getUser
    }
}