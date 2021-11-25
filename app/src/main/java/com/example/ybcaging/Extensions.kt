package com.example.ybcaging

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.core.app.ShareCompat

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun Activity.shareText(message: String) {
    val mimeType = "text/plain"
    val shareIntent = ShareCompat.IntentBuilder.from(this)
        .setText(message)
        .setType(mimeType)
        .intent

    if (shareIntent.resolveActivity(packageManager) != null) {
        startActivity(shareIntent)
    }
}

fun Activity.phoneCall(phoneNumber: String) {
    val dialIntent = Intent(Intent.ACTION_DIAL)
    dialIntent.data = Uri.parse("tel:$phoneNumber")
    startActivity(dialIntent)
}