package io.kimo.base.utils.domain;

import android.os.Handler;
import android.os.Looper;

public abstract class BaseUseCase<T> implements UseCase<T>, Runnable {

    public Callback<T> mCallback;
    protected String mErrorReason = "Something wrong happened";
    protected Handler mMainThread = new Handler(Looper.getMainLooper());

    public BaseUseCase(Callback<T> mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public void run() {
        try {
            final T result = perform();
            mMainThread.post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onSuccess(result);
                }
            });
        } catch (Exception e) {
            mErrorReason = e.getMessage();
            onError();
        }
    }

    @Override
    public void onError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onError(mErrorReason);
            }
        });
    }
}
