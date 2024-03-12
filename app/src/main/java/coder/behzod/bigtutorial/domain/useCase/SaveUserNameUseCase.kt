package coder.behzod.bigtutorial.domain.useCase

import coder.behzod.bigtutorial.data.models.SaveUserModel

class SaveUserNameUseCase {
    fun execute(name:SaveUserModel):Boolean{
        return name.name.isNotEmpty()
    }
}