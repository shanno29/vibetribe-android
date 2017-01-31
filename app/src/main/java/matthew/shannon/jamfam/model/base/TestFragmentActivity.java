package matthew.shannon.jamfam.model.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import matthew.shannon.jamfam.R;

public class TestFragmentActivity extends AppCompatActivity {

    public static final String FLAG_COMMIT_FRAGMENT = "commitFragment";

    public static Intent getStartIntent(Context context, boolean commitFragment) {
        Intent intent = new Intent(context, TestFragmentActivity.class);
        intent.putExtra(FLAG_COMMIT_FRAGMENT, commitFragment);
        return intent;
    }

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_fortests);
    }

}