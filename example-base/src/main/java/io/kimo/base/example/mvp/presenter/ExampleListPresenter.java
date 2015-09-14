package io.kimo.base.example.mvp.presenter;

import android.content.Context;

import java.util.List;

import io.kimo.base.domain.Callback;
import io.kimo.base.domain.example.entity.ExampleEntity;
import io.kimo.base.domain.example.usecase.ExampleUseCase;
import io.kimo.base.example.ExampleApp;
import io.kimo.base.example.mapper.ExampleMapper;
import io.kimo.base.example.mvp.model.ExampleModel;
import io.kimo.base.example.mvp.view.ExampleListView;
import io.kimo.base.presentation.mvp.BasePresenter;


public class ExampleListPresenter extends BasePresenter<ExampleListView> {

    private Context context;

    public ExampleListPresenter(Context context, ExampleListView view) {
        super(view);
        this.context = context;
    }

    public void navigateToExampleDetailView(ExampleModel model) {
        view.navigateToExampleDetailView(model);
    }

    @Override
    public void createView() {
        super.createView();

        view.showProgress();

        ExampleApp.JOB_MANAGER.execute(new ExampleUseCase(context, new Callback<List<ExampleEntity>>() {
            @Override
            public void onSuccess(List<ExampleEntity> result) {
                List<ExampleModel> models = new ExampleMapper().toModels(result);

                if(models.isEmpty()) {
                    view.hideProgress();
                    view.showEmpty();

                    view.showFeedback("Execute it again.");
                } else {
                    view.renderCollection(models);
                    view.showView();
                    view.hideProgress();
                }
            }

            @Override
            public void onError(String error) {
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
