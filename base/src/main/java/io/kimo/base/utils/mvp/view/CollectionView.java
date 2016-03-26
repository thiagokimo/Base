package io.kimo.base.utils.mvp.view;

import java.util.List;

import io.kimo.base.Base;
import io.kimo.base.utils.mvp.Model;


public interface CollectionView<M extends Model> extends Base.View {
    void renderCollection(List<M> items);
    void clearCollection();

    void showEmpty();
    void hideEmpty();
}
