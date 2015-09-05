package io.kimo.base.presentation.mvp;

public abstract class BasePresenter<V extends View> implements Presenter {

    protected V view;

    public BasePresenter(V view) {
        this.view = view;
    }

    @Override
    public void createView() {
        hideAllViews();
    }

    protected abstract void hideAllViews();
}
