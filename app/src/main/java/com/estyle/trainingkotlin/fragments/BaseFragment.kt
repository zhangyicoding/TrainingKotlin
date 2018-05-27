package com.estyle.trainingkotlin.fragments

import android.animation.Animator
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.estyle.trainingkotlin.R
import kotlinx.android.synthetic.main.fragment_01.*

/**
 * Created by zhangyi on 2018/5/22.
 */
abstract class BaseFragment : Fragment(), Animator.AnimatorListener {
    override fun onAnimationRepeat(animation: Animator?) {
    }

    override fun onAnimationEnd(animation: Animator?) {
        onAnimEnd(animation!!)
    }

    override fun onAnimationCancel(animation: Animator?) {
    }

    override fun onAnimationStart(animation: Animator?) {
    }

    companion object {

        val sTotalCount = 4
    }

    protected abstract var mPage: Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundResource(R.mipmap.all_bg)
        titlebar.setOnClickListener { onTitleClick() }
    }

    protected abstract fun onTitleClick()
    protected abstract fun onAnimEnd(animation: Animator)

}