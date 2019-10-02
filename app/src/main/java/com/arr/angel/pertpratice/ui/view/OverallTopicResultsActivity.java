package com.arr.angel.pertpratice.ui.view;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.ActivityMainBinding;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;

public class OverallTopicResultsActivity extends SingleFragmentActivity {

    private static final String TAG = OverallTopicResultsActivity.class.getSimpleName();
    private int topicId;
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
        topicViewModel.getLiveTopicDataFromDB(topicId).observe(this, topic -> {
            mTopic = topic;
            Log.d(TAG, "Is mTopic null? inside observe...." + (mTopic == null));
        });

        Toolbar toolbar = activityMainBinding.toolbar;
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(getString(R.string.overall_results));
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setHomeActionContentDescription(R.string.home_content_description);
        }

        final FloatingActionButton floatingActionButton = activityMainBinding.floatingActionButton;
        floatingActionButton.setOnClickListener(view -> {
            DialogShare dialogShare = DialogShare.newInstance(mTopic.getResultPercentage());
            dialogShare.show(getSupportFragmentManager(), getString(R.string.share_tag));
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.getItem(1).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.main_settings) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
