package matthew.shannon.jamfam.view.activity;

import android.view.Menu;
import android.view.MenuItem;

import matthew.shannon.jamfam.R;

public abstract class BaseToolbarActivity extends BaseActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings: flowService.goToSettingsActivity(); return true;
            case R.id.message: flowService.goToMessageActivity(); return true;
            case R.id.profile: flowService.goToOwnerProfile(); return true;
            case R.id.logout: flowService.goToLogoutActivity(); return true;
            case R.id.search: flowService.goToSearchActivity(); return true;
            case R.id.about: flowService.goToAboutActivity(); return true;
            case R.id.contact: flowService.goToEmailApp(); return true;
            case R.id.home: onBackPressed(); return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.vibetribe_overflow, menu);
        return true;
    }



}