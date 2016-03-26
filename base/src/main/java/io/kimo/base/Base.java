package io.kimo.base;


public interface Base {

    /**
     * Main contract between the Android classes
     */
    interface AndroidView<P extends Presenter>{
        /* return your view's layout resource */
        int getLayoutResource();

        /* call all your mapping methods in here (e.g findViewById) */
        void mapUI(android.view.View view);

        /* configure everything related with your mapped views (adapters, click listeners, etc) */
        void configureUI();

        /* build up your presenter with all its necessary dependencies in here */
        P injectDependencies();
    }

    interface View <P extends Presenter> extends AndroidView<P>{
        /* getter to the view's presenter */
        P getPresenter();
    }

    interface Presenter {
        void createView();
        void destroyView();
    }
}
