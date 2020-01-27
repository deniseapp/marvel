package marvelapp.com.marvelapp.ui.characters

import marvelapp.com.marvelapp.model.Result
import marvelapp.com.marvelapp.ui.BaseView

interface CharactersView: BaseView {
    fun setCharacters(results: List<Result>?)
    fun addCharacters(results: List<Result>?)
    fun hideBottomLoading()
    fun showBottomLoading()
 }


