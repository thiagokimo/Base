package io.kimo.base.v4.presentation.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public abstract class BaseFragmentActivity extends FragmentActivity {

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
