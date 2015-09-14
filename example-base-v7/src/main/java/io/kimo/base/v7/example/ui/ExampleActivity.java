package io.kimo.base.v7.example.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import io.kimo.base.v7.example.R;
import io.kimo.base.v7.presentation.ui.BaseAppCompatActivity;

public abstract class ExampleActivity extends BaseAppCompatActivity{

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
}
