package matthew.shannon.jamfam.service.cache;

import java.util.List;

import matthew.shannon.jamfam.model.Settings;
import matthew.shannon.jamfam.model.User;
import rx.Observable;

public interface CacheService {

    User getOwner();

    void setOwner(User user);

    Observable<Boolean> getSkipIntro();

    void setSkipIntro(boolean flag);

    Observable<Boolean> getAccess();

    void setAccess(boolean flag);

    boolean getCheckBox();

    void setCheckBox(boolean flag);

    Observable<Boolean> getProfileSecondRun();

    void setProfileSecondRun(boolean flag);

    Observable<Boolean> getHomeSecondRun();

    void setHomeSecondRun(boolean flag);

    Observable<List<Settings>> getUserSettings(String ID);

    void setSecondRun();

    // void updateCache(String description, String s);
}