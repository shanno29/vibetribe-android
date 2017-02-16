package matthew.shannon.jamfam.feature.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.base.BaseActivity;

public class TestFragmentActivity extends BaseActivity {

    public static final String FLAG_COMMIT_FRAGMENT = "commitFragment";

    public static Intent getStartIntent(Context context, boolean commitFragment) {
        Intent intent = new Intent(context, TestFragmentActivity.class);
        intent.putExtra(FLAG_COMMIT_FRAGMENT, commitFragment);
        return intent;
    }

    @Override
    protected void setupActivityComponent() {
        ((App)getApplicationContext()).getAppComponent().plus(new TestFragmentActivityModule(this)).inject(this);
    }

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_fortests);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}