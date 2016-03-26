package io.kimo.base;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment <P extends Base.Presenter>
        extends Fragment
        implements Base.View<P> {

    private P mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);

        mPresenter = injectDependencies();

        if(getPresenter() == null) {
            throw new IllegalArgumentException("You must inject the " +
                    "dependencies before retrieving the presenter");
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
    public void onDestroy() {
        super.onDestroy();
        mPresenter.destroyView();
    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }
}
