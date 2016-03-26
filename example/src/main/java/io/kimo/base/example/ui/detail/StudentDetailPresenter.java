package io.kimo.base.example.ui.detail;

import io.kimo.base.Presenter;
import io.kimo.base.example.data.Student;

public class StudentDetailPresenter extends Presenter<StudentDetailContract.View> implements StudentDetailContract.Presenter {

    private Student mStudent;

    public StudentDetailPresenter(StudentDetailContract.View view, Student student) {
        super(view);
        mStudent = student;
    }

    @Override
    public void createView() {
        getView().updateTitle(mStudent.getName());
        getView().updateImage(mStudent.getImageUrl());
        getView().updateName(mStudent.getName());
        getView().updateCourse(mStudent.getCourse());
        getView().updateDescription(mStudent.getDescription());
    }
}
