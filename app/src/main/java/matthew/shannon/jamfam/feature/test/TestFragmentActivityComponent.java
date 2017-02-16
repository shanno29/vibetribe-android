package matthew.shannon.jamfam.feature.test;


import dagger.Subcomponent;
import matthew.shannon.jamfam.service.meta.MetaScope;

@MetaScope
@Subcomponent(modules = TestFragmentActivityModule.class)
public interface TestFragmentActivityComponent {

    TestFragmentActivity inject(TestFragmentActivity activity);

}
