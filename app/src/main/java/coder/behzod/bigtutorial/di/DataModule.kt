package coder.behzod.bigtutorial.di

import android.content.Context
import coder.behzod.bigtutorial.data.repository.UserRepositoryImpl
import coder.behzod.bigtutorial.data.storage.SharedPreferenceStorage
import coder.behzod.bigtutorial.data.storage.UserStorage
import coder.behzod.bigtutorial.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext ctx:Context):UserStorage = SharedPreferenceStorage(ctx = ctx)
    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage):UserRepository = UserRepositoryImpl(userStorage)
}