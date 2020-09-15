package com.astrology.astroprognoz.view.description

import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.astrology.astroprognoz.R
import kotlinx.android.synthetic.main.fragment_description.*

class DescriptionFragment : Fragment(R.layout.fragment_description) {
    private val viewModel: DescriptionViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(DescriptionViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        initListeners()
        initObservers()
        viewModel.initLifecycleDependencyLogic()
    }

    private fun initListeners() {
        btnNextDescription.setOnClickListener {
            viewModel.onClickNext(checkBoxDescription.isChecked)
        }
    }

    private fun initObservers() {
        viewModel.descriptionTextLiveData.observe(viewLifecycleOwner, Observer {
            tvDescription.text = HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY)
        })
        viewModel.onClickNextLiveData.observe(viewLifecycleOwner, Observer {
            it?.getContentIfNotHandled()?.let {
                findNavController().navigate(R.id.action_descriptionFragment_to_personalInfoFragment)
            }
        })
    }
}