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
import kotlinx.android.synthetic.main.fragment_03.*
import kotlin.concurrent.thread

class No03Fragment : BaseFragment() {
    override fun onAnimEnd(animation: Animator) {
        when ((animation as ObjectAnimator).target) {
            rightTwo01TV -> {
                rightTwo02TV.visibility = View.VISIBLE
            }
            rightTwo02TV -> {
                rightTwo03TV.visibility = View.VISIBLE
            }
        }
    }

    override var mPage: Int
        get() = 3
        set(value) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_03, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rightOne01TV.setOnClickListener {
            val two1Anim = AnimatorUtils.createTranslationLeft2Right(rightTwo01TV, activity)
            val two2Anim = AnimatorUtils.createTranslationRight2Left(rightTwo02TV, activity)
            val two3Anim = AnimatorUtils.createTranslationLeft2Right(rightTwo03TV, activity)

            two1Anim.addListener(this)
            two2Anim.addListener(this)
            two3Anim.addListener(this)

            AnimatorSet().apply {
                playSequentially(two1Anim, two2Anim, two3Anim)
                duration = 1000
                rightTwo01TV.visibility = View.VISIBLE
                start()
            }
        }
    }

    override fun onTitleClick() {
//        val oneAnim = AnimatorUtils.createTranslationBottom2Top(rightOne01TV, activity)
//        oneAnim.duration = 1000
//        rightOne01TV.visibility = View.VISIBLE
//        oneAnim.start()

        showTitleByEveryWord()
    }

    private fun showTitleByEveryWord() {
//        val title = """为啥要学Kotlin开发Android——为了替换Java。
//                        |Java说它不服，接下来我们让它死得明白""".trimMargin()
        val title = "为啥要学Kotlin开发Android——为了替换Java。"

        val sb = StringBuilder()
        rightOne01TV.visibility = View.VISIBLE
        thread {
            title.forEach {
                Thread.sleep(100)
                sb.append(it)
                activity?.runOnUiThread { rightOne01TV.text = sb.toString() }
            }
        }
    }
}