package matthew.shannon.jamfam.feature.profile.info;

import matthew.shannon.jamfam.model.base.BaseView;
import matthew.shannon.jamfam.model.data.User;

public class InfoContract {

    public interface View  extends BaseView{

        void EditAboutMe(android.view.View view);

        void updateUI(User user);
    }
    public interface Presenter {


        void unsubscribe();

        void loadGetUser(String ID);

        void updateUser(User updatedUser);
    }

}
