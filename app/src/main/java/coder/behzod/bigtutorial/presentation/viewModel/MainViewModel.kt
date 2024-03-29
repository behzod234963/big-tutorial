package coder.behzod.bigtutorial.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coder.behzod.bigtutorial.domain.models.GetUserModel
import coder.behzod.bigtutorial.domain.models.SaveUserModel
import coder.behzod.bigtutorial.domain.useCase.GetUserNameUseCase
import coder.behzod.bigtutorial.domain.useCase.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val saveUseCase: SaveUserNameUseCase,
    private val getUseCase: GetUserNameUseCase
) : ViewModel() {
    init {
        Log.e("AAA", "ViewModel created")
    }


    private val mutableLiveData = MutableLiveData<String>()
    val liveData:LiveData<String> = mutableLiveData
    override fun onCleared() {
        super.onCleared()
        Log.e("AAA", "ViewModel cleared")
    }

    fun save(text: String) {
        val saveName = SaveUserModel(text)
        val result = saveUseCase.execute(saveName)
        mutableLiveData.value =  "Save result = $result"
    }

    fun load() {
        val getData: GetUserModel = getUseCase.execute()
        mutableLiveData.value =  "${getData.firstName} ${getData.lastName}"
    }
}