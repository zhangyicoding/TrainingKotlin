package com.estyle.trainingkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.estyle.trainingkotlin.R

class No04Fragment:BaseFragment() {
    override var mPage: Int
        get() = 4
        set(value) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_04_drawable, container, false)
    }

    override fun onTitleClick() {
    }
}