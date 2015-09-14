package io.kimo.base.example.mvp.view;

import io.kimo.base.example.mvp.model.ExampleModel;
import io.kimo.base.presentation.mvp.view.LoadDataCollectionView;

public interface ExampleListView extends LoadDataCollectionView<ExampleModel> {
    void navigateToExampleDetailView(ExampleModel model);
}
