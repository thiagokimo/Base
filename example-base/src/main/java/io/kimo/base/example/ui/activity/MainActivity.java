package io.kimo.base.example.ui.activity;

import android.app.Fragment;

import io.kimo.base.example.R;
import io.kimo.base.example.ui.fragment.ExampleListFragment;
import io.kimo.base.presentation.ui.BaseActivity;

public class MainActivity extends BaseActivity {

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
