package io.kimo.base.mvp.example.view;


import io.kimo.base.presentation.mvp.view.LoadDataView;

public interface ExampleDetailView extends LoadDataView {
    void updateBackground(String value);
    void updateName(String value);
    void updateProfession(String value);
}
