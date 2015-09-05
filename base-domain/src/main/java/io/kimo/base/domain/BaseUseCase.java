package io.kimo.base.domain;

import android.os.Handler;
import android.os.Looper;

public abstract class BaseUseCase<T> implements UseCase<T>, Runnable {

    public Callback<T> callback;
    protected String errorReason = "Something wrong happened";
    protected Handler mainThread = new Handler(Looper.getMainLooper());

    public BaseUseCase(Callback<T> callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            final T result = perform();
            mainThread.post(new Runnable() {
                @Override
                public void run() {
                    callback.onSuccess(result);
                }
            });
        } catch (Exception e) {
            errorReason = e.getMessage();
            onError();
        }
    }

    @Override
    public void onError() {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(errorReason);
            }
        });
    }
}
