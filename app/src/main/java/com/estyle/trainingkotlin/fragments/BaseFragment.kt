package com.estyle.trainingkotlin.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_01.*

/**
 * Created by zhangyi on 2018/5/22.
 */
abstract class BaseFragment : Fragment() {

    companion object {

        val sTotalCount = 4
    }

    protected abstract var mPage: Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titlebar.setOnClickListener { onTitleClick() }
    }

    protected abstract fun onTitleClick();
}