package com.example.watchphoenixtv

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.FragmentActivity

/**
 * Loads a [PlaybackVideoFragment].
 */
class PlaybackActivity : FragmentActivity() {

    private lateinit var playbackVideoFragment: PlaybackVideoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            playbackVideoFragment = PlaybackVideoFragment()
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, playbackVideoFragment)
                .commit()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_UP -> {
                // TODO: Increase volume
                return true
            }
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                // TODO: Decrease volume
                return true
            }
            KeyEvent.KEYCODE_DPAD_LEFT -> {
                // TODO: Previous channel
                return true
            }
            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                // TODO: Next channel
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}