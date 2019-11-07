package com.solovova.cashflow.soviews

import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.Button
import android.widget.TextView
import com.solovova.cashflow.R
import com.solovova.cashflow.dataclass.Account

//All good
class SensorButton(context: Context) : ConstraintLayout(context) {
    private var mTextMain: TextView
    private var mButtonMain: Button
    private var mButtonDel: Button

    private var account: Account? = null

    init {
        inflate(context, R.layout.soview_sensor_button, this)
        this.mTextMain = findViewById(R.id.textMain)
        this.mButtonMain = findViewById(R.id.button)
        this.mButtonDel = findViewById(R.id.buttonDel)



//        val onClickListenerDel = OnClickListener {
//            val sensor = this.sensor
//            if (sensor != null) {
//                sensor.sensorContainer.deleteSensor(sensor)
//                (context as MainActivity).showStartScreen()
//            }
//            return@OnClickListener
//        }
//        this.mButtonDel.setOnClickListener(onClickListenerDel)
//
//        val onClickListenerMain = OnClickListener {
//            (context as MainActivity).fragmentsShow("FragmentSensor", sensor = sensor)
//            return@OnClickListener
//        }
//        this.mButtonMain.setOnClickListener(onClickListenerMain)
    }

    fun refreshValue() {
        val account = this.account
        if (account != null) {

        }
    }

    private fun refreshAll() {
        val account = this.account
        if (account != null) {
            mTextMain.text = account.name
            refreshValue()
        }
    }

    fun setSensor(account: Account) {
        this.account = account
        this.refreshAll()
    }
}