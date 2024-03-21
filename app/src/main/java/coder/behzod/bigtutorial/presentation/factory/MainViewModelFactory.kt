package coder.behzod.bigtutorial.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import coder.behzod.bigtutorial.domain.useCase.GetUserNameUseCase
import coder.behzod.bigtutorial.domain.useCase.SaveUserNameUseCase
import coder.behzod.bigtutorial.presentation.viewModel.MainViewModel

class MainViewModelFactory(
    private val getUseCase: GetUserNameUseCase,
    private val saveUseCase: SaveUserNameUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveUseCase,
            getUseCase
        )as T
    }
}