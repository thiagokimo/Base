package io.kimo.base.activity;

import android.app.Activity;

import io.kimo.base.AndroidViewContract;
import io.kimo.base.LifeCycleFlow;
import io.kimo.base.presentation.mvp.Presenter;

public class ActivityLifeCycleFlow<P extends Presenter> extends LifeCycleFlow<P> {

    private Activity mActivity;

    public ActivityLifeCycleFlow(AndroidViewContract<P> androidViewContract) {
        super(androidViewContract);
        mActivity = (Activity) androidViewContract;
    }

    @Override
    public P getPresenter() {
        mPresenter = mAndroidViewContract.instantiatePresenter();

        if (mPresenter == null) {
            throw new IllegalArgumentException("mPresenter cannot be null");
        }

        return mAndroidViewContract.instantiatePresenter();
    }

    public void onCreate() {
        mActivity.setContentView(mAndroidViewContract.getLayoutResource());
        mAndroidViewContract.mapUI(mActivity.findViewById(android.R.id.content));
        mAndroidViewContract.configureUI();
        mPresenter.createView();
    }

    public void onDestroy() {
        mPresenter.destroyView();
    }
}
