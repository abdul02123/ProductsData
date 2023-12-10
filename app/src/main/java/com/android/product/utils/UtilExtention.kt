package com.android.product.utils

import android.content.Context
import android.widget.Toast


fun Context.showToast(message: String = "Something went wrong") {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
