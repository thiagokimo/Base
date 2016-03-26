package io.kimo.base.v4;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import io.kimo.base.Base;

public abstract class BaseFragmentActivity <P extends Base.Presenter>
        extends FragmentActivity
        implements Base.View<P> {

    private P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResource());
        mPresenter = injectDependencies();

        if(getPresenter() == null) {
            throw new IllegalArgumentException("You must inject the " +
                    "dependencies before retrieving the presenter");
        } else {
            mapUI(findViewById(android.R.id.content));
            configureUI();
        }

        mPresenter.createView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroyView();
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }
}
