package matthew.shannon.jamfam.feature.search;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import javax.inject.Inject;

import matthew.shannon.jamfam.app.App;
import matthew.shannon.jamfam.R;
import matthew.shannon.jamfam.adapter.fragment.FragmentAdapter;
import matthew.shannon.jamfam.databinding.ActivitySearchBinding;
import matthew.shannon.jamfam.model.base.BaseToolbarActivity;

public class SearchView extends BaseToolbarActivity implements SearchContract.View{
    private ActivitySearchBinding binding;
    @Inject SearchContract.Presenter presenter;
    @Inject FragmentAdapter adapter;
    @Inject Animation animation;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        setSupportActionBar(binding.viewpager.getToolbar());

        binding.viewpager.getViewPager().setAdapter(adapter);
//        binding.viewpager.getViewPager().startAnimation(animation);
//        binding.viewpager.getViewPager().setOffscreenPageLimit(adapter.getCount());
//        binding.viewpager.getPagerTitleStrip().setViewPager(binding.viewpager.getViewPager());
//        binding.viewpager.setMaterialViewPagerListener(page -> {
//            if (binding.search.isSearchOpen()) binding.search.closeSearch();
//            switch (page) {
//                case 0:
//                    return HeaderDesign.fromColorResAndUrl(
//                            R.color.green,
//                            "https://www.whatswithtech.com/wp-content/uploads/2015/09/new-material-design-wallpaper-chrome.jpg");
//                case 1:
//                    return HeaderDesign.fromColorResAndUrl(
//                            R.color.cyan,
//                            "http://www.vactualpapers.com/web/wallpapers/material-design-hd-wallpaper-no-0611/thumbnail/lg.png");
//                case 2:
//                    return HeaderDesign.fromColorResAndUrl(
//                            R.color.blue,
//                            "http://www.vactualpapers.com/web/wallpapers/qhd-2560x2560-material-design-wallpaper-60/thumbnail/md.jpg");
//                case 3:
//                    return HeaderDesign.fromColorResAndUrl(
//                            R.color.purple,
//                            "https://graphicflip.com/wp-content/uploads/2016/02/40-backgrounds-material.jpg");
//            }
//            return null;});

    }

    @Override
    protected void setupActivityComponent() {
        ((App)getApplicationContext()).getAppComponent().plus(new SearchModule(this)).inject(this);

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
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
        presenter.unsubscribe();
    }


    @Override
    public void showToast(String text) {

    }
}