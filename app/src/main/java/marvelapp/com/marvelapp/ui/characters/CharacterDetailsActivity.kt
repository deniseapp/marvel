package marvelapp.com.marvelapp.ui.characters

import android.content.Intent
import android.os.Bundle
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.character_details.*
import marvelapp.com.marvelapp.R
import marvelapp.com.marvelapp.model.Result
import marvelapp.com.marvelapp.ui.BaseActivity


class CharacterDetailsActivity : BaseActivity() {
    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetails"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_details)

        val character = intent.getParcelableExtra<Result>(CHARACTER_DETAILS_KEY)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        displayCharacter(character)
    }

    private fun displayCharacter(character: Result) {
        image.setImageURI(character.thumbnail?.getImagePath())
        name.text = character.name
        supportActionBar?.title = character.name
        description.text = character.description
        marvelWiki.setOnClickListener {
            startActivity(Intent(this@CharacterDetailsActivity, WebViewActivity::class.java))
        }
    }


    override fun inject() {
        AndroidInjection.inject(this)
    }

}
