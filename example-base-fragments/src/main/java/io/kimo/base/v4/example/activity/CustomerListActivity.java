package io.kimo.base.v4.example.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import io.kimo.base.v4.example.R;
import io.kimo.base.v4.example.fragment.CustomerListFragment;

public class CustomerListActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, CustomerListFragment.newInstance())
                .commit();
    }
}
