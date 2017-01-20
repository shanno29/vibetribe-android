package matthew.shannon.jamfam.inject.fragment.component;

import android.support.v4.app.Fragment;
import dagger.MembersInjector;
import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.inject.fragment.scope.FragmentScope;

public interface FragmentComponent<A extends Fragment> extends MembersInjector<A> {

    @Module
    public abstract class FragmentModule<T> {
        protected final T fragment;

        public FragmentModule(T fragment) {
            this.fragment = fragment;
        }

        @Provides
        @FragmentScope
        T provideFragment() {
            return fragment;
        }

    }
}