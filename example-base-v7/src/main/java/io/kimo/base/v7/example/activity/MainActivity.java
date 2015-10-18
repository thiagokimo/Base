package io.kimo.base.v7.example.activity;

import android.support.v4.app.Fragment;

import io.kimo.base.v7.example.ExampleActivity;
import io.kimo.base.v7.example.R;
import io.kimo.base.v7.example.fragment.ExampleListFragment;

public class MainActivity extends ExampleActivity {

    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public Fragment getMainFragment() {
        return ExampleListFragment.newInstance();
    }

    @Override
    public int getMainFragmentContainerId() {
        return R.id.container;
    }
}
