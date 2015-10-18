package io.kimo.base.mvp.example.view;


import io.kimo.base.mvp.example.model.ExampleModel;
import io.kimo.base.presentation.mvp.view.LoadDataCollectionView;

public interface ExampleListView extends LoadDataCollectionView<ExampleModel> {
    void navigateToExampleDetailView(ExampleModel model);
}
