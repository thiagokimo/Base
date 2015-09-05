package io.kimo.base.domain;


public abstract class BaseEntity implements Entity {
    protected long entityId;

    public BaseEntity() {
        entityId = System.currentTimeMillis();
    }

    @Override
    public long getEntityId() {
        return entityId;
    }
}
