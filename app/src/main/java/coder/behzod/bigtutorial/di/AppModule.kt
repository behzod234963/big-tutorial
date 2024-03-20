package coder.behzod.bigtutorial.di

import coder.behzod.bigtutorial.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            getUseCase = get(),
            saveUseCase = get()
        )
    }
}
