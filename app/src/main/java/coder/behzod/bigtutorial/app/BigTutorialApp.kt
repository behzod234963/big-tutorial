package coder.behzod.bigtutorial.app

import android.app.Application
import coder.behzod.bigtutorial.di.AppComponent
import coder.behzod.bigtutorial.di.AppModule
import coder.behzod.bigtutorial.di.DaggerAppComponent

class BigTutorialApp : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this@BigTutorialApp)).build()
    }
}