package matthew.shannon.jamfam.feature.about;

import dagger.Subcomponent;

@AboutScope
@Subcomponent(modules = AboutModule.class)
public interface AboutComponent {

    AboutView inject(AboutView activity);

}