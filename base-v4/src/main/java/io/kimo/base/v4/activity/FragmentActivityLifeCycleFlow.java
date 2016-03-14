package io.kimo.base.v4.activity;

import io.kimo.base.AndroidViewContract;
import io.kimo.base.LifeCycleFlow;
import io.kimo.base.presentation.mvp.Presenter;

public class FragmentActivityLifeCycleFlow<P extends Presenter> extends LifeCycleFlow<P> {

    private BaseFragmentActivity<P> mActivity;

    public FragmentActivityLifeCycleFlow(AndroidViewContract<P> androidViewContract) {
        super(androidViewContract);
        mActivity = (BaseFragmentActivity<P>) androidViewContract;
    }


}
