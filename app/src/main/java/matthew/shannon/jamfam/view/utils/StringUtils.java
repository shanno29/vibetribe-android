package matthew.shannon.jamfam.view.utils;


import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.support.design.widget.TextInputLayout;
import android.util.Base64;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.io.ByteArrayOutputStream;
import java.util.regex.Pattern;

import matthew.shannon.jamfam.R;


public class StringUtils {

    public static String capitalize(String string){
        return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
    }

    public static String encodeToBase64(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        return Base64.encodeToString(b, Base64.DEFAULT);
    }


    public static boolean contains(String src, String what) {
        final int length = what.length();
        if (length == 0) return true;

        final char firstLo = Character.toLowerCase(what.charAt(0));
        final char firstUp = Character.toUpperCase(what.charAt(0));

        for (int i = src.length() - length; i >= 0; i--) {
            final char ch = src.charAt(i);
            if (ch != firstLo && ch != firstUp) continue;
            if (src.regionMatches(true, i, what, 0, length)) return true;
        }
        return false;
    }

    public static boolean email(TextInputLayout inputLayout, String value) {
        String x = inputLayout.getEditText().getText().toString().trim();
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        boolean ret;

        if (x.isEmpty() || !pattern.matcher(x).matches() ) {
            inputLayout.setError(value);
            inputLayout.requestFocus();
            ret = false;
        } else {
            inputLayout.setErrorEnabled(false);
            ret = true;
        }

        return ret;
    }

    public static boolean empty(TextInputLayout inputLayout, String value)  {
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

}
