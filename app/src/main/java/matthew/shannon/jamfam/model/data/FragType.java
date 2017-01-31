package matthew.shannon.jamfam.model.data;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FragType {
    public static final int FRIENDS_TRACKS = 0;
    public static final int SEARCH_TRACKS = 1;
    public static final int USER_FRIENDS = 2;
    public static final int USER_MATCHES = 3;
    public static final int USER_TRACKS = 4;
    public static final int ALL_TRACKS = 5;
    public static final int ALL_USERS = 6;
    public static final int SETTINGS = 7;
    public static final int USER_INFO = 8;

    public final int itemType;

    public FragType(@ItemTypeDef int itemType) {
        this.itemType = itemType;
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({FRIENDS_TRACKS, SEARCH_TRACKS, USER_FRIENDS, USER_MATCHES, USER_TRACKS, ALL_TRACKS, ALL_USERS, SETTINGS, USER_INFO})
    @interface ItemTypeDef {
    }

}
