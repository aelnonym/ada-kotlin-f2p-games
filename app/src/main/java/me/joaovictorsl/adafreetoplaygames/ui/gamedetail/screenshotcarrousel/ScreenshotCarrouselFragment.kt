package me.joaovictorsl.adafreetoplaygames.ui.gamedetail.screenshotcarrousel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import me.joaovictorsl.adafreetoplaygames.R
import me.joaovictorsl.adafreetoplaygames.databinding.FragmentScreenshotCarrouselBinding
import me.joaovictorsl.adafreetoplaygames.model.Screenshot

class ScreenshotCarrouselFragment : Fragment() {
    private lateinit var binding: FragmentScreenshotCarrouselBinding
    private var adapter = ScreenshotAdapter()
    private var currentPageChangeCallback: ViewPager2.OnPageChangeCallback? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScreenshotCarrouselBinding.inflate(inflater, container, false)
        adapter = ScreenshotAdapter()
        binding.carrousel.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        if (currentPageChangeCallback != null) binding.carrousel.unregisterOnPageChangeCallback(currentPageChangeCallback!!)
    }

    fun setScreenshotList(screenshotList: List<Screenshot>) {
        if (screenshotList.isNotEmpty()) {
            binding.carrouselContainer.visibility = View.VISIBLE
            adapter.setScreenshotList(screenshotList)

            for(screenshot in screenshotList) {
                val view = layoutInflater.inflate(R.layout.carrousel_marker, binding.llMarkerContainer, false)
                binding.llMarkerContainer.addView(view)
            }

            binding.llMarkerContainer.requestLayout()
            setOnPageChangeCallback()
        }
    }

    private fun setOnPageChangeCallback() {
        if (currentPageChangeCallback != null)
            binding.carrousel.unregisterOnPageChangeCallback(currentPageChangeCallback!!)

        binding.carrousel.registerOnPageChangeCallback(ScreenshotOnPageChangeCallback(binding.llMarkerContainer))
    }

    companion object {
        @JvmStatic
        fun newInstance() = ScreenshotCarrouselFragment()
    }
}