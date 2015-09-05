package io.kimo.base.presentation.mvp.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import io.kimo.base.domain.BaseMapper;
import io.kimo.base.domain.Callback;
import io.kimo.base.domain.Entity;
import io.kimo.base.domain.usecase.LoadCollectionUseCase;
import io.kimo.base.presentation.mvp.BasePresenter;
import io.kimo.base.presentation.mvp.Model;
import io.kimo.base.presentation.mvp.view.LoadDataCollectionView;

public class LoadDataCollectionPresenter<E extends Entity, M extends Model> extends BasePresenter<LoadDataCollectionView<M>> {

    protected Executor executor;
    protected LoadCollectionUseCase<E> useCase;
    protected BaseMapper<E,M> mapper;
    protected List<E> loadedColletion = new ArrayList<>();

    public LoadDataCollectionPresenter(LoadDataCollectionView<M> view, BaseMapper<E, M> mapper, LoadCollectionUseCase<E> useCase, Executor executor) {
        super(view);
        this.mapper = mapper;
        this.useCase = useCase;
        this.executor = executor;
    }

    @Override
    public void createView() {
        super.createView();

        view.showProgress();

        useCase.setCallback(new Callback<List<E>>() {
            @Override
            public void onSuccess(List<E> result) {

                loadedColletion = result;

                if(result.isEmpty()) {
                    view.hideProgress();
                    view.showEmpty();
                } else {
                    view.hideProgress();
                    view.renderCollection(mapper.toModels(result));
                    view.showView();
                }
            }

            @Override
            public void onError(String error) {
                view.hideProgress();
                view.showRetry(error);
                view.showFeedback("Try again");
            }
        });

        executor.execute(useCase);
    }

    @Override
    protected void hideAllViews() {
        view.hideView();
        view.hideProgress();
        view.hideEmpty();
        view.hideRetry();
    }

    @Override
    public void destroyView() {
        view.clearCollection();
    }
}
