package matthew.shannon.jamfam.base;

import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.service.flow.FlowService;

public abstract class BaseToolbarActivity extends BaseActivity {
    @Inject FlowService flowService;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.settings) flowService.goToSettingsActivity();
        if(item.getItemId() == R.id.message) flowService.goToMessageActivity();
        if(item.getItemId() == R.id.profile) flowService.goToOwnerProfile();
        if(item.getItemId() == R.id.search) flowService.goToSearchActivity();
        if(item.getItemId() == R.id.about) flowService.goToAboutActivity();
        if(item.getItemId() == R.id.contact) flowService.goToEmailApp();
        if(item.getItemId() == R.id.logout) flowService.goToLogoutActivity();
        if(item.getItemId() == R.id.home) onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.vibetribe_overflow, menu);
        return true;
    }

}