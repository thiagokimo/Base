package io.kimo.base.v7.example.mvp.presenter;


import io.kimo.base.presentation.mvp.BasePresenter;
import io.kimo.base.v7.example.mvp.model.ExampleModel;
import io.kimo.base.v7.example.mvp.view.ExampleDetailView;

public class ExampleDetailPresenter extends BasePresenter<ExampleDetailView> {

    private ExampleModel model;

    public ExampleDetailPresenter(ExampleModel model, ExampleDetailView view) {
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
