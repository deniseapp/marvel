package marvelapp.com.marvelapp.injections

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import marvelapp.com.marvelapp.App
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        InjectorsModule::class,
        AndroidSupportInjectionModule::class))

interface AppComponent {
    fun inject(app: App)
}