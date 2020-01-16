package com.nuradityo.basestyle.widget

import android.content.Context
import android.widget.Toast

const val TEXT_SHORT = 0
const val TEXT_LONG = 1


fun showText(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

fun showText(context: Context, text: String, duration: Int) {
    Toast.makeText(context, text, duration).show()
}

fun showText(context: Context, resId: Int, duration: Int) {
    Toast.makeText(context, resId, duration).show()
}