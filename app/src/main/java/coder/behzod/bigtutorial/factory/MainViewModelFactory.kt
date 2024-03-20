package coder.behzod.bigtutorial.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import coder.behzod.bigtutorial.data.repository.UserRepositoryImpl
import coder.behzod.bigtutorial.data.storage.SharedPreferenceStorage
import coder.behzod.bigtutorial.domain.useCase.GetUserNameUseCase
import coder.behzod.bigtutorial.domain.useCase.SaveUserNameUseCase
import coder.behzod.bigtutorial.viewModel.MainViewModel

class MainViewModelFactory (ctx:Context): ViewModelProvider.Factory {

    private val repository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPreferenceStorage(ctx = ctx))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(repository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(repository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveUserNameUseCase,
            getUserNameUseCase
        ) as T
    }
}