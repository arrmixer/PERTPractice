package com.arr.angel.pertpratice.ui.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
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
import com.arr.angel.pertpratice.util.NavigationDrawerMenuMethods;
import com.arr.angel.pertpratice.util.UtilMethods;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;

public class Question04Activity extends SingleFragmentActivity {
    private DrawerLayout mDrawerLayout;

    //placeholders for values of previous question
    // and topicId
    private int previousQuestionId;
    private boolean previousIsAnswered;
    private boolean previousIsCorrect;

    private int topicId;

    @Override
    protected Fragment createFragment() {


        if(getIntent() != null){
            previousQuestionId = getIntent().getIntExtra(EXTRA_CURRENT_QUESTION_ID, 0);
            previousIsAnswered = getIntent().getBooleanExtra(CorrectAnswerDialogFragment.EXTRA_IS_ANSWERED, false);
            previousIsCorrect = getIntent().getBooleanExtra(CorrectAnswerDialogFragment.EXTRA_IS_CORRECT, false);
            topicId = getIntent().getIntExtra(MainFragment.EXTRA_TOPIC_ID, 0);
        }

        return Question04Fragment.newInstance(previousQuestionId, previousIsCorrect, previousIsAnswered, topicId);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_TOPIC_ID, topicId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            topicId = savedInstanceState.getInt(EXTRA_TOPIC_ID);
        }

//        make favButton appear only for results pages
        FloatingActionButton floatingActionButton = activityMainBinding.floatingActionButton;
        floatingActionButton.hide();

        Toolbar toolbar = activityMainBinding.toolbar;
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(UtilMethods.showTopicTitle(topicId));
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayShowTitleEnabled(true);
        }

        //setting up nav bar and changing the items for the questions
        NavheaderBinding navheaderBinding = NavheaderBinding.bind(activityMainBinding.navView.inflateHeaderView(R.layout.navheader));
        navheaderBinding.textView.setText(R.string.nav_questions_title);
        activityMainBinding.navView.getMenu().getItem(0).setTitle(getString(R.string.question1));
        activityMainBinding.navView.getMenu().getItem(1).setTitle(getString(R.string.question2));
        activityMainBinding.navView.getMenu().getItem(2).setTitle(getString(R.string.question3));
        activityMainBinding.navView.getMenu().getItem(3).setTitle(getString(R.string.question4));
        activityMainBinding.navView.getMenu().getItem(4).setTitle(getString(R.string.question5));
        activityMainBinding.navView.getMenu().getItem(5).setTitle(getString(R.string.question6));




        mDrawerLayout = activityMainBinding.drawerLayout;
        NavigationView navigationView = activityMainBinding.navView;
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped

                        //helper method that contains switch statement
                        // to navigate to individual questions directly
                        NavigationDrawerMenuMethods.questionDrawerMenuNavigation(Question04Activity.this, menuItem, topicId);


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
