package io.kimo.base.v4.example.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import io.kimo.base.mvp.example.mapper.CustomerMapper;
import io.kimo.base.mvp.example.model.CustomerModel;
import io.kimo.base.v4.example.R;
import io.kimo.base.v4.example.fragment.CustomerDetailFragment;

public class CustomerDetailActivity extends FragmentActivity {

    public static final String TAG = CustomerDetailActivity.class.getSimpleName();
    public static final String CUSTOMER_MODEL = TAG + ".CUSTOMER_MODEL";

    private CustomerModel model;

    public static void navigate(CustomerModel model, Context context) {
        Intent intent = new Intent(context, CustomerDetailActivity.class);
        intent.putExtra(CUSTOMER_MODEL, new CustomerMapper().serializeModel(model));

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle args = getIntent().getExtras();

        if(args != null) {
            model = new CustomerMapper().deserializeModel(args.getString(CUSTOMER_MODEL));
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, CustomerDetailFragment.newInstance(model))
                .commit();
    }
}
