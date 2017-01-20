package matthew.shannon.jamfam.view.utils.constant;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Action {
    public static final int REFRESH = 0;
    public static final int GO_TO_APP = 1;

    public static final int ADD_FRIEND = 2;
    public static final int DEL_FRIEND = 3;
    public static final int UPDATE_USER = 5;
    public static final int GO_TO_USER = 4;

    public static final int ADD_TRACK = 6;
    public static final int DEL_TRACK = 7;
    public static final int GO_TO_TRACK = 8;

    public static final int CONTROL_TRACK = 9;
    public static final int QUERY_CHANGED = 10;
    public static final int TRACK_UPDATE = 11;

    public final int action;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({ REFRESH, GO_TO_APP, ADD_FRIEND, DEL_FRIEND, UPDATE_USER, GO_TO_USER, ADD_TRACK, DEL_TRACK, GO_TO_TRACK, CONTROL_TRACK, QUERY_CHANGED, TRACK_UPDATE })
    @interface ActionTypeDef { }

    public Action(@ActionTypeDef int action){
        this.action = action;
    }

}
