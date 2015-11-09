package io.kimo.base.presentation;

import android.view.View;

import io.kimo.base.presentation.mvp.Presenter;

public interface AndroidViewContract<P extends Presenter> {

    /* return your view's layout resource */
    int getLayoutResource();

    /* call all your findViewById in here */
    void mapUI(View view);

    /* configure everything related with your mapped views (adapters, click listeners, etc) */
    void configureUI();

    /* initialize your presenter in here.
    This is a temporary place where you need to deserialize your presenter arguments as well. */
    P instantiatePresenter();
}
