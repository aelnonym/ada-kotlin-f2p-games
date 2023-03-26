package me.joaovictorsl.adafreetoplaygames.ui.recyclerview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.joaovictorsl.adafreetoplaygames.R
import me.joaovictorsl.adafreetoplaygames.databinding.GameItemBinding
import me.joaovictorsl.adafreetoplaygames.model.Game
import me.joaovictorsl.adafreetoplaygames.ui.gamedetail.GameDetailActivity

class GameAdapter(
    gameList: List<Game> = listOf()
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    private var mGameList = gameList.toMutableList()
    val gameList = mGameList.toList()

    class GameViewHolder(private val binding: GameItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val ivGameThumbnail = binding.gameItemThumbnail
        private val tvGameTitle = binding.gameItemTitle

        fun bind(g: Game) {
            val context = binding.root.context
            tvGameTitle.text = g.title
            Glide.with(context)
                .load(g.thumbnail)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(ivGameThumbnail)

            binding.root.setOnClickListener {
                val intent = Intent(context, GameDetailActivity::class.java).apply {
                    putExtra(context.getString(R.string.game_extra_key), g)
                }
                context.startActivity(intent)
            }
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
