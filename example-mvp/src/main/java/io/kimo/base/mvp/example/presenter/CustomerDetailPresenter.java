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

        mView.showProgress();

        mView.updateBackground(model.getBackgroundUrl());
        mView.updateName(model.getName());
        mView.updateProfession(model.getProfession());

        mView.hideProgress();
        mView.showView();
    }

    @Override
    protected void hideAllViews() {
        mView.hideProgress();
        mView.hideView();
    }

    @Override
    public void destroyView() {}
}
