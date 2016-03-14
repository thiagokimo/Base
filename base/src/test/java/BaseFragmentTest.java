import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import io.kimo.base.fragment.BaseFragment;
import io.kimo.base.fragment.FragmentLifeCycleFlow;
import io.kimo.base.presentation.mvp.Presenter;

public class BaseFragmentTest {

    public static class TestFragment extends BaseFragment<Presenter> {
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

    private TestFragment testFragment;
    private Presenter testPresenter;
    private FragmentLifeCycleFlow<Presenter> fragmentLifeCycleFlow;

    @Before
    public void setUp() throws Exception {
        testFragment = Mockito.mock(TestFragment.class);
        testPresenter = Mockito.mock(Presenter.class);
        fragmentLifeCycleFlow = new FragmentLifeCycleFlow<>(testFragment);
        testFragment.setFragmentLifeCycleFlow(fragmentLifeCycleFlow);

        Mockito.when(testFragment.getPresenter()).thenReturn(testPresenter);
    }

    @Test
    public void testOnCreateView() throws Exception {

        LayoutInflater mockLayoutInflater = Mockito.mock(LayoutInflater.class);

        Mockito.when(mockLayoutInflater.inflate(Mockito.anyInt(), Mockito.any(ViewGroup.class), Mockito.anyBoolean())).thenReturn(Mockito.any(View.class));
        fragmentLifeCycleFlow.onCreateView(mockLayoutInflater, Mockito.mock(ViewGroup.class));

        Assert.assertEquals(testFragment.getPresenter(), testPresenter);
        Mockito.verify(testFragment).getLayoutResource();
        Mockito.verify(testFragment).mapUI(Mockito.any(View.class));
        Mockito.verify(testFragment).configureUI();
    }

    @Test
    public void testOnActivityCreated() throws Exception {
        fragmentLifeCycleFlow.onActivityCreated(null);
        Mockito.verify(testPresenter).createView();
    }

    @Test
    public void testOnDestroy() throws Exception {
        fragmentLifeCycleFlow.onDestroyView();
        Mockito.verify(testPresenter).destroyView();
    }
}
