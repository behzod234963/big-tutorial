package coder.behzod.bigtutorial.di

import android.content.Context
import coder.behzod.bigtutorial.data.repository.UserRepositoryImpl
import coder.behzod.bigtutorial.data.storage.SharedPreferenceStorage
import coder.behzod.bigtutorial.data.storage.UserStorage
import coder.behzod.bigtutorial.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(ctx:Context):UserStorage{
        return SharedPreferenceStorage(ctx = ctx)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage):UserRepository{
        return UserRepositoryImpl(userStorage = userStorage)
    }
}