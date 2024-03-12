package coder.behzod.bigtutorial.domain.repository

import coder.behzod.bigtutorial.data.models.GetUserModel
import coder.behzod.bigtutorial.data.models.SaveUserModel

interface UserRepository {
    fun getUser():GetUserModel
    fun saveUser(user:SaveUserModel):Boolean
}