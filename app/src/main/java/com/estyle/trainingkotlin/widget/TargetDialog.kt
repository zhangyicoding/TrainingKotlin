package com.estyle.trainingkotlin.widget

import android.animation.Animator
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.estyle.trainingkotlin.R
import com.estyle.trainingkotlin.utils.AnimatorUtils

class TargetDialog(context: Context) : Dialog(context) {

    private lateinit var mContentView: View

    init {
        mContentView = LayoutInflater.from(context).inflate(R.layout.dialog_target, null)
        mContentView.findViewById<View>(R.id.btn).setOnClickListener { dismiss() }
        setContentView(mContentView)
        setCanceledOnTouchOutside(true)
    }

    override fun show() {
        super.show()
        showOrDismiss(true, 0f, 1f)

    }

    override fun dismiss() {
        showOrDismiss(false, 1f, 0f)
    }

    private fun showOrDismiss(isShow: Boolean, vararg values: Float) {
        val anim = AnimatorUtils.createScale(mContentView, 500, *values)
        if (!isShow) {
            anim.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    anim.removeListener(this)
                    super@TargetDialog.dismiss()
                }
            })
        }
    }

}