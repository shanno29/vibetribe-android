package matthew.shannon.jamfam.utils;


import android.databinding.BindingAdapter;
import android.support.design.widget.TextInputLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.regex.Pattern;


public class StringUtils {

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
