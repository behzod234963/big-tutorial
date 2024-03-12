package coder.behzod.bigtutorial.domain.useCase

import coder.behzod.bigtutorial.data.models.GetUserModel

class GetUserNameUseCase {
    fun execute():GetUserModel{
        return GetUserModel(
            "dcvbnkfv",
            "dvbkf"
        )
    }
}