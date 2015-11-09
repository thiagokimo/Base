package io.kimo.base.v7.presentation.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.kimo.base.presentation.AndroidViewContract;
import io.kimo.base.presentation.mvp.Presenter;


public abstract class BaseAppCompatActivity<P extends Presenter> extends AppCompatActivity implements AndroidViewContract<P>{

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
