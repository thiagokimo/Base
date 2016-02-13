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

    protected Executor mExecutor;
    protected LoadCollectionUseCase<E> mUseCase;
    protected BaseMapper<E,M> mMapper;
    protected List<E> mLoadedCollection = new ArrayList<>();

    public LoadDataCollectionPresenter(LoadDataCollectionView<M> view, BaseMapper<E, M> mapper, LoadCollectionUseCase<E> useCase, Executor executor) {
        super(view);
        this.mMapper = mapper;
        this.mUseCase = useCase;
        this.mExecutor = executor;
    }

    @Override
    public void createView() {
        super.createView();

        mView.showProgress();

        mUseCase.setCallback(new Callback<List<E>>() {
            @Override
            public void onSuccess(List<E> result) {

                mLoadedCollection = result;

                if (result.isEmpty()) {
                    mView.hideProgress();
                    mView.showEmpty();
                } else {
                    mView.hideProgress();
                    mView.renderCollection(mMapper.toModels(result));
                    mView.showView();
                }
            }

            @Override
            public void onError(String error) {
                mView.hideProgress();
                mView.showRetry(error);
                mView.showFeedback("Try again");
            }
        });

        mExecutor.execute(mUseCase);
    }

    @Override
    protected void hideAllViews() {
        mView.hideView();
        mView.hideProgress();
        mView.hideEmpty();
        mView.hideRetry();
    }

    @Override
    public void destroyView() {
        mView.clearCollection();
    }
}
