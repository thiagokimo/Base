package io.kimo.base.example.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.kimo.base.example.R;
import io.kimo.base.example.adapter.CustomerListAdapter;
import io.kimo.base.mvp.example.model.CustomerModel;
import io.kimo.base.mvp.example.presenter.CustomerListPresenter;
import io.kimo.base.mvp.example.view.CustomerListView;
import io.kimo.base.presentation.BaseActivity;

public class CustomerListActivity extends BaseActivity<CustomerListPresenter> implements CustomerListView {

    private ListView list;
    private View loadingView, retryView, emptyView;

    private Button retryButton;
    private TextView retryText;

    private CustomerListAdapter adapter;

    @Override
    public int getLayoutResource() {
        return R.layout.activity_customer_list;
    }

    @Override
    public void mapUI(View view) {
        list = (ListView) findViewById(R.id.list);
        loadingView = findViewById(R.id.view_loading);

        emptyView = findViewById(R.id.view_empty);

        retryView = findViewById(R.id.view_retry);
        retryText = (TextView) retryView.findViewById(R.id.text);
        retryButton = (Button) retryView.findViewById(R.id.button);
    }

    @Override
    public void configureUI() {
        adapter = new CustomerListAdapter(this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.navigateToExampleDetailView(adapter.getItem(position));
            }
        });

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.destroyView();
                mPresenter.createView();
            }
        });
    }

    @Override
    public CustomerListPresenter instantiatePresenter() {
        return new CustomerListPresenter(this, this);
    }

    @Override
    public void navigateToExampleDetailView(CustomerModel model) {
        CustomerDetailActivity.navigate(model, this);
    }

    @Override
    public void showFeedback(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void renderCollection(List<CustomerModel> items) {
        adapter.setData(items);
    }

    @Override
    public void clearCollection() {
        adapter.clearData();
    }

    @Override
    public void showEmpty() {
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmpty() {
        emptyView.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loadingView.setVisibility(View.GONE);
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
        list.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideView() {
        list.setVisibility(View.GONE);
    }
}
