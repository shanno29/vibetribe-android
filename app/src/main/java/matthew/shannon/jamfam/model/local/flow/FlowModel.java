package matthew.shannon.jamfam.model.local.flow;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;

import matthew.shannon.jamfam.feature.meta.MetaView;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.feature.about.AboutView;
import matthew.shannon.jamfam.feature.access.AccessView;
import matthew.shannon.jamfam.feature.home.HomeView;
import matthew.shannon.jamfam.feature.login.LoginView;
import matthew.shannon.jamfam.feature.logout.LogoutView;
import matthew.shannon.jamfam.feature.message.MessageView;
import matthew.shannon.jamfam.feature.profile.ProfileView;
import matthew.shannon.jamfam.feature.search.SearchView;
import matthew.shannon.jamfam.feature.settings.SettingsView;
import matthew.shannon.jamfam.feature.signup.SignupView;
import matthew.shannon.jamfam.feature.splash.SplashView;
import matthew.shannon.jamfam.feature.welcome.WelcomeView;

public class FlowModel implements FlowService {

    private final Application application;
    private final ActivityManager manager;

    public FlowModel(Application application, ActivityManager manager) {
        this.application = application;
        this.manager = manager;
    }

   @Override
   public boolean checkServiceStatus(){
       for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
           if (MetaView.class.getName().equals(service.service.getClassName())) {return true;}
       }
       return false;
   }

    @Override
    public void goToSplashActivity(){
        Intent intent = new Intent(application, SplashView.class);
        application.startActivity(intent);
    }

    @Override
    public void goToWelcomeActivity(){
        Intent intent = new Intent(application, WelcomeView.class);
        application.startActivity(intent);
    }

    @Override
    public void goToAccessActivity(){
        Intent intent = new Intent(application, AccessView.class);
        application.startActivity(intent);
    }

    @Override
    public void goToSignupActivity(){
        Intent intent = new Intent(application, SignupView.class);
        application.startActivity(intent);
    }

    @Override
    public void goToLoginActivity(){
        Intent intent = new Intent(application, LoginView.class);
        application.startActivity(intent);
    }

    @Override
    public void goToOwnerProfile() {
        Intent intent = new Intent(application, ProfileView.class);
        intent.putExtra("ID", App.userID);
        application.startActivity(intent);
    }

    @Override
    public void goToUserProfile(String ID) {
        Intent intent = new Intent(application, ProfileView.class);
        intent.putExtra("ID", ID);
        application.startActivity(intent);
    }

    @Override
    public void goToSearchActivity() {
        Intent intent = new Intent(application, SearchView.class);
        application.startActivity(intent);
    }

    @Override
    public void goToMessageActivity() {
        Intent intent = new Intent(application, MessageView.class);
        application.startActivity(intent);
    }

    @Override
    public void goToHomeActivity() {
        Intent intent = new Intent(application, HomeView.class);
        application.startActivity(intent);
    }

    @Override
    public void goToAboutActivity() {
        Intent intent = new Intent(application, AboutView.class);
        application.startActivity(intent);
    }

    @Override
    public void goToSettingsActivity() {
        Intent intent = new Intent(application, SettingsView.class);
        application.startActivity(intent);
    }

    @Override
    public void goToLogoutActivity() {
        Intent intent = new Intent(application, LogoutView.class);
        application.startActivity(intent);
    }

    @Override
    public void goToEmailApp() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:shanno29@uwm.edu"));
        application.startActivity(intent);
    }

    @Override
    public void goToStore(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=matthew.shannon.jamfam&hl=en"));
        application.startActivity(intent);

    }

    @Override
    public void exitApp() {

    }

}
