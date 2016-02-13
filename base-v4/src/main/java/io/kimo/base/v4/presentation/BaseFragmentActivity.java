package io.kimo.base.v4.presentation;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import io.kimo.base.presentation.AndroidViewContract;
import io.kimo.base.presentation.mvp.Presenter;

public abstract class BaseFragmentActivity<P extends Presenter> extends FragmentActivity implements AndroidViewContract<P> {

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
