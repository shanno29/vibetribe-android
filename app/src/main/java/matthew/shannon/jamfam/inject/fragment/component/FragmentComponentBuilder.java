package matthew.shannon.jamfam.inject.fragment.component;

public interface FragmentComponentBuilder<M extends FragmentComponent.FragmentModule, C extends FragmentComponent> {
    FragmentComponentBuilder<M, C> fragmentModule(M fragmentModule);
    C build();
}