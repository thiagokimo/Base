package io.kimo.base.utils.mvp.view;


import io.kimo.base.utils.mvp.Model;

public interface LoadDataCollectionView<M extends Model> extends LoadDataView, CollectionView<M> {
    void showFeedback(String msg);
}
