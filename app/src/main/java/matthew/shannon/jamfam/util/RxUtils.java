package matthew.shannon.jamfam.util;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.IOException;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxUtils {

    @SuppressWarnings("unchecked")
    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<Bitmap> uriToBitmap(final ContentResolver resolver, final Uri uri) {
        return Observable
                .create((Observable.OnSubscribe<Bitmap>) subscriber -> {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(resolver, uri);
                        subscriber.onNext(bitmap);
                        subscriber.onCompleted();
                    } catch (IOException e) {
                        Log.e("VIBETRIBE", "Error converting uri", e);
                        subscriber.onError(e);
                    }
                })
                .compose(RxUtils.applySchedulers());

    }

}
