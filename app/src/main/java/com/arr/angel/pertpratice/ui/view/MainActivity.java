package com.arr.angel.pertpratice.ui.view;

import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.test.espresso.IdlingResource;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBar;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;


import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.ActivityMainBinding;
import com.arr.angel.pertpratice.databinding.NavheaderBinding;
import com.arr.angel.pertpratice.idlingresource.SimpleIdlingResource;
import com.arr.angel.pertpratice.util.NavigationDrawerMenuMethods;

public class MainActivity extends SingleFragmentActivity {

    // The Idling Resource which will be null in production.
    @Nullable
    private SimpleIdlingResource mIdlingResource;

    /**
     * Only called from test, creates and returns a new {@link SimpleIdlingResource}.
     */
    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }

    private DrawerLayout mDrawerLayout;


    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        setContentView(R.layout.activity_main);

        //make favButton appear only for results pages
        FloatingActionButton floatingActionButton = activityMainBinding.floatingActionButton;
        floatingActionButton.hide();

        Toolbar toolbar = activityMainBinding.toolbar;
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(getTitle());
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setHomeActionContentDescription(R.string.home_content_description);
        }

        //use this to change the text

        NavheaderBinding navheaderBinding = NavheaderBinding.bind(activityMainBinding.navView.inflateHeaderView(R.layout.navheader));
        navheaderBinding.textView.setText(getString(R.string.nav_topics));
//        activityMainBinding.navView.getMenu().getItem(5).setVisible.setTitle("Overall Results");
//        activityMainBinding.navView.getMenu().getItem(2).setVisible(false);
//        activityMainBinding.navView.getMenu().removeGroup(0);


        mDrawerLayout = activityMainBinding.drawerLayout;
        NavigationView navigationView = activityMainBinding.navView;
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        //helper method that contains switch statement
                        // to navigate to topic questions directly
                        NavigationDrawerMenuMethods.mainDrawerMenuNavigation(MainActivity.this, menuItem);

                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
