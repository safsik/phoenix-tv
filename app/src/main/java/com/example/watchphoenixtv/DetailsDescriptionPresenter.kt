package com.example.watchphoenixtv

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter

class DetailsDescriptionPresenter : AbstractDetailsDescriptionPresenter() {

    override fun onBindDescription(
        viewHolder: ViewHolder,
        item: Any
    ) {
        val program = item as Program

        viewHolder.title.text = program.title
        viewHolder.subtitle.text = program.channelName
        viewHolder.body.text = program.description
    }
}