package coder.behzod.bigtutorial.app

import android.app.Application
import coder.behzod.bigtutorial.di.appModule
import coder.behzod.bigtutorial.di.dataModule
import coder.behzod.bigtutorial.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BigTutorialApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@BigTutorialApp)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}