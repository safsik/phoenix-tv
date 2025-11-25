package com.example.watchphoenixtv

import android.net.Uri
import android.os.Bundle
import androidx.leanback.app.VideoSupportFragment
import androidx.leanback.app.VideoSupportFragmentGlueHost
import androidx.leanback.media.MediaPlayerAdapter
import androidx.leanback.media.PlaybackTransportControlGlue
import androidx.leanback.widget.PlaybackControlsRow

/** Handles video playback with media controls. */
class PlaybackVideoFragment : VideoSupportFragment() {

    private lateinit var transportControlGlue: PlaybackTransportControlGlue<MediaPlayerAdapter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val program = activity?.intent?.getSerializableExtra(DetailsActivity.PROGRAM) as? Program
        if (program == null) {
            activity?.finish()
            return
        }

        val glueHost = VideoSupportFragmentGlueHost(this@PlaybackVideoFragment)
        val playerAdapter = MediaPlayerAdapter(requireActivity())
        playerAdapter.setRepeatAction(PlaybackControlsRow.RepeatAction.INDEX_NONE)

        transportControlGlue = PlaybackTransportControlGlue(requireActivity(), playerAdapter)
        transportControlGlue.host = glueHost
        transportControlGlue.title = program.title
        transportControlGlue.subtitle = program.description
        transportControlGlue.playWhenPrepared()

        playerAdapter.setDataSource(Uri.parse(program.videoUrl))
    }

    override fun onPause() {
        super.onPause()
        transportControlGlue.pause()
    }
}