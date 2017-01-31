package matthew.shannon.jamfam.util;

import android.text.Editable;
import android.text.TextWatcher;

public interface SimpleTextWatcher extends TextWatcher {
    void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);

    void onTextChanged(CharSequence charSequence, int i, int i2, int i3);

    void afterTextChanged(Editable editable);
}