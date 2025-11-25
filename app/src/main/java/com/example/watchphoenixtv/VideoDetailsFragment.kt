package com.example.watchphoenixtv

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.graphics.drawable.Drawable
import androidx.leanback.app.DetailsSupportFragment
import androidx.leanback.app.DetailsSupportFragmentBackgroundController
import androidx.leanback.widget.Action
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.ClassPresenterSelector
import androidx.leanback.widget.DetailsOverviewRow
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnActionClickedListener
import androidx.core.content.ContextCompat
import android.widget.Toast

import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition

import java.util.Collections

/**
 * A wrapper fragment for leanback details screens.
 * It shows a detailed view of video and its metadata plus related videos.
 */
class VideoDetailsFragment : DetailsSupportFragment() {

    private var selectedProgram: Program? = null

    private lateinit var detailsBackground: DetailsSupportFragmentBackgroundController
    private lateinit var presenterSelector: ClassPresenterSelector
    private lateinit var adapter: ArrayObjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailsBackground = DetailsSupportFragmentBackgroundController(this)

        selectedProgram = activity!!.intent.getSerializableExtra(DetailsActivity.PROGRAM) as Program
        if (selectedProgram != null) {
            presenterSelector = ClassPresenterSelector()
            adapter = ArrayObjectAdapter(presenterSelector)
            setupDetailsOverviewRow()
            setupDetailsOverviewRowPresenter()
            setupRelatedProgramsListRow()
            this.adapter = adapter
            initializeBackground(selectedProgram)
        } else {
            val intent = Intent(activity!!, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializeBackground(program: Program?) {
        detailsBackground.enableParallax()
        Glide.with(activity!!)
            .asBitmap()
            .centerCrop()
            .error(R.drawable.default_background)
            .load(program?.backgroundImageUrl)
            .into<SimpleTarget<Bitmap>>(object : SimpleTarget<Bitmap>() {
                override fun onResourceReady(
                    bitmap: Bitmap,
                    transition: Transition<in Bitmap>?
                ) {
                    detailsBackground.coverBitmap = bitmap
                    adapter.notifyArrayItemRangeChanged(0, adapter.size())
                }
            })
    }

    private fun setupDetailsOverviewRow() {
        val row = DetailsOverviewRow(selectedProgram)
        row.imageDrawable = ContextCompat.getDrawable(activity!!, R.drawable.default_background)
        val width = convertDpToPixel(activity!!, DETAIL_THUMB_WIDTH)
        val height = convertDpToPixel(activity!!, DETAIL_THUMB_HEIGHT)
        Glide.with(activity!!)
            .load(selectedProgram?.cardImageUrl)
            .centerCrop()
            .error(R.drawable.default_background)
            .into<SimpleTarget<Drawable>>(object : SimpleTarget<Drawable>(width, height) {
                override fun onResourceReady(
                    drawable: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    row.imageDrawable = drawable
                    adapter.notifyArrayItemRangeChanged(0, adapter.size())
                }
            })

        val actionAdapter = ArrayObjectAdapter()

        actionAdapter.add(
            Action(
                ACTION_WATCH_TRAILER,
                resources.getString(R.string.watch_trailer_1),
                if (selectedProgram?.isLive == true) "Watch Live" else ""
            )
        )
        row.actionsAdapter = actionAdapter

        adapter.add(row)
    }

    private fun setupDetailsOverviewRowPresenter() {
        // Set detail background.
        val detailsPresenter = FullWidthDetailsOverviewRowPresenter(DetailsDescriptionPresenter())
        detailsPresenter.backgroundColor =
            ContextCompat.getColor(activity!!, R.color.selected_background)

        // Hook up transition element.
        val sharedElementHelper = FullWidthDetailsOverviewSharedElementHelper()
        sharedElementHelper.setSharedElementEnterTransition(
            activity, DetailsActivity.SHARED_ELEMENT_NAME
        )
        detailsPresenter.setListener(sharedElementHelper)
        detailsPresenter.isParticipatingEntranceTransition = true

        detailsPresenter.onActionClickedListener = OnActionClickedListener { action ->
            if (action.id == ACTION_WATCH_TRAILER) {
                val intent = Intent(activity!!, PlaybackActivity::class.java)
                intent.putExtra(DetailsActivity.PROGRAM, selectedProgram)
                startActivity(intent)
            } else {
                Toast.makeText(activity!!, action.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        presenterSelector.addClassPresenter(DetailsOverviewRow::class.java, detailsPresenter)
    }

    private fun setupRelatedProgramsListRow() {
        val channel = ChannelList.channels.find { it.name == selectedProgram?.channelName }
        if (channel != null) {
            val subcategories = arrayOf(getString(R.string.related_movies))
            val list = channel.programs.toMutableList()
            Collections.shuffle(list)
            val listRowAdapter = ArrayObjectAdapter(CardPresenter())
            list.forEach { listRowAdapter.add(it) }

            val header = HeaderItem(0, subcategories[0])
            adapter.add(ListRow(header, listRowAdapter))
            presenterSelector.addClassPresenter(ListRow::class.java, ListRowPresenter())
        }
    }

    private fun convertDpToPixel(context: Context, dp: Int): Int {
        val density = context.applicationContext.resources.displayMetrics.density
        return Math.round(dp.toFloat() * density)
    }

    companion object {
        private val ACTION_WATCH_TRAILER = 1L

        private val DETAIL_THUMB_WIDTH = 274
        private val DETAIL_THUMB_HEIGHT = 274
    }
}