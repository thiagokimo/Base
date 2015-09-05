package io.kimo.base.v7.example.presentation.mvp.presenter;

import android.content.Context;

import java.util.List;

import io.kimo.base.domain.Callback;
import io.kimo.base.presentation.mvp.BasePresenter;
import io.kimo.base.v7.example.ExampleApp;
import io.kimo.base.v7.example.domain.entity.ExampleEntity;
import io.kimo.base.v7.example.domain.usecase.ExampleUseCase;
import io.kimo.base.v7.example.presentation.mapper.ExampleMapper;
import io.kimo.base.v7.example.presentation.mvp.model.ExampleModel;
import io.kimo.base.v7.example.presentation.mvp.view.ExampleListView;


public class ExampleListPresenter extends BasePresenter<ExampleListView> {

    private Context context;

    public ExampleListPresenter(Context context, ExampleListView view) {
        super(view);
        this.context = context;
    }

    @Override
    public void createView() {
        super.createView();

        view.showProgress();

        ExampleApp.JOB_MANAGER.execute(new ExampleUseCase(context, new Callback<List<ExampleEntity>>() {
            @Override
            public void onSuccess(List<ExampleEntity> result) {
                List<ExampleModel> models = new ExampleMapper().toModels(result);
                view.renderCollection(models);
                view.showView();
                view.hideProgress();
            }

            @Override
            public void onError(String error) {
                view.showFeedback(error);
                view.showRetry(error);
                view.hideProgress();
            }
        }));
    }

    @Override
    protected void hideAllViews() {
        view.hideView();
    }

    @Override
    public void destroyView() {view.clearCollection();}
}
