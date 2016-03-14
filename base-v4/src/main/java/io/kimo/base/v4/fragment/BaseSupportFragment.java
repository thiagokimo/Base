package io.kimo.base.v4.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.kimo.base.AndroidViewContract;
import io.kimo.base.presentation.mvp.Presenter;

public abstract class BaseSupportFragment<P extends Presenter> extends Fragment implements AndroidViewContract<P> {

    protected P mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);

        mPresenter = instantiatePresenter();
        if(mPresenter == null) {
            throw new IllegalArgumentException("mPresenter cannot be null");
        } else {
            mapUI(view);
            configureUI();
        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.createView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.destroyView();
    }
}
