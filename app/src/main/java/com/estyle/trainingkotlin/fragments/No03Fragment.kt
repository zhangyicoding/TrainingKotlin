package com.estyle.trainingkotlin.fragments

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.estyle.trainingkotlin.R

class No03Fragment:BaseFragment() {
    override fun onAnimEnd(animation: Animator) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override var mPage: Int
        get() = 3
        set(value) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_03, container, false)
    }

    override fun onTitleClick() {
    }
}