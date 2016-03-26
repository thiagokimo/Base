package io.kimo.base.example.ui.list;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.kimo.base.example.R;
import io.kimo.base.example.data.Student;
import io.kimo.base.example.ui.Router;
import io.kimo.base.v7.BaseAppCompatActivity;


public class StudentListActivity extends BaseAppCompatActivity<StudentListPresenter> implements StudentListContract.View {

    private ListView mList;
    private ProgressBar mProgress;
    private StudentListAdapter mAdapter;

    @Override
    public void showLoading() {
        mProgress.setVisibility(View.VISIBLE);
        mList.setVisibility(View.GONE);
    }

    @Override
    public void showList(List<Student> models) {
        mList.setVisibility(View.VISIBLE);
        mProgress.setVisibility(View.GONE);
        mAdapter.setData(models);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_list;
    }

    @Override
    public void mapUI(View view) {
        mList = (ListView) view.findViewById(R.id.list_view);
        mProgress = (ProgressBar) view.findViewById(R.id.progress_bar);
    }

    @Override
    public void configureUI() {
        mAdapter = new StudentListAdapter(this);
        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = mAdapter.getItem(position);
                Router.studentDetailScreen(StudentListActivity.this, student);
            }
        });
    }

    @Override
    public StudentListPresenter injectDependencies() {
        return new StudentListPresenter(this, this);
    }

    public class StudentListAdapter extends BaseAdapter {

        private List<Student> mData = new ArrayList<>();
        private LayoutInflater mLayoutInflater;

        public StudentListAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
        }

        public void setData(List<Student> newData) {
            mData.clear();
            mData.addAll(newData);

            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Student getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Student student = getItem(position);

            convertView = mLayoutInflater.inflate(R.layout.item_student, parent, false);
            ((TextView)convertView).setText(student.getName());

            return convertView;
        }
    }
}
