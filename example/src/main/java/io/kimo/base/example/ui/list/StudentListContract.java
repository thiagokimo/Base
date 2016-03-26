package io.kimo.base.example.ui.list;

import java.util.List;

import io.kimo.base.Base;
import io.kimo.base.example.data.Student;

public interface StudentListContract {

    interface View extends Base.View<StudentListPresenter> {
        void showLoading();
        void showList(List<Student> models);
    }

    interface Presenter {
        void fetchDataFromSomewhere();
        void populateListWithData();
    }
}
