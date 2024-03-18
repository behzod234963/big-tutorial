package coder.behzod.bigtutorial.domain.useCase

import coder.behzod.bigtutorial.domain.models.GetUserModel
import coder.behzod.bigtutorial.domain.repository.UserRepository

class GetUserNameUseCase(private val repository: UserRepository) {
    fun execute(): GetUserModel {
        return repository.getUser()
    }
}