package com.astrology.astroprognoz.view.description

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.astrology.astroprognoz.R
import com.astrology.astroprognoz.model.ext.Event
import com.astrology.astroprognoz.model.getTextFromRawFile
import com.astrology.astroprognoz.model.makeNotShowDescriptionAgain

class DescriptionViewModel : ViewModel() {
    val descriptionTextLiveData = MutableLiveData<String>()
    val onClickNextLiveData = MutableLiveData<Event<Boolean>>()
    fun initLifecycleDependencyLogic() {
        updateContentDescriptionFromFile()
    }

    fun onClickNext(isDismissDescriptionScreen: Boolean) {
        if (isDismissDescriptionScreen) {
            makeNotShowDescriptionAgain()
        }
        onClickNextLiveData.postValue(Event(true))
    }

    private fun updateContentDescriptionFromFile() {
        getTextFromRawFile(DESCRIPTION_FILE_NAME) {
            descriptionTextLiveData.postValue(it)
        }
    }

    companion object {
        private const val DESCRIPTION_FILE_NAME = R.raw.description
    }
}