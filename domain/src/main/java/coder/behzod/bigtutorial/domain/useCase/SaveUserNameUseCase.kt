package coder.behzod.bigtutorial.domain.useCase

import coder.behzod.bigtutorial.domain.models.SaveUserModel
import coder.behzod.bigtutorial.domain.repository.UserRepository


class SaveUserNameUseCase(private val repository: UserRepository) {
    fun execute(name: SaveUserModel):Boolean{
        return repository.saveUser(name)
    }
}