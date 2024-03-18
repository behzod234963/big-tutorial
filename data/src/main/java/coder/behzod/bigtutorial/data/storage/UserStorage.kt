package coder.behzod.bigtutorial.data.storage

import coder.behzod.bigtutorial.domain.models.GetUserModel
import coder.behzod.bigtutorial.domain.models.SaveUserModel

interface UserStorage {
    fun save(user: UserModel):Boolean
    fun get(): UserModel
}