package com.solovova.cashflow.data

import android.widget.LinearLayout
import com.solovova.cashflow.SOApplication
import com.solovova.cashflow.dataclass.Account
import com.solovova.cashflow.soviews.SensorButton

class Data(app: SOApplication) {
    val accounts = mutableListOf<Account>()
    var app: SOApplication = app
    private var mViewContainer: LinearLayout? = null

    init {
        this.accounts.add(Account(1, "Test account 1", 10.0))
        this.accounts.add(Account(2, "Test account 2", 14.0))
        this.accounts.add(Account(3, "Test account 3", 25.0))
    }

    fun setViewContainer(viewContainer: LinearLayout) {
        this.mViewContainer = viewContainer
        this.createSensorButtons()
    }

    private fun createSensorButtons() {
        val viewContainer = this.mViewContainer
        if (viewContainer != null) {
            if (viewContainer.childCount > 0) viewContainer.removeAllViews()

            for (account in accounts) {
                val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                val newButton = SensorButton(viewContainer.context)
                params.setMargins(0, 0, 0, 0)
                newButton.layoutParams = params
                viewContainer.addView(newButton)
                account.setLinkToSensorButton(newButton)
            }
            viewContainer.invalidate()
        }
    }
}