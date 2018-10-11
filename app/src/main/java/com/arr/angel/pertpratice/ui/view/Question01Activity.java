package com.arr.angel.pertpratice.ui.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.ActivityMainBinding;
import com.arr.angel.pertpratice.databinding.NavheaderBinding;


public class Question01Activity extends SingleFragmentActivity  {

    private DrawerLayout mDrawerLayout;

    @Override
    protected Fragment createFragment() {
        return Question01Fragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        setContentView(R.layout.activity_main);

        Toolbar toolbar = activityMainBinding.toolbar;
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getTitle());

        if (getSupportActionBar() != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayShowTitleEnabled(true);
        }

        //use this to change the text

        NavheaderBinding navheaderBinding = NavheaderBinding.bind(activityMainBinding.navView.inflateHeaderView(R.layout.navheader));
        navheaderBinding.textView.setText(R.string.nav_title_questions);
//        activityMainBinding.navView.getMenu().getItem(0).setTitle("Test Test");
//        activityMainBinding.navView.getMenu().getItem(2).setVisible(false);
//        activityMainBinding.navView.getMenu().removeGroup(0);


        mDrawerLayout = activityMainBinding.drawerLayout;
        NavigationView navigationView = activityMainBinding.navView;
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
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
