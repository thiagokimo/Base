package io.kimo.base.presentation.mvp;

public abstract class BaseModel implements Model {

    private long modelId;

    public BaseModel() {
        modelId = System.currentTimeMillis();
    }

    @Override
    public long getModelId() {
        return modelId;
    }
}