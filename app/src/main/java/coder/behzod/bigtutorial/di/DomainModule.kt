package coder.behzod.bigtutorial.di

import coder.behzod.bigtutorial.data.storage.UserStorage
import coder.behzod.bigtutorial.domain.repository.UserRepository
import coder.behzod.bigtutorial.domain.useCase.GetUserNameUseCase
import coder.behzod.bigtutorial.domain.useCase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideSaveUseCase(userRepository:UserRepository):SaveUserNameUseCase = SaveUserNameUseCase(userRepository)
    @Provides
    fun provideGetUseCase(userRepository: UserRepository):GetUserNameUseCase = GetUserNameUseCase(userRepository)
}