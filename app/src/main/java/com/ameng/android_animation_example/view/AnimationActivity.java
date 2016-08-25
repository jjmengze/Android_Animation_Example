package com.ameng.android_animation_example.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;

import com.ameng.android_animation_example.R;
import com.ameng.android_animation_example.databinding.AnimationActivityMainBinding;
import com.ameng.android_animation_example.viewmodel.AnimationListener;
import com.ameng.android_animation_example.viewmodel.AnimationViewModel;
import com.ameng.android_animation_example.viewmodel.DataListener;

public class AnimationActivity extends AppCompatActivity implements DataListener, AnimationListener {
    private AnimationActivityMainBinding binding;
    private AnimationViewModel animationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity_main);
        init();
    }

    private void init() {
        binding = DataBindingUtil.setContentView(this, R.layout.animation_activity_main);
        animationViewModel = new AnimationViewModel(this, this, this);
        binding.setViewModel(animationViewModel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        animationViewModel.destroy();
    }

    @Override
    public void onRepositoriesChanged() {

    }

    @Override
    public void onAnimationChanged(Animation animationSet) {
        binding.text.startAnimation(animationSet);
    }
}
