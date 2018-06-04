package com.estyle.trainingkotlin.fragments

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.estyle.trainingkotlin.R
import com.estyle.trainingkotlin.utils.AnimatorUtils
import kotlinx.android.synthetic.main.fragment_01.*

/**
 * Created by zhangyi on 2018/5/22.
 */
class No01Fragment : BaseFragment() {

    override var mPage: Int
        get() = 1
        set(value) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_01, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottom.post {
            val one1Anim = AnimatorUtils.createScleAndAlpha(one1TV)
            val two1Anim = AnimatorUtils.createTranslationLeft2Right(two1TV, activity)
            val two2Anim = AnimatorUtils.createTranslationLeft2Right(two2TV, activity)
            val two3Anim = AnimatorUtils.createTranslationLeft2Right(two3TV, activity)

            one1Anim.addListener(this)
            two1Anim.addListener(this)
            two2Anim.addListener(this)
            two3Anim.addListener(this)

            AnimatorSet().apply {
                duration = 1000
                playSequentially(one1Anim, two1Anim, two2Anim, two3Anim)
                one1TV.visibility = View.VISIBLE
                start()
            }

            one1TV.setOnClickListener {
            }
        }
    }

    override fun onTitleClick() {

    }

    override fun onAnimEnd(animation: Animator) {
        when ((animation as ObjectAnimator).target) {
            one1TV -> {
                two1TV.visibility = View.VISIBLE
            }
            two1TV -> {
                two2TV.visibility = View.VISIBLE
            }
            two2TV -> {
                two3TV.visibility = View.VISIBLE
            }
        }
    }

}