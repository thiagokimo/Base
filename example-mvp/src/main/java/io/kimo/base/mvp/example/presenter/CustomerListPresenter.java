package io.kimo.base.mvp.example.presenter;

import android.content.Context;

import java.util.List;
import java.util.concurrent.Executors;

import io.kimo.base.domain.Callback;
import io.kimo.base.domain.example.entity.CostumerEntity;
import io.kimo.base.domain.example.usecase.GetCostumersUseCase;
import io.kimo.base.mvp.example.mapper.CustomerMapper;
import io.kimo.base.mvp.example.model.CustomerModel;
import io.kimo.base.mvp.example.view.CustomerListView;
import io.kimo.base.presentation.mvp.BasePresenter;



public class CustomerListPresenter extends BasePresenter<CustomerListView> {

    private Context context;

    public CustomerListPresenter(Context context, CustomerListView view) {
        super(view);
        this.context = context;
    }

    public void navigateToExampleDetailView(CustomerModel model) {
        view.navigateToExampleDetailView(model);
    }

    @Override
    public void createView() {
        super.createView();

        view.showProgress();

        Executors.newSingleThreadExecutor().execute(new GetCostumersUseCase(context, new Callback<List<CostumerEntity>>() {
            @Override
            public void onSuccess(List<CostumerEntity> result) {
                List<CustomerModel> models = new CustomerMapper().toModels(result);

                if (models.isEmpty()) {
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
