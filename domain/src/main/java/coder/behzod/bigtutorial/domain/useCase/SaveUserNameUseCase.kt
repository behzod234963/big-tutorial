package coder.behzod.bigtutorial.domain.useCase

import coder.behzod.data.models.SaveUserModel

class SaveUserNameUseCase {
    fun execute(name: coder.behzod.data.models.SaveUserModel):Boolean{
        return name.name.isNotEmpty()
    }
}