package coder.behzod.bigtutorial.domain.useCase

import coder.behzod.bigtutorial.domain.models.GetUserModel

class GetUserNameUseCase {
    fun execute(): GetUserModel {
        return GetUserModel(
            "dcvbnkfv",
            "dvbkf"
        )
    }
}