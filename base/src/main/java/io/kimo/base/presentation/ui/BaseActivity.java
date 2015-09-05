package io.kimo.base.presentation.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;


public abstract class BaseActivity extends Activity {

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
        getFragmentManager()
                .beginTransaction()
                .replace(getMainFragmentContainerId(), getMainFragment())
                .commit();
    }
}
