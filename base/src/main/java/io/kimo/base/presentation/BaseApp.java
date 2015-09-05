package io.kimo.base.presentation;

import android.app.Application;

import java.util.concurrent.ExecutorService;

public abstract class BaseApp extends Application {
    public static ExecutorService JOB_MANAGER;

    @Override
    public void onCreate() {
        super.onCreate();

        JOB_MANAGER = configureJobManager();
    }

    public abstract ExecutorService configureJobManager();
}
