package com.ameng.android_animation_example.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;

import com.ameng.android_animation_example.R;
import com.ameng.android_animation_example.model.CustomAnimation;

/**
 * Created by ameng on 8/20/16.
 */
public class MainViewModel implements ViewModel {

    private final String TAG = MainViewModel.this.getClass().getName();
    private Context context;
    private DataListener dataListener;
    private AnimationListener animationListener;
    private CustomAnimation customAnimation;
    private AnimationSet animationSet;

    public ObservableField<String> introduction;

    public MainViewModel(Context context, DataListener dataListener, AnimationListener animationListener) {
        this.context = context;
        this.dataListener = dataListener;
        this.animationListener = animationListener;
        introduction = new ObservableField<>(context.getString(R.string.hello_world));
        animationSet = new AnimationSet(true);
        customAnimation = new CustomAnimation(context);
    }

    public void spinClick(View view) {
        checkAnimationSet();

        customAnimation.setAnimationScale(0, 1, 0, 1, 1000, 0, true, 0);
//        ca.setAnimationRotate(0f, 360f, 1000, 0, false, 0);
        customAnimation.setAnimationAlpha(0, 1, 1000, 0, true, 0);

//        animationSet.addAnimation(ca.getRotate());
        animationSet.addAnimation(customAnimation.getAnimationScale());
        animationSet.addAnimation(customAnimation.getAnimationAlpha());
        animationSet.setInterpolator(new LinearInterpolator());
        animationListener.onAnimationChanged(animationSet);
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
