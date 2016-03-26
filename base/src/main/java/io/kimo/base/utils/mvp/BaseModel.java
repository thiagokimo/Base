package io.kimo.base.utils.mvp;

public abstract class BaseModel implements Model {

    private long mModelId;

    public BaseModel() {
        mModelId = System.currentTimeMillis();
    }

    @Override
    public long getModelId() {
        return mModelId;
    }
}