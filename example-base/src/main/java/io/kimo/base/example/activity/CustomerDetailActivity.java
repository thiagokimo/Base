package io.kimo.base.example.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import io.kimo.base.example.R;
import io.kimo.base.mvp.example.mapper.CustomerMapper;
import io.kimo.base.mvp.example.model.CustomerModel;
import io.kimo.base.mvp.example.presenter.CustomerDetailPresenter;
import io.kimo.base.mvp.example.view.CustomerDetailView;
import io.kimo.base.presentation.BaseActivity;

public class CustomerDetailActivity extends BaseActivity<CustomerDetailPresenter> implements CustomerDetailView {

    public static final String TAG = CustomerDetailActivity.class.getSimpleName();
    public static final String CUSTOMER_MODEL = TAG + ".CUSTOMER_MODEL";

    private CustomerModel model;

    private View mainView, progressView, retryView;
    private ImageView image;
    private TextView name, profession, retryText;
    private Button retryButton;

    @Override
    public int getLayoutResource() {
        return R.layout.customer_detail;
    }

    @Override
    public void mapUI(View view) {
        progressView = findViewById(R.id.view_loading);

        mainView = findViewById(R.id.main_view);
        image = (ImageView) mainView.findViewById(R.id.image);
        name = (TextView) mainView.findViewById(R.id.name);
        profession = (TextView) mainView.findViewById(R.id.profession);

        retryView = findViewById(R.id.view_retry);
        retryText = (TextView) retryView.findViewById(R.id.text);
        retryButton = (Button) retryView.findViewById(R.id.button);
    }

    @Override
    public void configureUI() {
        setTitle(model.getName());

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.destroyView();
                mPresenter.createView();
            }
        });
    }

    @Override
    public CustomerDetailPresenter instantiatePresenter() {

        Bundle args = getIntent().getExtras();

        if(args != null) {
            model = new CustomerMapper().deserializeModel(args.getString(CUSTOMER_MODEL));
        }

        return new CustomerDetailPresenter(model, this);
    }

    @Override
    public void updateBackground(String value) {
        Picasso.with(this)
                .load(value)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(image);
    }

    @Override
    public void updateName(String value) {
        name.setText(value);
    }

    @Override
    public void updateProfession(String value) {
        profession.setText(value);
    }

    @Override
    public void showProgress() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressView.setVisibility(View.GONE);
    }

    @Override
    public void showRetry(String retryMsg) {
        retryText.setText(retryMsg);
        retryView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        retryView.setVisibility(View.GONE);
    }

    @Override
    public void showView() {
        mainView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideView() {
        mainView.setVisibility(View.GONE);
    }

    public static void navigate(CustomerModel model, Context context) {

        Intent intent = new Intent(context, CustomerDetailActivity.class);
        intent.putExtra(CUSTOMER_MODEL, new CustomerMapper().serializeModel(model));

        context.startActivity(intent);
    }
}
