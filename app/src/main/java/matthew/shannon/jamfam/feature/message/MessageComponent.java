package matthew.shannon.jamfam.feature.message;

import dagger.Subcomponent;

@MessageScope
@Subcomponent(modules = MessageModule.class)
public interface MessageComponent {

    MessageView inject(MessageView activity);


}
