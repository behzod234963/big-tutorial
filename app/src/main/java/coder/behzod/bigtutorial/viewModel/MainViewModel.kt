package coder.behzod.bigtutorial.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
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

    val liveData = MutableLiveData<String>()
    override fun onCleared() {
        super.onCleared()
        Log.e("AAA", "ViewModel cleared")
    }

    fun save(text: String) {
        val saveName = SaveUserModel(text)
        val result = saveUseCase.execute(saveName)
        liveData.value =  "Save result = $result"
    }

    fun load() {
        val getData: GetUserModel = getUseCase.execute()
        liveData.value =  "${getData.firstName} ${getData.lastName}"
    }
}