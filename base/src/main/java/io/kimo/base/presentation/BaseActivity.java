package io.kimo.base.presentation;

import android.app.Activity;
import android.os.Bundle;

import io.kimo.base.presentation.mvp.Presenter;

public abstract class BaseActivity<P extends Presenter> extends Activity implements AndroidViewContract<P> {

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
