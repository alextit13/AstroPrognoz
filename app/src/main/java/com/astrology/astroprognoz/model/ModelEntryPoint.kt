package com.astrology.astroprognoz.model

import com.astrology.astroprognoz.model.util.User

fun getTextFromRawFile(fileResId: Int, onResult: (String) -> Unit) {
    read(fileResId, onResult)
}

fun isShowDescriptionScreen(): Boolean {
    return isDescriptionScreenEnabled()
}

fun makeNotShowDescriptionAgain() {
    disableDescriptionScreen()
}

fun saveUserSp(user: User?) {
    if (user == null) return
    saveUser(user)
}

fun getUser(): User? {
    return getUserSp()
}

fun getCountry(): MutableList<String> {
    return mutableListOf()
}