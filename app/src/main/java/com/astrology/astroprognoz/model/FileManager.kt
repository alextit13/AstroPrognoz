package com.astrology.astroprognoz.model

import android.os.Handler
import android.os.Looper
import com.astrology.astroprognoz.view.base.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun read(fileResId: Int, onResult: (String) -> Unit) {
    GlobalScope.launch {
        withContext(Dispatchers.IO) {
            val context = App.instance?.applicationContext ?: return@withContext
            var content = ""
            context.resources.openRawResource(fileResId).bufferedReader().use {
                content = it.readText()
            }
            withContext(Dispatchers.Main) {
                Handler(Looper.getMainLooper()).post { onResult.invoke(content) }
            }
        }
    }
}