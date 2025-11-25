package com.example.watchphoenixtv

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide

class HeroPresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.hero_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val heroItem = item as HeroItem
        val view = viewHolder.view

        val titleView = view.findViewById<TextView>(R.id.hero_title)
        val descriptionView = view.findViewById<TextView>(R.id.hero_description)
        val imageView = view.findViewById<ImageView>(R.id.hero_image)

        titleView.text = heroItem.title
        descriptionView.text = heroItem.description

        Glide.with(view.context)
            .load(heroItem.imageUrl)
            .into(imageView)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        // No-op
    }
}