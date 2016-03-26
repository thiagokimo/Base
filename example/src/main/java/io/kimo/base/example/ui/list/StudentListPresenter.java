package io.kimo.base.example.ui.list;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.kimo.base.Presenter;
import io.kimo.base.example.data.Student;
import io.kimo.lib.faker.Faker;

public class StudentListPresenter extends Presenter<StudentListContract.View> implements StudentListContract.Presenter {

    private Context mContext;
    private List<Student> mStudents = new ArrayList<>();

    public StudentListPresenter(StudentListContract.View view, Context context) {
        super(view);
        mContext = context;
    }

    @Override
    public void createView() {
        getView().showLoading();
        fetchDataFromSomewhere();
    }

    @Override
    public void destroyView() {}

    @Override
    public void fetchDataFromSomewhere() {
        mStudents.clear();

        Faker faker = Faker.with(mContext);

        for(int i = 0; i < 30; i++) {
            String name = faker.Name.fullName();
            String description = faker.Lorem.paragraph();
            String course = faker.Name.title();
            String imageUrl = faker.Url.avatar();
            mStudents.add(new Student(name,description, imageUrl, course));
        }

        populateListWithData();
    }

    @Override
    public void populateListWithData() {
        getView().showList(mStudents);
    }
}
