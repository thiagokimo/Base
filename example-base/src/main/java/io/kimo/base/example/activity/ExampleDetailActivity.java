package io.kimo.base.example.activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import io.kimo.base.example.R;
import io.kimo.base.example.fragment.ExampleDetailFragment;
import io.kimo.base.mvp.example.mapper.ExampleMapper;
import io.kimo.base.mvp.example.model.ExampleModel;
import io.kimo.base.presentation.ui.BaseActivity;

public class ExampleDetailActivity extends BaseActivity {

    public static final String TAG = ExampleDetailActivity.class.getSimpleName();
    public static final String EXAMPLE_MODEL = TAG + ".EXAMPLE_MODEL";

    private ExampleModel model;

    public static void navigate(ExampleModel model, Context context) {
        Intent intent = new Intent(context, ExampleDetailActivity.class);
        intent.putExtra(EXAMPLE_MODEL, new ExampleMapper().serializeModel(model));

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle args = getIntent().getExtras();

        if(args != null) {
            model = new ExampleMapper().deserializeModel(args.getString(EXAMPLE_MODEL));
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public Fragment getMainFragment() {
        return ExampleDetailFragment.newInstance(model);
    }

    @Override
    public int getMainFragmentContainerId() {
        return R.id.container;
    }
}
