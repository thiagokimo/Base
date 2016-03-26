package io.kimo.base.example.ui.detail;

import io.kimo.base.Base;

public interface StudentDetailContract {

    interface View extends Base.View<StudentDetailPresenter>{
        void updateTitle(String someTitle);
        void updateImage(String someUrl);
        void updateName(String someName);
        void updateDescription(String someDescription);
        void updateCourse(String someCourse);
    }

    interface Presenter extends Base.Presenter{}
}
