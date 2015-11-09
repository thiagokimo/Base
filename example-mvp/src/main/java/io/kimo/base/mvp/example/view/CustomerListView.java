package io.kimo.base.mvp.example.view;


import io.kimo.base.mvp.example.model.CustomerModel;
import io.kimo.base.presentation.mvp.view.LoadDataCollectionView;

public interface CustomerListView extends LoadDataCollectionView<CustomerModel> {
    void navigateToExampleDetailView(CustomerModel model);
}
