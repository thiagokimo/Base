package io.kimo.base.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.kimo.base.AndroidViewContract;
import io.kimo.base.presentation.mvp.Presenter;

public abstract class BaseFragment<P extends Presenter> extends Fragment implements AndroidViewContract<P> {

    private FragmentLifeCycleFlow<P> mFragmentLifeCycleFlow = new FragmentLifeCycleFlow<>(this);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return mFragmentLifeCycleFlow.onCreateView(inflater, container);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragmentLifeCycleFlow.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mFragmentLifeCycleFlow.onDestroyView();
    }

    public void setFragmentLifeCycleFlow(FragmentLifeCycleFlow<P> fragmentLifeCycleFlow) {
        mFragmentLifeCycleFlow = fragmentLifeCycleFlow;
    }

    @Override
    public P getPresenter() {
        return mFragmentLifeCycleFlow.getPresenter();
    }
}
