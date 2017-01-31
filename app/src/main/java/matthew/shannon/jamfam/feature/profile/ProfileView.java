package matthew.shannon.jamfam.feature.profile;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import javax.inject.Inject;
import javax.inject.Named;

import co.mobiwise.materialintro.view.MaterialIntroView;
import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.adapter.fragment.FragmentAdapter;
import matthew.shannon.jamfam.databinding.ActivityProfileBinding;
import matthew.shannon.jamfam.model.base.BaseToolbarActivity;
import matthew.shannon.jamfam.model.data.User;

public class ProfileView extends BaseToolbarActivity implements ProfileContract.View {

    private String ID;
    private ActivityProfileBinding binding;
    @Inject @Named("profilePicture") MaterialIntroView.Builder pictureIntro;
    @Inject @Named("profileBanner") MaterialIntroView.Builder bannerIntro;
    @Inject ProfileContract.Presenter presenter;
    @Inject FragmentAdapter adapter;
    @Inject Animation animation;
    @Inject User user;



    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        ID = getIntent().getStringExtra("ID");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        binding.setUser(user);
        setSupportActionBar(binding.viewpager.getToolbar());

        binding.viewpager.getViewPager().setAdapter(adapter);
        //binding.viewpager.getViewPager().startAnimation(animation);
        //binding.viewpager.getViewPager().setOffscreenPageLimit(adapter.getCount());
        //binding.viewpager.getPagerTitleStrip().setViewPager(binding.viewpager.getViewPager());

    }

    @Override
    protected void setupActivityComponent() {
        ((App)getApplicationContext()).getAppComponent().plus(new ProfileModule(this, ID)).inject(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        //presenter.loadUser(ID);
        //presenter.checkForSecondRun();



        // presenter.selectProfilePicture();
        // presenter.selectBannerPicture();

    }

    @Override
    public void onBackPressed() {
        if (binding.search.isSearchOpen()) binding.search.closeSearch();
        else super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem item = menu.findItem(R.id.action_search);
        item.setVisible(true);
        binding.search.setMenuItem(item);
        binding.search.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                binding.search.hideKeyboard(binding.getRoot());
                //bus.post(new Event(Action.QUERY_CHANGED, query));
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //bus.post(new Event(Action.QUERY_CHANGED, query));
                return true;
            }
        });
        binding.search.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                binding.search.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSearchViewClosed() {
                binding.search.setVisibility(View.GONE);
            }
        });
        return true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        binding.unbind();
    }

    @Override
    public void showIntroView() {
        // pictureIntro.setTarget(headerBinding.picture);
        // bannerIntro.setTarget(binding.viewpager.getHeaderBackgroundContainer());
        pictureIntro.setListener(s -> bannerIntro.show());
        pictureIntro.show();
    }

    @Override
    public void refreshProfile(User user) {
        binding.setUser(user);
        binding.executePendingBindings();
        binding.viewpager.setImageUrl(user.getBanner(), 100);
        if (getSupportActionBar() != null) { getSupportActionBar().setTitle(binding.getUser().getUsername()); }
    }

    @Override
    public void showToast(String text) {

    }
}