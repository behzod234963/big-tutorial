package coder.behzod.bigtutorial.di

import coder.behzod.bigtutorial.data.repository.UserRepositoryImpl
import coder.behzod.bigtutorial.data.storage.SharedPreferenceStorage
import coder.behzod.bigtutorial.data.storage.UserStorage
import coder.behzod.bigtutorial.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPreferenceStorage(ctx = get())
    }
    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}