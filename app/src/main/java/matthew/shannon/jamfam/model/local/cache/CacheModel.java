package matthew.shannon.jamfam.model.local.cache;

import com.f2prateek.rx.preferences.RxSharedPreferences;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import matthew.shannon.jamfam.model.data.Settings;
import matthew.shannon.jamfam.model.data.User;
import rx.Observable;

public class CacheModel implements CacheService {
    private final RxSharedPreferences rxPrefs;
    private final CacheHelper<User> cacheHelper;

    public CacheModel(RxSharedPreferences rxPrefs, CacheHelper<User> cacheHelper) {
        this.rxPrefs = rxPrefs;
        this.cacheHelper = cacheHelper;
    }

    @Override
    public User getOwner() {
        return rxPrefs.getObject("owner", cacheHelper).get();

    }

    @Override
    public void setOwner(User user) {
        rxPrefs.getObject("owner", cacheHelper).set(user);

    }

    @Override
    public Observable<Boolean> getSkipIntro() {
        return rxPrefs.getBoolean("skip_intro", false).asObservable();

    }

    @Override
    public void setSkipIntro(boolean flag) {
        rxPrefs.getBoolean("skip_intro").set(flag);

    }

    @Override
    public Observable<Boolean> getAccess() {
        return rxPrefs.getBoolean("notification_access", false).asObservable();

    }

    @Override
    public void setAccess(boolean flag) {
        rxPrefs.getBoolean("notification_access").set(flag);

    }

    @Override
    public boolean getCheckBox() {
        return rxPrefs.getBoolean("checkbox", false).get();

    }

    @Override
    public void setCheckBox(boolean flag) {
        rxPrefs.getBoolean("checkbox").set(flag);

    }

    @Override
    public Observable<Boolean> getProfileSecondRun() {
        return rxPrefs.getBoolean("profile_second_run", false).asObservable();
    }

    @Override
    public void setProfileSecondRun(boolean flag) {
        rxPrefs.getBoolean("profile_second_run").set(flag);
    }

    @Override
    public Observable<Boolean> getHomeSecondRun() {
        return rxPrefs.getBoolean("home_second_run", false).asObservable();
    }

    @Override
    public void setHomeSecondRun(boolean flag) {
        rxPrefs.getBoolean("home_second_run").set(flag);

    }

    @Override
    public Observable<List<Settings>> getUserSettings(String Id) {
        User user = getOwner();
        return Observable.from(Collections.singletonList(Arrays.asList(
            new Settings("Username", user.getUsername()),
            new Settings("Fullname",user.getFullname()),
            new Settings("Gender", user.getGender()),
            new Settings("About", user.getAboutme()),
            new Settings("State", user.getState()),
            new Settings("City", user.getCity()),
            new Settings("Age", user.getAge())))
        );
    }

    @Override
    public void setSecondRun() {
        rxPrefs.getBoolean("second_run").set(true);
    }

//    @Override
//    public void updateCache(String description, String s) {
//        switch (description){
//            case"Username": cacheService.setUsername(s); break;
//            case"Fullname": cacheService.setFullname(s); break;
//            case"Gender": cacheService.setGender(s); break;
//            case"City": cacheService.setCity(s); break;
//            case"State": cacheService.setState(s); break;
//            case"Age": cacheService.setAge(s); break;
//            case"About": cacheService.setAboutme(s); break;
//        }
//    }

}
