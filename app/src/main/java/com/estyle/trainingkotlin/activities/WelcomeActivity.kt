package com.estyle.trainingkotlin.activities

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.CardView
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView

import com.estyle.trainingkotlin.R


class WelcomeActivity : BaseActivity(), OnClickListener {

    protected lateinit var mFab: FloatingActionButton
    protected lateinit var mMLogoImageView: AppCompatImageView
    protected lateinit var mCardView: CardView
    protected lateinit var mTitleTv: AppCompatTextView
    protected lateinit var mSubtitleTv: AppCompatTextView
    protected lateinit var mTitlebar: View
    private var mTitleView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_welcome)
        initView()
    }

    private fun initView() {
        mTitleView = findViewById<View>(R.id.titleView) as ImageView
        mFab = findViewById<View>(R.id.fab) as FloatingActionButton
        mFab.setOnClickListener(this@WelcomeActivity)
        mMLogoImageView = findViewById<View>(R.id.mLogoImageView) as AppCompatImageView
        mCardView = findViewById<View>(R.id.card_view) as CardView
        mTitleTv = findViewById<View>(R.id.title_tv) as AppCompatTextView
        mSubtitleTv = findViewById<View>(R.id.subtitle_tv) as AppCompatTextView
        mTitlebar = findViewById(R.id.titlebar) as View
        mTitlebar.setOnClickListener(this@WelcomeActivity)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.titlebar) {
            showLogoAnimation()
        } else if (view.id == R.id.fab) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun showLogoAnimation() {
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 0f, 1.6f, 1f)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 0f, 1.6f, 1f)
        val cardAnim = ObjectAnimator.ofPropertyValuesHolder(mCardView, scaleX, scaleY)
                .setDuration(2000)

        val logoAnim = AnimatorInflater.loadAnimator(this, R.animator.rotate500) as ObjectAnimator
        logoAnim.target = mMLogoImageView

        val titleAnim = AnimatorInflater.loadAnimator(this, R.animator.alpha_500) as ObjectAnimator
        titleAnim.target = mTitleTv

        val subtitleAnim = AnimatorInflater.loadAnimator(this, R.animator.alpha_500) as ObjectAnimator
        subtitleAnim.target = mSubtitleTv

        subtitleAnim.addListener(this)

        val animSet = AnimatorSet()
        animSet.playSequentially(cardAnim, logoAnim, titleAnim, subtitleAnim)
        mCardView.visibility = View.VISIBLE
        animSet.start()
    }

    override fun onAnimEnd(animation: Animator?) {
        val fabAnim = AnimatorInflater.loadAnimator(this, R.animator.alpha_500) as ObjectAnimator
        fabAnim.target = mFab
        fabAnim.start()
    }
}
