package com.example.watchphoenixtv

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * BrowseErrorActivity shows how to use ErrorFragment.
 */
class BrowseErrorActivity : FragmentActivity() {

    private lateinit var errorFragment: ErrorFragment
    private lateinit var spinnerFragment: SpinnerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            showError()
        }
    }

    private fun showError() {
        errorFragment = ErrorFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_browse_fragment, errorFragment)
            .commit()

        spinnerFragment = SpinnerFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_browse_fragment, spinnerFragment)
            .commit()

        val handler = Handler(Looper.myLooper()!!)
        handler.postDelayed({
            supportFragmentManager
                .beginTransaction()
                .remove(spinnerFragment)
                .commit()
            errorFragment.setErrorContent()
        }, TIMER_DELAY)
    }

    class SpinnerFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val progressBar = ProgressBar(container?.context)
            if (container is FrameLayout) {
                val layoutParams =
                    FrameLayout.LayoutParams(SPINNER_WIDTH, SPINNER_HEIGHT, Gravity.CENTER)
                progressBar.layoutParams = layoutParams
            }
            return progressBar
        }
    }

    companion object {
        private const val TIMER_DELAY = 3000L
        private const val SPINNER_WIDTH = 100
        private const val SPINNER_HEIGHT = 100
    }
}
