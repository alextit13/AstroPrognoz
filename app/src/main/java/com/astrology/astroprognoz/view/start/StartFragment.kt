package com.astrology.astroprognoz.view.start

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.astrology.astroprognoz.R
import com.astrology.astroprognoz.model.isShowDescriptionScreen
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment(R.layout.fragment_start) {
    override fun onResume() {
        super.onResume()
        initAnimation()
        initClickers()
    }

    private fun initAnimation() {
        imageViewLogo.apply {
            alpha = 0f
            scaleX = 0.5f
            scaleY = 0.5f
            animate().scaleX(1f).scaleY(1f)
                .alpha(1f).setDuration(400).start()
        }
    }

    private fun initClickers() {
        btnStart.setOnClickListener {
            if (isShowDescriptionScreen()) {
                findNavController().navigate(R.id.action_startFragment_to_personalInfoFragment)
            } else {
                findNavController().navigate(R.id.action_startFragment_to_descriptionFragment)
            }
        }
    }
}