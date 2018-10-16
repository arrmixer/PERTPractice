package com.arr.angel.pertpratice.ui.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.ActivityMainBinding;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;

public class OverallTopicResultsActivity extends SingleFragmentActivity {

    private static final String TAG = OverallTopicResultsActivity.class.getSimpleName();

    private int topicId;


    //viewModel instance to share with fragment
    private TopicViewModel topicViewModel;
    private Topic mTopic;





    @Override
    protected Fragment createFragment() {
        return OverallResultsFragment.newInstance();
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

        if (savedInstanceState != null) {
            topicId = savedInstanceState.getInt(EXTRA_TOPIC_ID);
        }

        topicViewModel = ViewModelProviders.of(this).get(TopicViewModel.class);
        topicViewModel.getLiveTopicDataFromDB(topicId).observe(this, new Observer<Topic>() {
            @Override
            public void onChanged(@Nullable Topic topic) {
                mTopic = topic;
                Log.d(TAG, "Is mTopic null? inside observe...." + (mTopic == null));
            }
        });

        Toolbar toolbar = activityMainBinding.toolbar;
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(getString(R.string.overall_results));
            actionBar.setDisplayShowTitleEnabled(true);
        }

        final FloatingActionButton floatingActionButton = activityMainBinding.floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogShare dialogShare = DialogShare.newInstance(mTopic.getResultPercentage());
                dialogShare.show(getSupportFragmentManager(), "share");
            }
        });







    }
}