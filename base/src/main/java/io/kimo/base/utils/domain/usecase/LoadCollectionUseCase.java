package io.kimo.base.utils.domain.usecase;

import java.util.List;

import io.kimo.base.utils.domain.BaseUseCase;
import io.kimo.base.utils.domain.Callback;
import io.kimo.base.utils.domain.Entity;
import io.kimo.base.utils.domain.callback.SilentCallback;


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
        this.mCallback = callback;
    }
}
