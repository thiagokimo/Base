import android.view.View;

import org.junit.Before;
import org.mockito.Mockito;

import io.kimo.base.activity.ActivityLifeCycleFlow;
import io.kimo.base.presentation.mvp.Presenter;
import io.kimo.base.v4.activity.BaseFragmentActivity;

public class FragmentActivityTest {
    public class TestFragmentActivity extends BaseFragmentActivity<Presenter> {
        @Override
        public int getLayoutResource() { return Mockito.anyInt(); }
        @Override
        public void mapUI(View view) {}
        @Override
        public void configureUI() {}
        @Override
        public Presenter instantiatePresenter() { return Mockito.mock(Presenter.class); }
    }

    private FragmentActivityTest testActivity;
    private Presenter testPresenter;
    private ActivityLifeCycleFlow<Presenter> activityLifeCycleFlow;

    @Before
    public void setUp() throws Exception {
        testActivity = Mockito.mock(FragmentActivityTest.class);
        testPresenter = Mockito.mock(Presenter.class);
        activityLifeCycleFlow = new ActivityLifeCycleFlow<>(testActivity);

    }
}
