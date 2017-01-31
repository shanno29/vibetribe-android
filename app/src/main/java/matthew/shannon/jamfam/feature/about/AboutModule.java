package matthew.shannon.jamfam.feature.about;

import android.support.v4.app.FragmentManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;
import com.mikepenz.aboutlibraries.ui.LibsSupportFragment;

import dagger.Module;
import dagger.Provides;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.adapter.fragment.FragmentAdapter;

@Module
public class AboutModule {

    private AboutView activity;

    public AboutModule(AboutView activity) {
        this.activity = activity;
    }

    @Provides
    @AboutScope
    LibsSupportFragment aboutFragment() {
        return new LibsBuilder()
                .withAboutDescription("Matthew Shannon 2015 - 2016")
                .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
                .withFields(R.string.class.getFields())
                .withAboutVersionShown(true)
                .withAutoDetect(true)
                .withAboutIconShown(true)
                .supportFragment();
    }

    @Provides
    @AboutScope
    Animation viewPagerAnimation(){
        return AnimationUtils.loadAnimation(activity, R.anim.slide_up);
    }

    @Provides
    @AboutScope
    FragmentManager fragmentManager(){
        return activity.getSupportFragmentManager();
    }

    @Provides
    @AboutScope
    FragmentAdapter fragmentAdapter(FragmentManager manager, LibsSupportFragment supportFragment){
        FragmentAdapter adapter = new FragmentAdapter(manager);
        adapter.addFragment(supportFragment, "");
        return adapter;
    }


}