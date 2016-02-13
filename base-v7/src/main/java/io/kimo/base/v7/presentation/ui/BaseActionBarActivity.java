package io.kimo.base.v7.presentation.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import io.kimo.base.presentation.AndroidViewContract;
import io.kimo.base.presentation.mvp.Presenter;

public abstract class BaseActionBarActivity<P extends Presenter> extends ActionBarActivity implements AndroidViewContract<P> {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        mPresenter = instantiatePresenter();

        if(mPresenter == null) {
            throw new IllegalArgumentException("mPresenter cannot be null");
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
}
