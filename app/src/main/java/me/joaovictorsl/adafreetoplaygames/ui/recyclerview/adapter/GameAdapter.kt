package me.joaovictorsl.adafreetoplaygames.ui.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.joaovictorsl.adafreetoplaygames.R
import me.joaovictorsl.adafreetoplaygames.databinding.GameItemBinding
import me.joaovictorsl.adafreetoplaygames.model.Game

class GameAdapter(
    gameList: List<Game> = listOf()
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    private var mGameList = gameList.toMutableList()
    val gameList = mGameList.toList()

    class GameViewHolder(private val binding: GameItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val ivGameThumbnail = binding.gameItemThumbnail
        private val tvGameTitle = binding.gameItemTitle

        fun bind(g: Game) {
            tvGameTitle.text = g.title
            Glide.with(binding.root.context)
                .load(g.thumbnail)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(ivGameThumbnail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = GameItemBinding.inflate(layoutInflater, parent, false)

        return GameViewHolder(binding)
    }

    override fun getItemCount() = mGameList.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = mGameList[position]
        holder.bind(game)
    }

    fun setNewList(newList: List<Game>) {
        mGameList = newList.toMutableList()
        // TODO Create DiffUtil and remove the notifyDataSetChanged
        notifyDataSetChanged()
    }
}
