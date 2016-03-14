package io.kimo.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.kimo.base.AndroidViewContract;
import io.kimo.base.LifeCycleFlow;
import io.kimo.base.presentation.mvp.Presenter;

/**
 * Created by Kimo on 3/13/16.
 */
public class FragmentLifeCycleFlow<P extends Presenter> extends LifeCycleFlow<P> {
    private BaseFragment<P> mFragment;

    public FragmentLifeCycleFlow(AndroidViewContract<P> androidViewContract) {
        super(androidViewContract);
        mFragment = (BaseFragment<P>) androidViewContract;
    }

    @Override
    public P getPresenter() {
        return null;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(mAndroidViewContract.getLayoutResource(), container, false);
        mAndroidViewContract.mapUI(view);
        mAndroidViewContract.configureUI();

        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        mFragment.getPresenter().createView();
    }

    public void onDestroyView() {
        mFragment.getPresenter().destroyView();
    }
}
