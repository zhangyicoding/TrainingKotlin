package com.estyle.trainingkotlin.fragments

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import com.estyle.trainingkotlin.R
import com.estyle.trainingkotlin.utils.AnimatorUtils
import kotlinx.android.synthetic.main.fragment_02.*

class No02Fragment:BaseFragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        AnimatorUtils.createAlphaDouble(mNaniImageView)
                .start()
    }

    override fun onAnimEnd(animation: Animator) {
        when ((animation as ObjectAnimator).target) {
            leftTwo1TV -> { leftTwo2TV.visibility = View.VISIBLE }
            else -> {
            }
        }
    }

    override var mPage: Int
        get() = 2
        set(value) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_02, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leftOne1TV.setOnClickListener {
            val two1Anim = AnimatorUtils.createTranslationTop2Bottom(leftTwo1TV)
            val two2Anim = AnimatorUtils.createTranslationTop2Bottom(leftTwo2TV)

            two1Anim.addListener(this)
            two2Anim.addListener(this)

            AnimatorSet().apply {
                duration = 1000
                playSequentially(two1Anim, two2Anim)
                leftTwo1TV.visibility = View.VISIBLE
                start()
            }
        }

        leftTwo1TV.setOnClickListener(this)
        leftTwo2TV.setOnClickListener(this)
    }

    override fun onTitleClick() {
        AnimatorUtils.createRotation10Times(leftOne1TV).apply {
            duration = 3000
            leftOne1TV.visibility = View.VISIBLE
            start()
        }
    }
}