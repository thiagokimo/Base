package io.kimo.base.activity;

import android.app.Activity;
import android.os.Bundle;

import io.kimo.base.AndroidViewContract;
import io.kimo.base.presentation.mvp.Presenter;

public abstract class BaseActivity<P extends Presenter> extends Activity implements AndroidViewContract<P> {

    private ActivityLifeCycleFlow<P> mActivityLifeCycleFlow = new ActivityLifeCycleFlow<>(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLifeCycleFlow.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityLifeCycleFlow.onDestroy();
    }

    public void setActivityLifeCycleFlow(ActivityLifeCycleFlow<P> activityLifeCycleFlow) {
        this.mActivityLifeCycleFlow = activityLifeCycleFlow;
    }

    @Override
    public P getPresenter() {
        return mActivityLifeCycleFlow.getPresenter();
    }
}
