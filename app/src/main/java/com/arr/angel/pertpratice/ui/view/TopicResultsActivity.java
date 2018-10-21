package com.arr.angel.pertpratice.ui.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.ActivityMainBinding;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.util.UtilMethods;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.List;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;

public class TopicResultsActivity extends SingleFragmentActivity {


    private static final String TAG = TopicResultsActivity.class.getSimpleName();
    //placeholders for boolean values of previous question
    // and topicId
    private boolean isAnswered;
    private boolean isCorrect;
    private int topicId;

    //viewModel instance to share with fragment
    private TopicViewModel topicViewModel;
    private Topic mTopic;
    private List<Question> questions;

    @Override
    protected Fragment createFragment() {
        if (getIntent() != null) {
            isAnswered = getIntent().getBooleanExtra(CorrectAnswerDialogFragment.EXTRA_IS_ANSWERED, false);
            isCorrect = getIntent().getBooleanExtra(CorrectAnswerDialogFragment.EXTRA_IS_CORRECT, false);
            topicId = getIntent().getIntExtra(MainFragment.EXTRA_TOPIC_ID,0);
        }

        return TopicResultsFragment.newInstance(isCorrect, isAnswered, topicId);
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

        if (savedInstanceState != null) {
            topicId = savedInstanceState.getInt(EXTRA_TOPIC_ID);
        }

        topicViewModel = ViewModelProviders.of(this).get(TopicViewModel.class);
        topicViewModel.getLiveTopicDataFromDB(topicId).observe(this, new Observer<Topic>() {
            @Override
            public void onChanged(@Nullable Topic topic) {
                mTopic = topic;
                questions = mTopic.getQuestions();
                Log.d(TAG, "Is mTopic null? inside observe...." + (mTopic == null));
            }
        });
        Log.d(TAG, "Is mTopic null? " + (mTopic == null));

        Toolbar toolbar = activityMainBinding.toolbar;
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(UtilMethods.showTopicTitle(topicId));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.main_settings) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.retake_settings) {
            for(Question q : questions){
            q.setAnswered(false);
            q.setCorrect(false);
        }
        topicViewModel.insertTopic(mTopic);
        Intent intent = new Intent(this, Question01Activity.class);
        intent.putExtra(MainFragment.EXTRA_TOPIC_ID, topicId);
        startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
