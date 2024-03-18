package coder.behzod.bigtutorial.domain.useCase

import coder.behzod.bigtutorial.domain.models.SaveUserModel


class SaveUserNameUseCase {
    fun execute(name: SaveUserModel):Boolean{
        return name.name.isNotEmpty()
    }
}