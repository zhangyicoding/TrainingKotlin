package com.estyle.trainingkotlin.activities;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.estyle.trainingkotlin.R;


public class WelcomeActivity extends BaseActivity implements OnClickListener {

    protected FloatingActionButton mFab;
    protected AppCompatImageView mMLogoImageView;
    protected CardView mCardView;
    protected AppCompatTextView mTitleTv;
    protected AppCompatTextView mSubtitleTv;
    protected FrameLayout mTitlebar;
    private ImageView mTitleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_welcome);
        initView();
    }

    private void initView() {
        mTitleView = (ImageView) findViewById(R.id.titleView);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(WelcomeActivity.this);
        mMLogoImageView = (AppCompatImageView) findViewById(R.id.mLogoImageView);
        mCardView = (CardView) findViewById(R.id.card_view);
        mTitleTv = (AppCompatTextView) findViewById(R.id.title_tv);
        mSubtitleTv = (AppCompatTextView) findViewById(R.id.subtitle_tv);
        mTitlebar = (FrameLayout) findViewById(R.id.titlebar);
        mTitlebar.setOnClickListener(WelcomeActivity.this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.titlebar) {
            showLogoAnimation();
        } else if (view.getId() == R.id.fab) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    private void showLogoAnimation() {
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0, 1.6f, 1);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0, 1.6f, 1);
        ObjectAnimator cardAnim = ObjectAnimator.ofPropertyValuesHolder(mCardView, scaleX, scaleY)
                .setDuration(2000);

        ObjectAnimator logoAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.rotate500);
        logoAnim.setTarget(mMLogoImageView);

        ObjectAnimator titleAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.alpha_500);
        titleAnim.setTarget(mTitleTv);

        ObjectAnimator subtitleAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.alpha_500);
        subtitleAnim.setTarget(mSubtitleTv);

        subtitleAnim.addListener(this);

        AnimatorSet animSet = new AnimatorSet();
        animSet.playSequentially(cardAnim, logoAnim, titleAnim, subtitleAnim);
        mCardView.setVisibility(View.VISIBLE);
        animSet.start();
    }

    @Override
    protected void onAnimEnd(@org.jetbrains.annotations.Nullable Animator animation) {
        ObjectAnimator fabAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.alpha_500);
        fabAnim.setTarget(mFab);
        fabAnim.start();
    }
}
