package com.solovova.cashflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.solovova.cashflow.fragments.FragmentBlank
import com.solovova.cashflow.fragments.FragmentParent
import com.solovova.cashflow.fragments.FragmentStart
import com.solovova.cashflow.fragments.FragmentStartBlank

class MainActivity : AppCompatActivity() {
    //SwipeLayout
    private var fragments = mutableMapOf<String, FragmentParent?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as SOApplication).mainActivity = this

//        if ((application as SOApplication).sensorContainer.testModeTestData.compareTo("on") == 0)
//            (application as SOApplication).sensorContainer.loadFromTestData()

        if (savedInstanceState == null) {
            //(application as SOApplication).dataContainer!!.load()
            this.showStartScreen()
        }
    }

    //a?.equals(b) ?: (b === null)
    private fun fragmentsShow(fragmentName: String,
                      strData: String? = null) {
        Log.d("SHOW",fragmentName)
        val ft = supportFragmentManager.beginTransaction()

        //hide all fragments
        for ((key, value)  in fragments) {
            if (value != null)
                if (key.compareTo(fragmentName)  != 0 && value.isVisible) {
                    ft.hide(value)
                    value.onHide()
                }
        }

        var fragment: FragmentParent? =  fragments[fragmentName]

        if (fragment == null) {
            Log.i("SHOW CREATE", fragmentName)
            when (fragmentName) {
                "FragmentStartBlank" -> fragment = FragmentStartBlank.newInstance()
                "FragmentStart" -> fragment = FragmentStart.newInstance()
                else -> fragment = FragmentBlank.newInstance()
            }
        }


        fragment.strData = strData



        fragments[fragmentName]=fragment
        if (!fragment.isAdded) ft.add(R.id.container, fragment, fragmentName)

        ft.show(fragment)
        fragment.onShow()

        ft.commit()
        //supportFragmentManager.executePendingTransactions()
    }

    private fun getActiveFragments(): String {
        var result = ""
        for ((_key, _fragment) in fragments) {
            if (_fragment != null && _fragment.isAdded && _fragment.isVisible) {
                result = _key
                break
            }
        }
        return result
    }

    private fun showStartScreen() {
//        when ((application as SOApplication).sensorContainer.sensors.isEmpty()) {
//            true -> this.fragmentsShow("FragmentStartBlank")
//            false -> this.fragmentsShow("FragmentStart")
//        }

        this.fragmentsShow("FragmentStart")
    }

    override fun onBackPressed() {
        when (this.getActiveFragments()) {
            "FragmentSensor"        -> this.showStartScreen()
            "FragmentStart"         -> super.onBackPressed()

            else -> super.onBackPressed()
        }
    }

    //StartFragment
    fun startFragmentScan(v: View) {
        Log.i("Button click", v.id.toString())
        this.fragmentsShow("FragmentScan")
    }

    //SensorFragment
    fun sensorFragmentBack(v: View) {
        Log.i("Button click", v.id.toString())
        this.onBackPressed()
    }

    //ScanFragment
    fun scanFragmentEnterCode(v: View) {
        Log.i("Button click", v.id.toString())
        this.fragmentsShow("FragmentEnterCode")
    }

    fun scanFragmentBack(v: View) {
        Log.i("Button click", v.id.toString())
        this.onBackPressed()
    }

    //EnterCodeFragment
    fun sensorEnterCodeBack(v: View) {
        Log.i("Button click", v.id.toString())
        this.onBackPressed()
    }


}
