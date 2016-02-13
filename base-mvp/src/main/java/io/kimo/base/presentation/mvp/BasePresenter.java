package io.kimo.base.presentation.mvp;

public abstract class BasePresenter<V extends View> implements Presenter {

    protected V mView;

    public BasePresenter(V view) {
        this.mView = view;
    }

    @Override
    public void createView() {
        hideAllViews();
    }

    protected abstract void hideAllViews();
}
