package com.astrology.astroprognoz.view.birthday

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.astrology.astroprognoz.R
import com.vikktorn.picker.CountryPicker
import kotlinx.android.synthetic.main.fragment_birthday.*
import java.util.*

class BirthdayFragment : Fragment(R.layout.fragment_birthday) {
    private val viewModel: BirthdayViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(BirthdayViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        initListeners()

        activity?.supportFragmentManager?.let { CountryPicker.Builder().build().showDialog(it) }

        viewModel.initLifecycleDependencyLogic()
    }

    private fun initListeners() {
        btnDate.setOnClickListener { showDatePicker() }
        btnTime.setOnClickListener { showTimePicker() }
        btnNextBirthday.setOnClickListener { viewModel.onClickNext(checkBoxIncorrect.isChecked) }
    }

    @SuppressLint("SetTextI18n")
    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            requireContext(),
            DatePickerDialog.OnDateSetListener { _, year, p2, day ->
                val month = p2 + 1
                viewModel.onSelectDate(day, month, year)
                btnDate.text = "$day.$month.$year"
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    @SuppressLint("SetTextI18n")
    private fun showTimePicker() {
        val calendar = Calendar.getInstance()
        TimePickerDialog(
            requireContext(),
            TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                viewModel.onSelectTime(hour, minute)
                btnTime.text = "$hour:$minute"
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true
        ).show()
    }
}