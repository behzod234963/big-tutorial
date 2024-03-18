package coder.behzod.bigtutorial.domain.repository

import coder.behzod.data.models.GetUserModel
import coder.behzod.data.models.SaveUserModel

interface UserRepository {
    fun getUser(): coder.behzod.data.models.GetUserModel
    fun saveUser(user: coder.behzod.data.models.SaveUserModel):Boolean
}