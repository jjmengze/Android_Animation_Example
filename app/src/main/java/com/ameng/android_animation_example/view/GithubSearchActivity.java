package com.ameng.android_animation_example.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ameng.android_animation_example.R;
import com.ameng.android_animation_example.databinding.GithubActivityMainBinding;
import com.ameng.android_animation_example.viewmodel.DataListener;
import com.ameng.android_animation_example.viewmodel.GithubSearcViewModel;

/**
 * Created by ameng on 8/24/16.
 */
public class GithubSearchActivity extends AppCompatActivity implements DataListener {
    private GithubActivityMainBinding binding;
    private GithubSearcViewModel githubSearcViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity_main);
        init();
    }

    private void init() {
        binding = DataBindingUtil.setContentView(this, R.layout.github_activity_main);
        githubSearcViewModel = new GithubSearcViewModel(this, this);
        binding.setViewModel(githubSearcViewModel);
    }


    @Override
    public void onRepositoriesChanged() {

    }
}
