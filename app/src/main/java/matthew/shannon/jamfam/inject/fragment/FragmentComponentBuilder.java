package matthew.shannon.jamfam.inject.fragment;

public interface FragmentComponentBuilder<M extends FragmentComponent.FragmentModule, C extends FragmentComponent> {
    FragmentComponentBuilder<M, C> fragmentModule(M fragmentModule);
    C build();
}