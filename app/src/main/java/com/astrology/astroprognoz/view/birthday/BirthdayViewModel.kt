package com.astrology.astroprognoz.view.birthday

import androidx.lifecycle.ViewModel
import com.astrology.astroprognoz.model.CityManager
import com.astrology.astroprognoz.model.getUser
import com.astrology.astroprognoz.model.util.User

class BirthdayViewModel : ViewModel() {
    private lateinit var user: User
    fun initLifecycleDependencyLogic() {
        user = getUser() ?: return

        CityManager().getStateJson()
    }

    fun onSelectDate(day: Int, month: Int, year: Int) {

    }

    fun onSelectTime(hour: Int, minute: Int) {

    }

    fun onClickNext(isCheckedIncorrectTime: Boolean) {

    }
}