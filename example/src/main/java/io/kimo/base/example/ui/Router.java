package io.kimo.base.example.ui;

import android.content.Context;
import android.content.Intent;

import io.kimo.base.example.data.Student;
import io.kimo.base.example.ui.detail.StudentDetailActivity;

public class Router {
    public static void studentDetailScreen(Context context, Student student) {
        Intent intent = new Intent(context, StudentDetailActivity.class);
        intent.putExtra(StudentDetailActivity.STUDENT, student);
        context.startActivity(intent);
    }
}
