package io.kimo.base.utils.mvp.view;

import io.kimo.base.Base;

public interface LoadDataView extends Base.View {
    void showProgress();
    void hideProgress();

    void showRetry(String retryMsg);
    void hideRetry();

    void showView();
    void hideView();
}
