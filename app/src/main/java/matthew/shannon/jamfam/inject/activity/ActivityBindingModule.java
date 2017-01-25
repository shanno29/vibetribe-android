package matthew.shannon.jamfam.inject.activity;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.feature.about.AboutComponent;
import matthew.shannon.jamfam.feature.about.AboutView;
import matthew.shannon.jamfam.feature.home.HomeComponent;
import matthew.shannon.jamfam.feature.home.HomeView;
import matthew.shannon.jamfam.feature.access.AccessComponent;
import matthew.shannon.jamfam.feature.access.AccessView;
import matthew.shannon.jamfam.feature.login.LoginComponent;
import matthew.shannon.jamfam.feature.login.LoginView;
import matthew.shannon.jamfam.feature.signup.SignupComponent;
import matthew.shannon.jamfam.feature.signup.SignupView;
import matthew.shannon.jamfam.feature.splash.SplashComponent;
import matthew.shannon.jamfam.feature.splash.SplashView;
import matthew.shannon.jamfam.feature.welcome.WelcomeComponent;
import matthew.shannon.jamfam.feature.welcome.WelcomeView;
import matthew.shannon.jamfam.feature.logout.LogoutComponent;
import matthew.shannon.jamfam.feature.logout.LogoutView;
import matthew.shannon.jamfam.feature.message.MessageComponent;
import matthew.shannon.jamfam.feature.message.MessageView;
import matthew.shannon.jamfam.feature.profile.ProfileComponent;
import matthew.shannon.jamfam.feature.profile.ProfileView;
import matthew.shannon.jamfam.feature.search.SearchComponent;
import matthew.shannon.jamfam.feature.search.SearchView;
import matthew.shannon.jamfam.feature.settings.SettingsComponent;
import matthew.shannon.jamfam.feature.settings.SettingsView;
import matthew.shannon.jamfam.inject.activity.ActivityComponentBuilder;
import matthew.shannon.jamfam.inject.activity.ActivityKey;

@Module(
    subcomponents = {
        SplashComponent.class,
        WelcomeComponent.class,
        AccessComponent.class,
        SignupComponent.class,
        LoginComponent.class,
        AboutComponent.class,
        HomeComponent.class,
        LogoutComponent.class,
        MessageComponent.class,
        ProfileComponent.class,
        SearchComponent.class,
        SettingsComponent.class,
    }
)
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(SplashView.class)
    public abstract ActivityComponentBuilder SplashComponentBuilder(SplashComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(WelcomeView.class)
    public abstract ActivityComponentBuilder WelcomeComponentBuilder(WelcomeComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(AccessView.class)
    public abstract ActivityComponentBuilder AccessComponentBuilder(AccessComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(SignupView.class)
    public abstract ActivityComponentBuilder SignupComponentBuilder(SignupComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(LoginView.class)
    public abstract ActivityComponentBuilder LoginComponentBuilder(LoginComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(AboutView.class)
    public abstract ActivityComponentBuilder AboutComponentBuilder(AboutComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(HomeView.class)
    public abstract ActivityComponentBuilder HomeComponentBuilder(HomeComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(LogoutView.class)
    public abstract ActivityComponentBuilder LogoutComponentBuilder(LogoutComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(MessageView.class)
    public abstract ActivityComponentBuilder MessageComponentBuilder(MessageComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(ProfileView.class)
    public abstract ActivityComponentBuilder ProfileComponentBuilder(ProfileComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(SearchView.class)
    public abstract ActivityComponentBuilder SearchComponentBuilder(SearchComponent.Builder impl);

    @Binds
    @IntoMap
    @ActivityKey(SettingsView.class)
    public abstract ActivityComponentBuilder SettingsComponentBuilder(SettingsComponent.Builder impl);

}