package coder.behzod.bigtutorial.di

import coder.behzod.bigtutorial.domain.useCase.GetUserNameUseCase
import coder.behzod.bigtutorial.domain.useCase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(repository = get())
    }
    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(repository = get())
    }
}