package com.astrology.astroprognoz.view.personal_info

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.astrology.astroprognoz.R
import kotlinx.android.synthetic.main.fragment_personal_info.*

class PersonalInfoFragment : Fragment(R.layout.fragment_personal_info) {
    private val viewModel: PersonalInfoViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(PersonalInfoViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        initObservers()
        initListeners()
    }

    private fun initObservers() {
        viewModel.toastLiveData.observe(viewLifecycleOwner, Observer {
            it?.getContentIfNotHandled()?.let { message ->
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.openNextScreenLiveData.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { destination ->
                findNavController().navigate(destination)
            }
        })
    }

    private fun initListeners() {
        cardViewMan.setOnClickListener {
            setSelect(cardViewMan, cardViewWoman)
            viewModel.onSelectMan()
        }
        cardViewWoman.setOnClickListener {
            setSelect(cardViewWoman, cardViewMan)
            viewModel.onSelectWoman()
        }
        btnNextPersonalInfo.setOnClickListener { viewModel.onClickNext(tietNameSurname.text?.toString()) }
    }

    private fun setSelect(viewSelect: View, viewFree: View) {
        viewSelect.scaleX = 1f
        viewSelect.scaleY = 1f
        viewFree.scaleX = 1f
        viewFree.scaleY = 1f

        viewSelect.animate().scaleX(1.2f).scaleY(1.2f).setDuration(200L).start()
    }
}