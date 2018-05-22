package com.estyle.trainingkotlin.fragments

import android.support.v4.app.Fragment

/**
 * Created by zhangyi on 2018/5/22.
 */
abstract class BaseFragment : Fragment() {

    companion object {

        val sTotalCount = 0

    }

    protected abstract var mPage: Int
}