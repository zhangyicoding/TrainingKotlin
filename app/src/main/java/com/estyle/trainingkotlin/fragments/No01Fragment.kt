package com.estyle.trainingkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by zhangyi on 2018/5/22.
 */
class No01Fragment:BaseFragment() {
    override var mPage: Int
        get() = 1
        set(value) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment)
    }

}