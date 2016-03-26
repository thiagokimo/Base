package io.kimo.base.utils.domain;

public interface UseCase<R> {
    R perform() throws Exception;
    void onError();
}
