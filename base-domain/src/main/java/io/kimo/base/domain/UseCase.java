package io.kimo.base.domain;

public interface UseCase<R> {
    R perform();
    void onError();
}
