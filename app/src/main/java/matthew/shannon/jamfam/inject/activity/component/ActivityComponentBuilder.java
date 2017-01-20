package matthew.shannon.jamfam.inject.activity.component;

public interface ActivityComponentBuilder<M extends ActivityComponent.ActivityModule, C extends ActivityComponent> {
    ActivityComponentBuilder<M, C> activityModule(M activityModule);
    C build();
}