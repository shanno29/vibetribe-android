package matthew.shannon.jamfam.feature.settings;


import dagger.Subcomponent;

@SettingsScope
@Subcomponent(modules = SettingsModule.class)
public interface SettingsComponent{

    SettingsView inject(SettingsView activity);




}