package io.kimo.base;

import io.kimo.base.presentation.mvp.Presenter;

public abstract class LifeCycleFlow<P extends Presenter> {

    protected AndroidViewContract<P> mAndroidViewContract;
    protected P mPresenter;

    public LifeCycleFlow(AndroidViewContract<P> androidViewContract) {
        mAndroidViewContract = androidViewContract;
    }

    public abstract P getPresenter();
}
