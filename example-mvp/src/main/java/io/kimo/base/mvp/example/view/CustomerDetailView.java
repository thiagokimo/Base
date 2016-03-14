package io.kimo.base.mvp.example.view;


import io.kimo.base.mvp.view.LoadDataView;

public interface CustomerDetailView extends LoadDataView {
    void updateBackground(String value);
    void updateName(String value);
    void updateProfession(String value);
}
