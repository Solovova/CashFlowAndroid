package com.solovova.cashflow.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.solovova.cashflow.R
import com.solovova.cashflow.SOApplication

class FragmentStart : FragmentParent() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onShow() {
        super.onShow()
        val view = this.view
        if (view != null) {
            (activity?.application as SOApplication).data.setViewContainer(view.findViewById(R.id.container))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentStart()
    }
}
