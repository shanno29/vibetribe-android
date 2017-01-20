package matthew.shannon.jamfam.inject.app.module;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import matthew.shannon.jamfam.inject.activity.component.AboutComponent;
import matthew.shannon.jamfam.view.activity.AboutView;
import matthew.shannon.jamfam.inject.activity.component.HomeComponent;
import matthew.shannon.jamfam.view.activity.HomeView;
import matthew.shannon.jamfam.inject.activity.component.AccessComponent;
import matthew.shannon.jamfam.view.activity.AccessView;
import matthew.shannon.jamfam.inject.activity.component.LoginComponent;
import matthew.shannon.jamfam.view.activity.LoginView;
import matthew.shannon.jamfam.inject.activity.component.SignupComponent;
import matthew.shannon.jamfam.view.activity.SignupView;
import matthew.shannon.jamfam.inject.activity.component.SplashComponent;
import matthew.shannon.jamfam.view.activity.SplashView;
import matthew.shannon.jamfam.inject.activity.component.WelcomeComponent;
import matthew.shannon.jamfam.view.activity.WelcomeView;
import matthew.shannon.jamfam.inject.activity.component.LogoutComponent;
import matthew.shannon.jamfam.view.activity.LogoutView;
import matthew.shannon.jamfam.inject.activity.component.MessageComponent;
import matthew.shannon.jamfam.view.activity.MessageView;
import matthew.shannon.jamfam.inject.activity.component.ProfileComponent;
import matthew.shannon.jamfam.view.activity.ProfileView;
import matthew.shannon.jamfam.inject.activity.component.SearchComponent;
import matthew.shannon.jamfam.view.activity.SearchView;
import matthew.shannon.jamfam.inject.activity.component.SettingsComponent;
import matthew.shannon.jamfam.view.activity.SettingsView;
import matthew.shannon.jamfam.inject.activity.component.ActivityComponentBuilder;
import matthew.shannon.jamfam.inject.activity.scope.ActivityKey;

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