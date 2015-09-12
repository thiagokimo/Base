package io.kimo.base.v4.example.ui.activity;

import android.support.v4.app.Fragment;

import io.kimo.base.v4.example.R;
import io.kimo.base.v4.example.ui.fragment.ExampleListFragment;
import io.kimo.base.v4.presentation.ui.BaseFragmentActivity;

public class MainActivity extends BaseFragmentActivity {

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
