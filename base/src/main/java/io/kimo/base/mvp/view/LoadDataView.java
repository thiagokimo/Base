package io.kimo.base.mvp.view;

import io.kimo.base.presentation.mvp.View;

public interface LoadDataView extends View {
    void showProgress();
    void hideProgress();

    void showRetry(String retryMsg);
    void hideRetry();
}
