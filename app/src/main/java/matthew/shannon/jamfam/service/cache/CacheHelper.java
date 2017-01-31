package matthew.shannon.jamfam.service.cache;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.f2prateek.rx.preferences.Preference;
import com.google.gson.Gson;

public class CacheHelper<T> implements Preference.Adapter<T> {
    private final Gson gson;
    private Class<T> clazz;

    CacheHelper(Gson gson, Class<T> clazz) {
        this.gson = gson;
        this.clazz = clazz;
    }

    @Override
    public T get(@NonNull String key, @NonNull SharedPreferences preferences) {
        return gson.fromJson(preferences.getString(key, null), clazz);
    }

    @Override
    public void set(@NonNull String key, @NonNull T value, @NonNull SharedPreferences.Editor editor) {
        editor.putString(key, gson.toJson(value));
    }

}