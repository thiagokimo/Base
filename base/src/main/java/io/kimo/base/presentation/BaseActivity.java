package io.kimo.base.presentation;

import android.app.Activity;
import android.os.Bundle;

import io.kimo.base.presentation.mvp.Presenter;

public abstract class BaseActivity<P extends Presenter> extends Activity implements AndroidViewContract<P> {

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
