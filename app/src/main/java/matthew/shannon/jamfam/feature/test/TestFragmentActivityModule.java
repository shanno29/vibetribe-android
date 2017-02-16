package matthew.shannon.jamfam.feature.test;

import dagger.Module;

@Module
public class TestFragmentActivityModule {

    private final TestFragmentActivity activity;

    public TestFragmentActivityModule(TestFragmentActivity activity) {
        this.activity = activity;
    }

}