package com.ameng.android_animation_example.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnimationSet;

import com.ameng.android_animation_example.R;
import com.ameng.android_animation_example.databinding.ActivityMainBinding;
import com.ameng.android_animation_example.viewmodel.AnimationListener;
import com.ameng.android_animation_example.viewmodel.DataListener;
import com.ameng.android_animation_example.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements DataListener, AnimationListener {
    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(this, this, this);
        binding.setViewModel(mainViewModel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainViewModel.destroy();
    }

    @Override
    public void onRepositoriesChanged() {

    }

    @Override
    public void onAnimationChanged(AnimationSet animationSet) {
        binding.text.startAnimation(animationSet);
    }
}
