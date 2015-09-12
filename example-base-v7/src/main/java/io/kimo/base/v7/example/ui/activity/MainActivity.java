package io.kimo.base.v7.example.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import io.kimo.base.v7.example.R;
import io.kimo.base.v7.example.ui.fragment.ExampleListFragment;
import io.kimo.base.v7.presentation.ui.BaseAppCompatActivity;

public class MainActivity extends BaseAppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configureToolbar();
    }

    private void configureToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

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
