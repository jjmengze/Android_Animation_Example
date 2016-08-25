package com.ameng.android_animation_example.viewmodel;

import android.app.Activity;

/**
 * Created by ameng on 8/24/16.
 */
public class GithubSearcViewModel {
    private final String TAG = GithubSearcViewModel.this.getClass().getName();
    private Activity activity;
    private DataListener dataListener;

    public GithubSearcViewModel(Activity activity, DataListener dataListener) {
        this.activity = activity;
        this.dataListener = dataListener;
    }
}
