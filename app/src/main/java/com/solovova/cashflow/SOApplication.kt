package com.solovova.cashflow

import android.app.Activity
import android.app.Application
import com.solovova.cashflow.data.Data

class SOApplication : Application() {
    var data = Data(this)
    var mainActivity: Activity? = null
}