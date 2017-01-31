package matthew.shannon.jamfam.model.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import matthew.shannon.jamfam.model.local.flow.FlowService;

public abstract class BaseActivity extends AppCompatActivity {

    @Inject FlowService flowService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
    }

    protected abstract void setupActivityComponent();

}