package me.joaovictorsl.adafreetoplaygames.ui.gamedetail.screenshotcarrousel

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.joaovictorsl.adafreetoplaygames.R
import me.joaovictorsl.adafreetoplaygames.databinding.ScreenshotItemBinding
import me.joaovictorsl.adafreetoplaygames.model.Screenshot

class ScreenshotAdapter(
    screenshotList: List<Screenshot> = listOf()
) : RecyclerView.Adapter<ScreenshotAdapter.ScreenshotHolder>() {
    private var mScreenshotList = screenshotList.toMutableList()

    class ScreenshotHolder(private val binding: ScreenshotItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: Screenshot) {
            Glide.with(binding.root.context)
                .load(s.image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(binding.ivScreenshot)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setScreenshotList(newScreenshotList: List<Screenshot>) {
        mScreenshotList = newScreenshotList.toMutableList()
        // Screenshot list size is small (< than 10)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenshotHolder {
        val context = parent.context
        val binding = ScreenshotItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ScreenshotHolder(binding)
    }

    override fun onBindViewHolder(holder: ScreenshotHolder, position: Int) {
        holder.bind(mScreenshotList[position])
    }

    override fun getItemCount() = mScreenshotList.size
}