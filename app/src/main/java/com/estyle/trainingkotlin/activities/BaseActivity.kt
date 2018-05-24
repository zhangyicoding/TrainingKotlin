package com.estyle.trainingkotlin.activities

import android.animation.Animator
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity(), Animator.AnimatorListener {
    override fun onAnimationRepeat(animation: Animator?) {
    }

    override fun onAnimationEnd(animation: Animator?) {
        onAnimEnd(animation)
    }

    override fun onAnimationCancel(animation: Animator?) {
    }

    override fun onAnimationStart(animation: Animator?) {
    }

    protected abstract fun onAnimEnd(animation: Animator?)

}