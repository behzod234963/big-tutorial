package coder.behzod.bigtutorial.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import coder.behzod.bigtutorial.domain.models.GetUserModel
import coder.behzod.bigtutorial.domain.models.SaveUserModel
import coder.behzod.bigtutorial.domain.useCase.GetUserNameUseCase
import coder.behzod.bigtutorial.domain.useCase.SaveUserNameUseCase

class MainViewModel(
    private val saveUseCase: SaveUserNameUseCase,
    private val getUseCase: GetUserNameUseCase
) : ViewModel() {
    init {
        Log.e("AAA", "ViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("AAA", "ViewModel cleared")
    }

    fun save(text: String): String {
        val saveName = SaveUserModel(text)
        val result = saveUseCase.execute(saveName)
        return "Save result = $result"
    }

    fun load(): String {
        val getData: GetUserModel = getUseCase.execute()
        return "${getData.firstName} ${getData.lastName}"
    }
}