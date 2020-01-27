package marvelapp.com.marvelapp.ui

interface BaseView {
    fun hideLoading()
    fun showLoading()
    fun showError(errorMessage: String)

}