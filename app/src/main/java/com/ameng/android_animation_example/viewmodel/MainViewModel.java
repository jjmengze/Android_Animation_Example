package com.ameng.android_animation_example.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;

import com.ameng.android_animation_example.model.CustomAnimation;
import com.ameng.android_animation_example.R;

/**
 * Created by ameng on 8/20/16.
 */
public class MainViewModel implements ViewModel {

    private final String TAG = MainViewModel.this.getClass().getName();
    private Context context;
    private DataListener dataListener;
    public ObservableField<String> introduction;

    private CustomAnimation customAnimation;
    private AnimationSet animationSet;

    public MainViewModel(Context context, DataListener dataListener) {
        this.context = context;
        this.dataListener = dataListener;
        introduction = new ObservableField<>(context.getString(R.string.hello_world));
        animationSet = new AnimationSet(true);
        customAnimation = new CustomAnimation(context);
    }

    public void spinClick(View view) {
        checkAnimationSet();

//        ca.setAnimationScale(0, 1, 0, 1, 1000, 0, true, 0);
//        ca.setAnimationRotate(0f, 360f, 1000, 0, false, 0);
        customAnimation.setAnimationAlpha(0, 1, 1000, 0, true, 0);

//        animationSet.addAnimation(ca.getRotate());
//        animationSet.addAnimation(ca.getScale());
        animationSet.addAnimation(customAnimation.getAlpha());
        animationSet.setInterpolator(new LinearInterpolator());
        view.startAnimation(animationSet);
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

    @Override
    public void destroy() {

    }
}
