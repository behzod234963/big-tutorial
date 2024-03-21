package coder.behzod.bigtutorial.di

import coder.behzod.bigtutorial.domain.repository.UserRepository
import coder.behzod.bigtutorial.domain.useCase.GetUserNameUseCase
import coder.behzod.bigtutorial.domain.useCase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUseCase(repository: UserRepository):GetUserNameUseCase{
        return GetUserNameUseCase(repository)
    }

    @Provides
    fun provideSaveUseCase(repository: UserRepository):SaveUserNameUseCase{
        return SaveUserNameUseCase(repository)
    }
}