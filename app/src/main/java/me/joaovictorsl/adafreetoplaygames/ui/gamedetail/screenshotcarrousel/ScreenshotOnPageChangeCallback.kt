package me.joaovictorsl.adafreetoplaygames.ui.gamedetail.screenshotcarrousel

import android.view.ViewGroup
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import me.joaovictorsl.adafreetoplaygames.R

class ScreenshotOnPageChangeCallback(private val vg: ViewGroup) : ViewPager2.OnPageChangeCallback() {
    private var lastSelected = -1

    override fun onPageSelected(position: Int) {
        super.onPageSelected(position)

        if (notFirstSelection()) {
            removeSelectedColorFromPrevious()
        }

        setSelectedColorOnCurrent(position)
        lastSelected = position
    }

    private fun setSelectedColorOnCurrent(position: Int) {
        val newSelectedMarker = vg[position]
        newSelectedMarker.setBackgroundResource(R.drawable.selected_marker)
    }

    private fun removeSelectedColorFromPrevious() {
        val lastSelectedMarker = vg[lastSelected]
        lastSelectedMarker.setBackgroundResource(R.drawable.unselected_marker)
    }

    private fun notFirstSelection() = lastSelected != -1

}