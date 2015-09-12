package io.kimo.base.v7.presentation.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

public abstract class BaseActionBarActivity extends ActionBarActivity {

    public abstract int getLayoutResource();
    public abstract Fragment getMainFragment();
    public abstract int getMainFragmentContainerId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        addMainFragment();
    }

    private void addMainFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(getMainFragmentContainerId(), getMainFragment())
                .commit();
    }
}
