package matthew.shannon.jamfam.feature.profile;


import dagger.Subcomponent;

@ProfileScope
@Subcomponent(modules = ProfileModule.class)
public interface ProfileComponent {

    ProfileView inject(ProfileView activity);



}