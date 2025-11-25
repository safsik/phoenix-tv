package com.example.watchphoenixtv

import android.graphics.drawable.Drawable
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import androidx.core.content.ContextCompat
import android.view.ViewGroup
import com.bumptech.glide.Glide

private const val CARD_WIDTH = 500
private const val CARD_HEIGHT = 280

/**
 * A CardPresenter is used to generate Views and bind Objects to them on demand.
 * It contains an ImageCardView.
 */
class CardPresenter : Presenter() {

    private var defaultCardImage: Drawable? = null

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        defaultCardImage = ContextCompat.getDrawable(parent.context, R.drawable.movie)

        val cardView = object : ImageCardView(parent.context) {
            override fun setSelected(selected: Boolean) {
                updateCardBackgroundColor(this, selected)
                super.setSelected(selected)
            }
        }

        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true
        updateCardBackgroundColor(cardView, false)
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val program = item as Program
        val cardView = viewHolder.view as ImageCardView

        cardView.titleText = program.title
        cardView.contentText = program.description
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT)

        if (program.isLive) {
            cardView.badgeImage = ContextCompat.getDrawable(viewHolder.view.context, R.drawable.live_badge)
        }

        Glide.with(viewHolder.view.context)
            .load(program.cardImageUrl)
            .centerCrop()
            .error(defaultCardImage)
            .into(cardView.mainImageView)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        val cardView = viewHolder.view as ImageCardView
        // Remove references to images so that the garbage collector can free up memory
        cardView.badgeImage = null
        cardView.mainImage = null
    }

    private fun updateCardBackgroundColor(view: ImageCardView, selected: Boolean) {
        val selectedColor = ContextCompat.getColor(view.context, R.color.selected_background)
        val defaultColor = ContextCompat.getColor(view.context, R.color.default_background)

        val color = if (selected) selectedColor else defaultColor
        // Both background colors should be set because the view's background is temporarily visible
        // during animations.
        view.setBackgroundColor(color)
        view.setInfoAreaBackgroundColor(color)
    }
}