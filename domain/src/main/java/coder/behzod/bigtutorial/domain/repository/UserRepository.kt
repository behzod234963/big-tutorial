package coder.behzod.bigtutorial.domain.repository

import coder.behzod.bigtutorial.domain.models.GetUserModel
import coder.behzod.bigtutorial.domain.models.SaveUserModel
interface UserRepository {
    fun getUser(): GetUserModel
    fun saveUser(user: SaveUserModel):Boolean
}