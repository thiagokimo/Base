package io.kimo.base.presentation.mvp.view;

import io.kimo.base.presentation.mvp.Model;

public interface LoadDataCollectionView<M extends Model> extends LoadDataView, CollectionView<M> {
    void showFeedback(String msg);
}
