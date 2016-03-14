import android.view.View;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import io.kimo.base.activity.ActivityLifeCycleFlow;
import io.kimo.base.activity.BaseActivity;
import io.kimo.base.presentation.mvp.Presenter;

public class BaseActivityTest {

    public class TestActivity extends BaseActivity<Presenter> {
        @Override
        public int getLayoutResource() { return Mockito.anyInt(); }
        @Override
        public void mapUI(View view) {}
        @Override
        public void configureUI() {}
        @Override
        public Presenter instantiatePresenter() { return Mockito.mock(Presenter.class); }
        @Override
        public Presenter getPresenter() { return Mockito.mock(Presenter.class); }
    }

    private TestActivity testActivity;
    private Presenter testPresenter;
    private ActivityLifeCycleFlow<Presenter> activityLifeCycleFlow;

    @Before
    public void setUp() throws Exception {
        testPresenter = Mockito.mock(Presenter.class);
        testActivity = Mockito.mock(TestActivity.class);
        activityLifeCycleFlow = new ActivityLifeCycleFlow<>(testActivity);
        testActivity.setActivityLifeCycleFlow(activityLifeCycleFlow);

        Mockito.when(activityLifeCycleFlow.getPresenter()).thenReturn(testPresenter);
        Mockito.when(testActivity.getPresenter()).thenReturn(testPresenter);
        Mockito.when(testActivity.instantiatePresenter()).thenReturn(testPresenter);
    }

    @Test
    public void testOnCreate() throws Exception {
        activityLifeCycleFlow.onCreate();

        Assert.assertEquals(testActivity.getPresenter(), testPresenter);
        Mockito.verify(testActivity).getLayoutResource();
        Mockito.verify(testActivity).configureUI();
        Mockito.verify(testActivity.getPresenter()).createView();
    }

    @Test
    public void testonDestroy() throws Exception {
        activityLifeCycleFlow.onDestroy();

        Mockito.verify(testActivity.getPresenter()).destroyView();
    }
}
