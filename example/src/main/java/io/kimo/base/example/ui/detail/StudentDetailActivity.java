package io.kimo.base.example.ui.detail;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import io.kimo.base.example.R;
import io.kimo.base.example.data.Student;
import io.kimo.base.v7.BaseAppCompatActivity;

public class StudentDetailActivity extends BaseAppCompatActivity<StudentDetailPresenter> implements StudentDetailContract.View {

    public static final String TAG = StudentDetailActivity.class.getSimpleName();
    public static final String STUDENT = TAG + ".STUDENT";

    private ImageView mImage;
    private TextView mTitle, mSubtitle, mDescription;

    @Override
    public void updateTitle(String someTitle) {
        setTitle(someTitle);
    }

    @Override
    public void updateImage(String someUrl) {
        Picasso.with(this)
                .load(someUrl)
                .placeholder(R.drawable.ic_account_box_24dp)
                .error(R.drawable.ic_account_box_24dp)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(mImage);
    }

    @Override
    public void updateName(String someName) {
        mTitle.setText(someName);
    }

    @Override
    public void updateDescription(String someDescription) {
        mDescription.setText(someDescription);
    }

    @Override
    public void updateCourse(String someCourse) {
        mSubtitle.setText(someCourse);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_detail;
    }

    @Override
    public void mapUI(View view) {
        mImage = (ImageView) view.findViewById(R.id.image);
        mTitle = (TextView) view.findViewById(R.id.title);
        mSubtitle = (TextView) view.findViewById(R.id.subtitle);
        mDescription = (TextView) view.findViewById(R.id.description);
    }

    @Override
    public void configureUI() {}

    @Override
    public StudentDetailPresenter injectDependencies() {
        Student student = (Student) getIntent().getSerializableExtra(STUDENT);

        return new StudentDetailPresenter(this, student);
    }
}
