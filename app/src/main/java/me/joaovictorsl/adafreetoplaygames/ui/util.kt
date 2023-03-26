package me.joaovictorsl.adafreetoplaygames.ui

import android.text.TextUtils
import android.view.View
import android.widget.TextView

class SeeMoreTextViewClickListener(private val controlledView: TextView) : View.OnClickListener {
    private var isSeeMore = true

    override fun onClick(tvSee: View?) {
        (tvSee as TextView)

        isSeeMore = if (isSeeMore) {
            updateControlledViewWith(
                ellipsize = null,
                maxLines = 100
            )

            false
        } else {
            updateControlledViewWith(
                ellipsize = TextUtils.TruncateAt.END,
                maxLines = 5
            )

            true
        }

        tvSee.text = if (isSeeMore) "See more" else "See less"
    }

    private fun updateControlledViewWith(ellipsize: TextUtils.TruncateAt?, maxLines: Int) {
        controlledView.ellipsize = ellipsize
        controlledView.maxLines = maxLines
    }

}