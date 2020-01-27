package marvelapp.com.marvelapp.injections

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marvelapp.com.marvelapp.ui.characters.CharacterDetailsActivity
import marvelapp.com.marvelapp.ui.characters.CharactersActivity
import marvelapp.com.marvelapp.ui.characters.WebViewActivity


@Module
abstract class InjectorsModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): CharactersActivity

    @ContributesAndroidInjector
    internal abstract fun characterDetailsActivity(): CharacterDetailsActivity

    @ContributesAndroidInjector
    internal abstract fun webViewActivity(): WebViewActivity

}