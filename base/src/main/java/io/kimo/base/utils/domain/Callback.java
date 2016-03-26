package io.kimo.base.utils.domain;

public interface Callback<R> {
    void onSuccess(R result);
    void onError(String error);
}
