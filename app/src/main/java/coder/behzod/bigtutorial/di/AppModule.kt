package coder.behzod.bigtutorial.di

import android.content.Context
import coder.behzod.bigtutorial.domain.useCase.GetUserNameUseCase
import coder.behzod.bigtutorial.domain.useCase.SaveUserNameUseCase
import coder.behzod.bigtutorial.presentation.factory.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val ctx:Context) {

    @Provides
    fun provideContext():Context{
        return ctx
    }

    @Provides
    fun provideMainViewModelFactory(
        saveUserNameUseCase: SaveUserNameUseCase,
        getUserNameUseCase: GetUserNameUseCase
    ):MainViewModelFactory{
        return MainViewModelFactory(
            getUseCase = getUserNameUseCase,
            saveUseCase = saveUserNameUseCase
        )
    }
}