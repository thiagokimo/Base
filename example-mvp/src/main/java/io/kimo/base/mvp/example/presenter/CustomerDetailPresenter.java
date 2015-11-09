package io.kimo.base.mvp.example.presenter;


import io.kimo.base.mvp.example.model.CustomerModel;
import io.kimo.base.mvp.example.view.CustomerDetailView;
import io.kimo.base.presentation.mvp.BasePresenter;


public class CustomerDetailPresenter extends BasePresenter<CustomerDetailView> {

    private CustomerModel model;

    public CustomerDetailPresenter(CustomerModel model, CustomerDetailView view) {
        super(view);
        this.model = model;
    }

    @Override
    public void createView() {
        super.createView();

        view.showProgress();

        view.updateBackground(model.getBackgroundUrl());
        view.updateName(model.getName());
        view.updateProfession(model.getProfession());

        view.hideProgress();
        view.showView();
    }

    @Override
    protected void hideAllViews() {
        view.hideProgress();
        view.hideView();
    }

    @Override
    public void destroyView() {}
}
