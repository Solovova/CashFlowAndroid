package com.solovova.cashflow.data

import com.solovova.cashflow.soviews.AccountButton

class Account(val id: Int, val name: String, val balance: Double){
    private var mAccountButton: AccountButton? = null

    fun setLinkToSensorButton(newButton: AccountButton) {
        this.mAccountButton = newButton
        newButton.setSensor(this)
    }
}