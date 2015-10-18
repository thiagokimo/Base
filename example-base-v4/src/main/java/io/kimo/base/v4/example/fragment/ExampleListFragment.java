package io.kimo.base.v4.example.fragment;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.kimo.base.mvp.example.model.ExampleModel;
import io.kimo.base.mvp.example.presenter.ExampleListPresenter;
import io.kimo.base.mvp.example.view.ExampleListView;
import io.kimo.base.v4.example.R;
import io.kimo.base.v4.example.activity.ExampleDetailActivity;
import io.kimo.base.v4.example.adapter.ExampleListAdapter;
import io.kimo.base.v4.presentation.mvp.BaseView;


public class ExampleListFragment extends BaseView<ExampleListPresenter> implements ExampleListView {

    private ListView list;
    private View loadingView, retryView, emptyView;

    private Button retryButton;
    private TextView retryText;

    private ExampleListAdapter adapter;

    public static ExampleListFragment newInstance() {
        return new ExampleListFragment();
    }

    @Override
    public void instantiatePresenter() {
        presenter = new ExampleListPresenter(getActivity(), this);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_list;
    }

    @Override
    public void mapGUI(View view) {
        list = (ListView) view.findViewById(R.id.list);
        loadingView = view.findViewById(R.id.view_loading);

        emptyView = view.findViewById(R.id.view_empty);

        retryView = view.findViewById(R.id.view_retry);
        retryText = (TextView) retryView.findViewById(R.id.text);
        retryButton = (Button) retryView.findViewById(R.id.button);
    }

    @Override
    public void configureGUI() {

        adapter = new ExampleListAdapter(getActivity());
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.navigateToExampleDetailView(adapter.getItem(position));
            }
        });

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.destroyView();
                presenter.createView();
            }
        });
    }

    @Override
    public void showFeedback(String msg) {
        Context context = getActivity();

        if(context != null) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void renderCollection(List<ExampleModel> items) {
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

    @Override
    public void navigateToExampleDetailView(ExampleModel model) {
        ExampleDetailActivity.navigate(model, getActivity());
    }
}
