package marvelapp.com.marvelapp.ui.characters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_character.view.*
import marvelapp.com.marvelapp.R
import marvelapp.com.marvelapp.model.Result
import marvelapp.com.marvelapp.ui.characters.CharacterDetailsActivity.Companion.CHARACTER_DETAILS_KEY


class CharactersAdapter(private var characters: MutableList<Result>) : RecyclerView.Adapter<CharactersAdapter.CharactersVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersVH {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = CharactersVH(inflater.inflate(R.layout.row_character, parent, false))
        return viewHolder
    }


    override fun onBindViewHolder(holder: CharactersVH, position: Int) {
        val context = holder.itemView.context
        val character = characters[position]

        holder.itemView.title.text = character.name
        holder.itemView.image.setImageURI(character.thumbnail?.getImagePath())
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, CharacterDetailsActivity::class.java).apply {
                putExtra(CHARACTER_DETAILS_KEY, character)
            })
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    fun setItems(results: List<Result>) {
        characters.addAll(results)
        notifyDataSetChanged()
    }

    fun addItems(results: List<Result>) {
        val positionStart = itemCount
        characters.addAll(results)
        notifyItemRangeInserted(positionStart, results.size)
    }

    class CharactersVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }


}