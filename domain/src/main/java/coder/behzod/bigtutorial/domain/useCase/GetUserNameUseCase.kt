package coder.behzod.bigtutorial.domain.useCase

import coder.behzod.data.models.GetUserModel

class GetUserNameUseCase {
    fun execute(): coder.behzod.data.models.GetUserModel {
        return coder.behzod.data.models.GetUserModel(
            "dcvbnkfv",
            "dvbkf"
        )
    }
}