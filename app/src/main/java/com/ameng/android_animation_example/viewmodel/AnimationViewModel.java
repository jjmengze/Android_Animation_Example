package com.ameng.android_animation_example.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;

import com.ameng.android_animation_example.R;
import com.ameng.android_animation_example.model.CustomAnimation;
import com.ameng.android_animation_example.view.GithubSearchActivity;

/**
 * Created by ameng on 8/20/16.
 */
public class AnimationViewModel implements ViewModel {

    private final String TAG = AnimationViewModel.this.getClass().getName();
    private Activity activity;
    private DataListener dataListener;
    private AnimationListener animationListener;
    private CustomAnimation customAnimation;
    private AnimationSet animationSet;
    private Intent intent;
    public ObservableField<String> introduction;

    public AnimationViewModel(Activity activity, DataListener dataListener, AnimationListener animationListener) {
        this.activity = activity;
        this.dataListener = dataListener;
        this.animationListener = animationListener;
        introduction = new ObservableField<>(activity.getString(R.string.hello_world));
        animationSet = new AnimationSet(true);
        customAnimation = new CustomAnimation(activity);
        intent = new Intent(activity, GithubSearchActivity.class);
    }

    public void spinClick(View view) {
        checkAnimationSet();

        customAnimation.setAnimationScale(0, 1, 0, 1, 1000, 0, true, 0);
        customAnimation.setAnimationRotate(0f, 360f, 1000, 0, false, 0);
        customAnimation.setAnimationAlpha(0, 1, 1000, 0, true, 0);

        animationSet.addAnimation(customAnimation.getAnimationRotate());
        animationSet.addAnimation(customAnimation.getAnimationScale());
        animationSet.addAnimation(customAnimation.getAnimationAlpha());
        animationSet.setInterpolator(new LinearInterpolator());
        animationListener.onAnimationChanged(animationSet);
    }

    public void scalingClick(View view) {
        activity.startActivity(intent);
        /**
         * 第1個參數為下1個Activity進入的動畫,第2個參數為上1個Activity離開的動畫
         */
        activity.overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
    }

    private void checkAnimationSet() {
        if (animationSet != null) {
            animationSet = null;
            animationSet = new AnimationSet(false);
        }
    }

    public void setDataListener(DataListener dataListener) {
        this.dataListener = dataListener;
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.animationListener = animationListener;
    }

    @Override
    public void destroy() {

    }
}
