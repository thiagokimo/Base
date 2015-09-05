package io.kimo.base.presentation.mvp;

import io.kimo.base.presentation.ui.BaseFragment;

public abstract class BaseView<P extends BasePresenter> extends BaseFragment {

    protected P presenter;

    public abstract void instantiatePresenter();

    @Override
    public void startPresenter() {
        instantiatePresenter();
        presenter.createView();
    }

    @Override
    public void stopPresenter() {
        presenter.destroyView();
    }
}
