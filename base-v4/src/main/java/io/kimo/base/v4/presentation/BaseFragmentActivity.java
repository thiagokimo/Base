package io.kimo.base.v4.presentation;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import io.kimo.base.presentation.AndroidViewContract;
import io.kimo.base.presentation.mvp.Presenter;

public abstract class BaseFragmentActivity<P extends Presenter> extends FragmentActivity implements AndroidViewContract<P> {

    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        presenter = instantiatePresenter();

        if(presenter == null) {
            throw new IllegalArgumentException("presenter cannot be null");
        } else {
            mapUI(findViewById(android.R.id.content));
            configureUI();
        }

        presenter.createView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroyView();
    }
}
