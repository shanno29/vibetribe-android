package matthew.shannon.jamfam.app;

import javax.inject.Singleton;

import dagger.Component;
import matthew.shannon.jamfam.feature.about.AboutComponent;
import matthew.shannon.jamfam.feature.about.AboutModule;
import matthew.shannon.jamfam.feature.Intro.access.AccessComponent;
import matthew.shannon.jamfam.feature.Intro.access.AccessModule;
import matthew.shannon.jamfam.feature.home.HomeComponent;
import matthew.shannon.jamfam.feature.home.HomeModule;
import matthew.shannon.jamfam.feature.home.map.MapComponent;
import matthew.shannon.jamfam.feature.home.map.MapModule;
import matthew.shannon.jamfam.feature.home.track.TrackComponent;
import matthew.shannon.jamfam.feature.home.track.TrackModule;
import matthew.shannon.jamfam.feature.Intro.login.LoginComponent;
import matthew.shannon.jamfam.feature.Intro.login.LoginModule;
import matthew.shannon.jamfam.feature.logout.LogoutComponent;
import matthew.shannon.jamfam.feature.logout.LogoutModule;
import matthew.shannon.jamfam.feature.message.MessageComponent;
import matthew.shannon.jamfam.feature.message.MessageModule;
import matthew.shannon.jamfam.service.meta.MetaComponent;
import matthew.shannon.jamfam.service.meta.MetaModule;
import matthew.shannon.jamfam.feature.profile.ProfileComponent;
import matthew.shannon.jamfam.feature.profile.ProfileModule;
import matthew.shannon.jamfam.feature.profile.info.InfoComponent;
import matthew.shannon.jamfam.feature.profile.info.InfoModule;
import matthew.shannon.jamfam.feature.search.SearchComponent;
import matthew.shannon.jamfam.feature.search.SearchModule;
import matthew.shannon.jamfam.feature.settings.SettingsComponent;
import matthew.shannon.jamfam.feature.settings.SettingsModule;
import matthew.shannon.jamfam.feature.Intro.signup.SignupComponent;
import matthew.shannon.jamfam.feature.Intro.signup.SignupModule;
import matthew.shannon.jamfam.feature.Intro.splash.SplashComponent;
import matthew.shannon.jamfam.feature.Intro.splash.SplashModule;
import matthew.shannon.jamfam.feature.Intro.welcome.WelcomeComponent;
import matthew.shannon.jamfam.feature.Intro.welcome.WelcomeModule;
import matthew.shannon.jamfam.feature.list.ListComponent;
import matthew.shannon.jamfam.feature.list.ListModule;
import matthew.shannon.jamfam.service.cache.CacheModule;
import matthew.shannon.jamfam.service.flow.FlowModule;
import matthew.shannon.jamfam.service.location.LocationModule;
import matthew.shannon.jamfam.service.network.NetworkModule;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        CacheModule.class,
        LocationModule.class,
        FlowModule.class,
})
public interface AppComponent {

    // Activity
    AboutComponent plus(AboutModule module);

    AccessComponent plus(AccessModule module);

    HomeComponent plus(HomeModule module);

    LoginComponent plus(LoginModule module);

    LogoutComponent plus(LogoutModule module);

    MessageComponent plus(MessageModule module);

    ProfileComponent plus(ProfileModule module);

    SearchComponent plus(SearchModule module);

    SettingsComponent plus(SettingsModule module);

    SignupComponent plus(SignupModule module);

    SplashComponent plus(SplashModule module);

    WelcomeComponent plus(WelcomeModule module);

    // Fragment
    MapComponent plus(MapModule module);

    TrackComponent plus(TrackModule module);

    InfoComponent plus(InfoModule module);

    ListComponent plus(ListModule module);

    //Service
    MetaComponent plus(MetaModule module);

}