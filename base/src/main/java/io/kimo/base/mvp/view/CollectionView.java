package io.kimo.base.mvp.view;

import java.util.List;

import io.kimo.base.presentation.mvp.Model;
import io.kimo.base.presentation.mvp.View;

public interface CollectionView<M extends Model> extends View {
    void renderCollection(List<M> items);
    void clearCollection();

    void showEmpty();
    void hideEmpty();
}
