package io.kimo.base;

public abstract class Presenter<V extends Base.View> implements Base.Presenter {

    private V mView;

    public Presenter(V view) {
        this.mView = view;
        if(getView() == null) {
            throw new IllegalArgumentException("View cannot be null");
        }
    }

    @Override
    public void destroyView() {}

    public V getView() {
        return mView;
    }
}
