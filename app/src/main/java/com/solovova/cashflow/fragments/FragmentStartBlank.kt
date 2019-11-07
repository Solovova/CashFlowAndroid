package com.solovova.cashflow.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.solovova.cashflow.R

class FragmentStartBlank : FragmentParent() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_start_blank, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentStartBlank()
    }

}