package com.estyle.trainingkotlin.utils;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;

public class AnimatorUtils {

    public static ObjectAnimator createTranslationLeft2Right(View target, Activity activity) {
        int[] wh = getScreenWidthAndHeight(activity);
        int horizontalCenter = (wh[0] - target.getWidth()) / 2;
        return ObjectAnimator.ofFloat(target, "translationX", -target.getWidth(), horizontalCenter);
    }

    public static ObjectAnimator createTranslationRight2Left(View target, Activity activity) {
        int[] ints = getScreenWidthAndHeight(activity);
        int horizontalCenter = (ints[0] - target.getWidth()) / 2;
        return ObjectAnimator.ofFloat(target, "translationX", ints[0] + target.getWidth(), horizontalCenter);
    }

    public static ObjectAnimator createTranslationTop2Bottom(View target) {
        return ObjectAnimator.ofFloat(target, "translationY", -target.getWidth(), target.getX());
    }

    public static ObjectAnimator createTranslationBottom2Top(View target, Activity activity) {
        int[] ints = getScreenWidthAndHeight(activity);
        return ObjectAnimator.ofFloat(target, "translationY", ints[1] + target.getHeight(), target.getX());
    }

    public static ObjectAnimator createAlphaDouble(View target) {
        return ObjectAnimator.ofFloat(target, "alpha", 0, 1, 0, 1, 0, 1).setDuration(3000);
    }

    public static ObjectAnimator createScleAndAlpha(View target) {
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 0, 1);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0, 1);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0, 1);
        return ObjectAnimator.ofPropertyValuesHolder(target, alpha, scaleX, scaleY);
    }

    public static ObjectAnimator createRotation10Times(View target) {
        return ObjectAnimator.ofFloat(target, "rotationY", 0, 360);
    }

    public static ObjectAnimator createScale(View target, long duration, float... values) {
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", values);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", values);
        ObjectAnimator anim = ObjectAnimator.ofPropertyValuesHolder(target, scaleX, scaleY)
                .setDuration(duration);
        return anim;
    }

    public static ObjectAnimator createRotationX(View target) {
        ObjectAnimator rotationX = ObjectAnimator.ofFloat(target, "rotationX", 360, 0)
                .setDuration(1000);
        rotationX.setRepeatCount(1);
        rotationX.setInterpolator(new DecelerateInterpolator());
        return rotationX;
    }

    public static int[] getScreenWidthAndHeight(Activity activity) {
        WindowManager wm = activity.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        return new int[]{width, height};
    }
}
