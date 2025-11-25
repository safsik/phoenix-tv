package com.example.watchphoenixtv

import android.graphics.drawable.Icon
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.leanback.widget.Presenter

class IconPresenter : Presenter() {

    private val ICON_WIDTH = 120
    private val ICON_HEIGHT = 120

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val context = parent.context

        val linearLayout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            isFocusable = true
            isFocusableInTouchMode = true
            background = ContextCompat.getDrawable(context, R.drawable.item_background)
        }

        val imageView = ImageView(context).apply {
            layoutParams = ViewGroup.LayoutParams(ICON_WIDTH, ICON_HEIGHT)
        }

        val textView = TextView(context).apply {
            gravity = Gravity.CENTER
            setTextColor(ContextCompat.getColor(context, android.R.color.white))
        }

        linearLayout.addView(imageView)
        linearLayout.addView(textView)

        return ViewHolder(linearLayout)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val iconHeaderItem = item as Icon
        val linearLayout = viewHolder.view as LinearLayout
        val imageView = linearLayout.getChildAt(0) as ImageView
        val textView = linearLayout.getChildAt(1) as TextView

        imageView.setImageDrawable(ContextCompat.getDrawable(viewHolder.view.context, iconHeaderItem.resId))
        textView.text = viewHolder.view.context.getString(iconHeaderItem.resId)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        // No need to unbind anything
    }
}