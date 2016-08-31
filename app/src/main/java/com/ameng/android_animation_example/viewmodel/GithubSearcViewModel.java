package com.ameng.android_animation_example.viewmodel;

import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.ameng.android_animation_example.R;

/**
 * Created by ameng on 8/24/16.
 */
public class GithubSearcViewModel {
    private final String TAG = GithubSearcViewModel.this.getClass().getName();
    private Activity activity;
    private DataListener dataListener;

    public ObservableInt infoMessageVisibility;
    public ObservableInt progressVisibility;
    public ObservableInt recyclerViewVisibility;
    public ObservableInt searchButtonVisibility;
    public ObservableField<String> infoMessage;

    public GithubSearcViewModel(Activity activity, DataListener dataListener) {
        this.activity = activity;
        this.dataListener = dataListener;
        infoMessage = new ObservableField<>(activity.getString(R.string.default_info_message));
        infoMessageVisibility = new ObservableInt(View.VISIBLE);
        progressVisibility = new ObservableInt(View.INVISIBLE);
        recyclerViewVisibility = new ObservableInt(View.INVISIBLE);
        searchButtonVisibility = new ObservableInt(View.GONE);
    }

    public boolean onSearchAction(TextView view, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            String username = view.getText().toString();
            if (username.length() > 0)
                loadGithubRepos(username);
            return true;
        }
        return false;
    }

    public TextWatcher onUsernameEditTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
    }


    private void loadGithubRepos(String username) {

    }
}
