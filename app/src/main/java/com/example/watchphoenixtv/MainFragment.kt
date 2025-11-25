package com.example.watchphoenixtv

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.leanback.app.BackgroundManager
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.OnItemViewSelectedListener
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition


class MainFragment : BrowseSupportFragment() {

    private lateinit var backgroundManager: BackgroundManager
    private var defaultBackground: Drawable? = null
    private lateinit var metrics: DisplayMetrics

    class IconHeaderItem(
        id: Long,
        name: String,
        @param:DrawableRes val iconResId: Int = NO_ICON
    ) : HeaderItem(id, name) {

        constructor(@DrawableRes iconResId: Int = NO_ICON, name: String) :
        // Secondary constructor if you don't need a specific ID
                this(id = 1000, name)

        companion object {
            const val NO_ICON = 0
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareBackgroundManager()
        setupUIElements()
        loadRows()
        setupEventListeners()
    }

    private fun prepareBackgroundManager() {
        backgroundManager = BackgroundManager.getInstance(activity)
        defaultBackground = ContextCompat.getDrawable(requireActivity(), R.drawable.default_background)
        metrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(metrics)
    }

    private fun setupUIElements() {
        title = getString(R.string.browse_title)
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true

        brandColor = ContextCompat.getColor(requireActivity(), R.color.fastlane_background)
        searchAffordanceColor = ContextCompat.getColor(requireActivity(), R.color.search_opaque)
    }

    private fun loadRows() {
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        // Hero Row
        val heroPresenter = HeroPresenter()
        val heroAdapter = ArrayObjectAdapter(heroPresenter)
        // For now, we'll feature the first live program we find.
        val featuredProgram = ChannelList.channels.flatMap { it.programs }.find { it.isLive } ?: ChannelList.channels.first().programs.first()
        heroAdapter.add(HeroItem(featuredProgram.title, featuredProgram.description, featuredProgram.backgroundImageUrl))
        rowsAdapter.add(ListRow(null, heroAdapter)) // Null header for full-width hero

        // Channel Rows
        val cardPresenter = CardPresenter()
        for ((index, channel) in ChannelList.channels.withIndex()) {
            val listRowAdapter = ArrayObjectAdapter(cardPresenter)
            listRowAdapter.addAll(0, channel.programs)
            val header = HeaderItem(index.toLong() + 1, channel.name) // Offset index for hero row
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }

        // Settings & More Category
        val settingsHeader = HeaderItem(ChannelList.channels.size.toLong() + 1, "Settings & More")
        val iconPresenter = IconPresenter()
        val iconRowAdapter = ArrayObjectAdapter(iconPresenter)
        iconRowAdapter.add(IconHeaderItem(android.R.drawable.ic_menu_slideshow, "EPG"))
        iconRowAdapter.add(IconHeaderItem(android.R.drawable.ic_menu_manage, "Settings"))
        rowsAdapter.add(ListRow(settingsHeader, iconRowAdapter))

        adapter = rowsAdapter
    }

    private fun setupEventListeners() {
        onItemViewClickedListener = OnItemViewClickedListener { _, item, _, _ ->
            when (item) {
                is Program -> {
                    val intent = Intent(requireActivity(), DetailsActivity::class.java)
                    intent.putExtra(DetailsActivity.PROGRAM, item)
                    startActivity(intent)
                }
                is HeroItem -> {
                    // Find the program associated with the hero and launch details
                    val featuredProgram = ChannelList.channels.flatMap { it.programs }.find { it.title == item.title }
                    if (featuredProgram != null) {
                        val intent = Intent(requireActivity(), DetailsActivity::class.java)
                        intent.putExtra(DetailsActivity.PROGRAM, featuredProgram)
                        startActivity(intent)
                    }
                }
                is IconHeaderItem -> {
                    when (item.name) {
                        "EPG" -> startActivity(Intent(requireActivity(), EpgActivity::class.java))
                        "Settings" -> startActivity(Intent(requireActivity(), SettingsActivity::class.java))
                    }
                }
            }
        }

        onItemViewSelectedListener = OnItemViewSelectedListener { _, item, _, _ ->
            val backgroundUrl = when (item) {
                is Program -> item.backgroundImageUrl
                is HeroItem -> item.imageUrl
                else -> null
            }
            updateBackground(backgroundUrl)
        }
    }

    private fun updateBackground(uri: String?) {
        val width = metrics.widthPixels
        val height = metrics.heightPixels
        Glide.with(requireActivity())
            .load(uri)
            .centerCrop()
            .error(defaultBackground)
            .into<SimpleTarget<Drawable>>(
                object : SimpleTarget<Drawable>(width, height) {
                    override fun onResourceReady(drawable: Drawable, transition: Transition<in Drawable>?) {
                        backgroundManager.drawable = drawable
                    }
                })
    }
}