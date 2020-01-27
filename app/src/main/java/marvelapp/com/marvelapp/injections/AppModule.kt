package marvelapp.com.marvelapp.injections

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import marvelapp.com.marvelapp.App
import javax.inject.Singleton


@Module(includes = arrayOf(NetworksModule::class))
class AppModule(application: App) {

    private val application: Application

    init {
        this.application = application
    }

    @Provides
    @Singleton
    internal fun provideApp(): Application {
        return application
    }

}
