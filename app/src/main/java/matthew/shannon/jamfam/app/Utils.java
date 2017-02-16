package matthew.shannon.jamfam.app;

import android.content.ContentResolver;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.regex.Pattern;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Utils {

    public static boolean email(TextInputLayout inputLayout, String value) {
        String x = inputLayout.getEditText().getText().toString().trim();
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        boolean ret;

        if (x.isEmpty() || !pattern.matcher(x).matches()) {
            inputLayout.setError(value);
            inputLayout.requestFocus();
            ret = false;
        } else {
            inputLayout.setErrorEnabled(false);
            ret = true;
        }

        return ret;
    }

    public static boolean empty(TextInputLayout inputLayout, String value) {
        String x = inputLayout.getEditText().getText().toString().trim();
        boolean ret;

        if (x.isEmpty()) {
            inputLayout.setError(value);
            inputLayout.getEditText().requestFocus();
            ret = false;
        } else {
            inputLayout.setErrorEnabled(false);
            ret = true;
        }
        return ret;
    }

    public static boolean passwords(TextInputLayout passOne, TextInputLayout passTwo, String value) {
        String x = passOne.getEditText().getText().toString().trim();
        String y = passTwo.getEditText().getText().toString().trim();
        boolean ret;

        if (!x.equals(y)) {
            passOne.setError(value);
            passOne.requestFocus();
            ret = false;
        } else {
            passOne.setErrorEnabled(false);
            ret = true;
        }
        return ret;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

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
                .compose(applySchedulers());

    }


}
