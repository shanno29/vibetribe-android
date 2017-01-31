package matthew.shannon.jamfam.feature.home.track;

import dagger.Subcomponent;

@TrackScope
@Subcomponent(modules = TrackModule.class)
public interface TrackComponent {

    TrackView inject(TrackView fragment);


}
