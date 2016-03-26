package io.kimo.base.utils.mvp;

import io.kimo.base.Base;

public abstract class BasePresenter<V extends Base.View> implements Base.Presenter {

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
