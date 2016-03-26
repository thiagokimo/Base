package io.kimo.base;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity <P extends Base.Presenter>
        extends Activity
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
