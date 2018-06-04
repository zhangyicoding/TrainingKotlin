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
import com.estyle.trainingkotlin.widget.TargetDialog
import kotlinx.android.synthetic.main.fragment_no1_2.*
import kotlin.concurrent.thread

class No1_2Fragment : BaseFragment() {
    override var mPage: Int
        get() = 12
        set(value) {}

    private val title = "从本堂课中你将get到啥"

    override fun onTitleClick() {
        titleAnimator()
    }

    override fun onAnimEnd(animation: Animator) {
        when ((animation as ObjectAnimator).target) {
            oneTextView -> {
                oneTextView.text = title

                val two1Anim = AnimatorUtils.createRotationX(two1TextView)
                val two2Anim = AnimatorUtils.createRotationX(two2TextView)
                val two3Anim = AnimatorUtils.createRotationX(two3TextView)

                two1Anim.addListener(this)
                two2Anim.addListener(this)
                two3Anim.addListener(this)

                val animSet = AnimatorSet()
                animSet.playSequentially(two1Anim, two2Anim, two3Anim)

                two1TextView.visibility = View.VISIBLE

                animSet.start()
            }
            two1TextView -> {
                two2TextView.visibility = View.VISIBLE
            }
            two2TextView -> {
                two3TextView.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_no1_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        oneTextView.setOnClickListener {
            val titleAnim = AnimatorUtils.createScale(it, 1000, 3f, 1f)
            titleAnim.addListener(this)
            titleAnim.start()
        }

        two3TextView.setOnClickListener { TargetDialog(context!!).show() }
    }

    private fun titleAnimator() {
        thread {
            for ((i, c) in title.withIndex()) {
                Thread.sleep(500)
                activity?.runOnUiThread {
                    oneTextView.setText(c.toString())
                    if (i == title.length - 1) {
                        oneTextView.setTextColor(resources.getColor(R.color.colorAccent))
                        AnimatorUtils.createScale(oneTextView, 1000, 1f, 3f).start()
                    }
                }
            }
        }
    }

}