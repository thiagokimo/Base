package io.kimo.base.v7.example.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import io.kimo.base.mvp.example.mapper.CustomerMapper;
import io.kimo.base.mvp.example.model.CustomerModel;
import io.kimo.base.v7.example.ExampleActivity;
import io.kimo.base.v7.example.R;
import io.kimo.base.v7.example.fragment.CustomerDetailFragment;


public class ExampleDetailActivity extends ExampleActivity {

    public static final String TAG = ExampleDetailActivity.class.getSimpleName();
    public static final String EXAMPLE_MODEL = TAG + ".EXAMPLE_MODEL";

    private CustomerModel model;

    public static void navigate(CustomerModel model, Context context) {
        Intent intent = new Intent(context, ExampleDetailActivity.class);
        intent.putExtra(EXAMPLE_MODEL, new CustomerMapper().serializeModel(model));

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle args = getIntent().getExtras();

        if(args != null) {
            model = new CustomerMapper().deserializeModel(args.getString(EXAMPLE_MODEL));
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public Fragment getMainFragment() {
        return CustomerDetailFragment.newInstance(model);
    }

    @Override
    public int getMainFragmentContainerId() {
        return R.id.container;
    }
}
