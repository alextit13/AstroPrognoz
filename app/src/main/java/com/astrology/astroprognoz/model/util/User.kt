package com.astrology.astroprognoz.model.util

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var isMan: Boolean? = null,
    var name: String? = null,
    var date: String? = null, // dd.MM.yyyy
    var time: String? = null // hh:mm
) : Parcelable