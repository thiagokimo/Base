package io.kimo.base.presentation.ui;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);
        mapGUI(view);
        configureGUI();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        startPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        stopPresenter();
    }

    public abstract int getLayoutResource();
    public abstract void mapGUI(View view);
    public abstract void configureGUI();

    public abstract void startPresenter();
    public abstract void stopPresenter();
}
