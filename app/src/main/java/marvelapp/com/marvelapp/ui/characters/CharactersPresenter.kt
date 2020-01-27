package marvelapp.com.marvelapp.ui.characters

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import marvelapp.com.marvelapp.data.ApiInterface
import marvelapp.com.marvelapp.model.Characters
import marvelapp.com.marvelapp.util.Helper
import marvelapp.com.marvelapp.util.Helper.PRIVATE_KEY
import marvelapp.com.marvelapp.util.Helper.PUBLIC_KEY
import java.util.*
import javax.inject.Inject


class CharactersPresenter
@Inject
internal constructor(private val apiInterface: ApiInterface) {
    private val disposables: CompositeDisposable = CompositeDisposable()
    private lateinit var view: CharactersView
    var VISIBLE_THRESHOLD = 20
    var offset = 0
    var limit = VISIBLE_THRESHOLD
    var isLoading = false

    fun setView(view: CharactersView) {
        this.view = view
    }


    fun getCharacters(firstTime: Boolean) {
        if (isLoading) {
            return
        } else {
            isLoading = true
            if (firstTime) {
                view.showLoading()
            } else {
                view.showBottomLoading()
            }
            val ts = Date().time
            val hashKey = Helper.md5("$ts$PRIVATE_KEY${Helper.PUBLIC_KEY}")
            val observable = apiInterface.getCharacters(ts, PUBLIC_KEY, hashKey, offset, limit)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableObserver<Characters>() {
                        override fun onComplete() {
                        }

                        override fun onNext(characters: Characters) {
                            isLoading = false
                            offset += VISIBLE_THRESHOLD
                            limit += VISIBLE_THRESHOLD
                            val results = characters.data?.results
                            if (firstTime) {
                                view.setCharacters(results)
                                view.hideLoading()
                            } else {
                                view.addCharacters(results)
                                view.hideBottomLoading()
                            }
                        }

                        override fun onError(e: Throwable) {
                            isLoading = false
                            Log.e("error", e.message)
                            view.showError(e.message ?: "Unknown error")
                            if (firstTime) {
                                view.hideLoading()
                            } else {
                                view.hideBottomLoading()
                            }

                        }
                    })


            observable?.let { disposables.add(it) }
        }
    }


    fun onStop() {
        disposables.dispose()
    }

}