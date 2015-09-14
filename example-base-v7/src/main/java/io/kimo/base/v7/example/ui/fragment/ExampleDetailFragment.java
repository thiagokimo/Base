package io.kimo.base.v7.example.ui.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import io.kimo.base.v4.presentation.mvp.BaseView;
import io.kimo.base.v7.example.R;
import io.kimo.base.v7.example.mapper.ExampleMapper;
import io.kimo.base.v7.example.mvp.model.ExampleModel;
import io.kimo.base.v7.example.mvp.presenter.ExampleDetailPresenter;
import io.kimo.base.v7.example.mvp.view.ExampleDetailView;

public class ExampleDetailFragment extends BaseView<ExampleDetailPresenter> implements ExampleDetailView {

    public static final String TAG = ExampleDetailFragment.class.getSimpleName();
    public static final String EXAMPLE_MODEL = TAG + ".EXAMPLE_MODEL";

    private ExampleModel model;

    private View mainView, progressView, retryView;
    private ImageView image;
    private TextView name, profession, retryText;
    private Button retryButton;

    public static ExampleDetailFragment newInstance(ExampleModel model) {

        Bundle args = new Bundle();
        args.putString(EXAMPLE_MODEL, new ExampleMapper().serializeModel(model));

        ExampleDetailFragment fragment = new ExampleDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Bundle args = getArguments();

        if(args != null) {
            model = new ExampleMapper().deserializeModel(args.getString(EXAMPLE_MODEL));
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public void instantiatePresenter() {
        presenter = new ExampleDetailPresenter(model, this);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_example_detail;
    }

    @Override
    public void mapGUI(View view) {
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
    public void configureGUI() {
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
