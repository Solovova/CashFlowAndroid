package com.solovova.cashflow.dataclass

import com.solovova.cashflow.soviews.SensorButton

class Account(val id: Int, val name: String, val balance: Double){
    private var mSensorButton: SensorButton? = null

    fun setLinkToSensorButton(newButton: SensorButton) {
        this.mSensorButton = newButton
        newButton.setSensor(this)
    }
}