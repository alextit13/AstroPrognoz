package com.astrology.astroprognoz.model

import android.content.Context
import com.astrology.astroprognoz.model.util.User
import com.astrology.astroprognoz.view.base.App
import com.google.gson.Gson

fun disableDescriptionScreen() {
    val context = App.instance?.applicationContext ?: return
    context.getSharedPreferences(DEFAULT_SP, Context.MODE_PRIVATE)
        .edit()
        .putBoolean(SHOW_DESCRIPTION, true)
        .apply()
}

fun isDescriptionScreenEnabled(): Boolean {
    val context = App.instance?.applicationContext ?: return true
    return context.getSharedPreferences(DEFAULT_SP, Context.MODE_PRIVATE)
        .getBoolean(SHOW_DESCRIPTION, false)
}

fun saveUser(user: User) {
    val context = App.instance?.applicationContext ?: return
    context.getSharedPreferences(DEFAULT_SP, Context.MODE_PRIVATE)
        .edit()
        .putString(USER, Gson().toJson(user))
        .apply()
}

fun getUserSp(): User? {
    val context = App.instance?.applicationContext ?: return null
    val jsonUser = context.getSharedPreferences(DEFAULT_SP, Context.MODE_PRIVATE)
        .getString(USER, "")
    return Gson().fromJson(jsonUser, User::class.java)
}

private const val DEFAULT_SP = "user_sp"
private const val SHOW_DESCRIPTION = "show_description"
private const val USER = "user"