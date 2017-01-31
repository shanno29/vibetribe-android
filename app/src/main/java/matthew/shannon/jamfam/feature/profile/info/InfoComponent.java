package matthew.shannon.jamfam.feature.profile.info;


import dagger.Subcomponent;

@InfoScope
@Subcomponent(modules = InfoModule.class)
public interface InfoComponent {


    InfoView inject(InfoView activity);


}
