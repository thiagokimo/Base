package io.kimo.base.v4.example.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import io.kimo.base.mvp.example.mapper.CustomerMapper;
import io.kimo.base.mvp.example.model.CustomerModel;
import io.kimo.base.mvp.example.presenter.CustomerDetailPresenter;
import io.kimo.base.mvp.example.view.CustomerDetailView;
import io.kimo.base.v4.example.R;
import io.kimo.base.v4.presentation.BaseSupportFragment;


public class CustomerDetailFragment extends BaseSupportFragment<CustomerDetailPresenter> implements CustomerDetailView {

    public static final String TAG = CustomerDetailFragment.class.getSimpleName();
    public static final String CUSTOMER_MODEL = TAG + ".CUSTOMER_MODEL";

    private CustomerModel model;

    private View mainView, progressView, retryView;
    private ImageView image;
    private TextView name, profession, retryText;
    private Button retryButton;

    public static CustomerDetailFragment newInstance(CustomerModel model) {

        Bundle args = new Bundle();
        args.putString(CUSTOMER_MODEL, new CustomerMapper().serializeModel(model));

        CustomerDetailFragment fragment = new CustomerDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public CustomerDetailPresenter instantiatePresenter() {

        Bundle args = getArguments();

        if(args != null) {
            model = new CustomerMapper().deserializeModel(args.getString(CUSTOMER_MODEL));
        }

        return new CustomerDetailPresenter(model, this);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_example_detail;
    }

    @Override
    public void mapUI(View view) {
        progressView = view.findViewById(R.id.view_loading);

        mainView = view.findViewById(R.id.main_view);
        image = (ImageView) mainView.findViewById(R.id.image);
        name = (TextView) mainView.findViewById(R.id.name);
        profession = (TextView) mainView.findViewById(R.id.profession);

        retryView = view.findViewById(R.id.view_retry);
        retryText = (TextView) retryView.findViewById(R.id.text);
        retryButton = (Button) retryView.findViewById(R.id.button);
    }

    @Override
    public void configureUI() {
        getActivity().setTitle(model.getName());

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.destroyView();
                presenter.createView();
            }
        });
    }

    @Override
    public void updateBackground(String value) {
        Picasso.with(getActivity()).load(value).memoryPolicy(MemoryPolicy.NO_CACHE).into(image);
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
}
