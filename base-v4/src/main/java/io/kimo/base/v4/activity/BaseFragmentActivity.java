package io.kimo.base.v4.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import io.kimo.base.AndroidViewContract;
import io.kimo.base.activity.ActivityLifeCycleFlow;
import io.kimo.base.presentation.mvp.Presenter;

public abstract class BaseFragmentActivity<P extends Presenter> extends FragmentActivity implements AndroidViewContract<P> {

    private ActivityLifeCycleFlow<P> mActivityLifeCycleFlow = new ActivityLifeCycleFlow<>(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLifeCycleFlow.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityLifeCycleFlow.onDestroy();
    }

    @Override
    public P getPresenter() {
        return mActivityLifeCycleFlow.getPresenter();
    }
}
