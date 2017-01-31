package matthew.shannon.jamfam.feature.splash;

import android.os.Bundle;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import javax.inject.Inject;

import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.R;

public class SplashView extends AwesomeSplash implements SplashContract.View {

    @Inject SplashContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((App)getApplicationContext()).getAppComponent().plus(new SplashModule(this)).inject(this);
    }

    @Override
    public void initSplash(ConfigSplash configSplash) {

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.purple);
        configSplash.setAnimCircularRevealDuration(1000);
        configSplash.setRevealFlagX(Flags.WITH_LOGO);
        configSplash.setRevealFlagY(Flags.WITH_LOGO);

        //Customize Logo
        configSplash.setLogoSplash(R.drawable.vibe_tribe);
        configSplash.setAnimLogoSplashDuration(1000);
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeInUp);

        //Customize Title
        configSplash.setTitleSplash("VibeTribe");
        configSplash.setTitleTextColor(R.color.white);
        configSplash.setTitleTextSize(30f);
        configSplash.setAnimTitleDuration(1000);
        configSplash.setAnimTitleTechnique(Techniques.FadeInUp);
    }

    @Override
    public void animationsFinished() {
        presenter.getIntroSecondRun();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
    }

    @Override
    public void showToast(String text) {

    }


}

