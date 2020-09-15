package com.astrology.astroprognoz.view.personal_info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.astrology.astroprognoz.R
import com.astrology.astroprognoz.model.ext.Event
import com.astrology.astroprognoz.model.saveUserSp
import com.astrology.astroprognoz.model.util.User

class PersonalInfoViewModel : ViewModel() {
    val toastLiveData = MutableLiveData<Event<String>>()
    val openNextScreenLiveData = MutableLiveData<Event<Int>>()
    private var user: User? = null

    fun onSelectMan() {
        if (user == null) {
            user = User()
        }
        user?.isMan = true
    }

    fun onSelectWoman() {
        if (user == null) {
            user = User()
        }
        user?.isMan = false
    }

    fun onClickNext(nameSurname: String?) {
        if (nameSurname.isNullOrBlank()) {
            toastLiveData.postValue(Event("Введите имя и фамилию"))
            return
        }
        if (!nameSurname.contains(" ")) {
            toastLiveData.postValue(Event("Введите имя и фамилию"))
            return
        }
        if (user == null) {
            toastLiveData.postValue(Event("Выберите Ваш пол"))
            return
        }
        user?.name = nameSurname
        saveUserSp(user)
        openNextScreenLiveData.postValue(Event(R.id.action_personalInfoFragment_to_birthdayFragment))
    }
}