package io.kimo.base.domain.usecase;

import java.util.List;

import io.kimo.base.domain.BaseUseCase;
import io.kimo.base.domain.Callback;
import io.kimo.base.domain.Entity;
import io.kimo.base.domain.callback.SilentCallback;

public abstract class LoadCollectionUseCase<E extends Entity> extends BaseUseCase<List<E>> {

    public LoadCollectionUseCase() {
        super(new SilentCallback() {
            @Override
            public void onSuccess(Object result) {}
            @Override
            public void onError(String error) {}
        });
    }

    public void setCallback(Callback<List<E>> callback) {
        this.callback = callback;
    }
}
