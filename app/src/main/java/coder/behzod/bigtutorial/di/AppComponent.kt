package coder.behzod.bigtutorial.di

import coder.behzod.bigtutorial.presentation.ui.activities.MainActivity
import dagger.Component

@Component(modules = [AppModule::class,DataModule::class,DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}