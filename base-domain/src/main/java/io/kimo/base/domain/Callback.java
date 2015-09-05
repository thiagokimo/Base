package io.kimo.base.domain;

public interface Callback<R> {
    void onSuccess(R result);
    void onError(String error);
}
