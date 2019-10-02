package com.arr.angel.pertpratice.ui.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.TopicResultsBinding;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.util.DialogCreations;
import com.arr.angel.pertpratice.util.ResultsSharedPreferences;
import com.arr.angel.pertpratice.util.UtilMethods;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.List;

import static com.arr.angel.pertpratice.ui.view.MainFragment.ARGS_CURRENT_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.ARGS_TOPIC_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.ARG_IS_ANSWERED;
import static com.arr.angel.pertpratice.ui.view.MainFragment.ARG_IS_CORRECT;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;

public class TopicResultsFragment extends Fragment implements TopicResultsAdapter.ItemClickListenerTopicResults {

    private static final String TAG = TopicResultsFragment.class.getSimpleName();
    private TopicViewModel topicViewModel;
    TopicResultsBinding topicResultsBinding;

    private TextView resultsTitle;
    private TextView resultsPercentage;
    private TextView resultsDescription;

    private Topic mTopic;
    private List<Question> questions;
    private Question question;
    private int previousQuestionId;
    private boolean previousIsAnswered;
    private boolean previousIsCorrect;
    private int topicId;
    private int resultPercentage;

    public static TopicResultsFragment newInstance(int previousQuestionId, boolean correct, boolean answered, int topicId) {
        TopicResultsFragment topicResultsFragment = new TopicResultsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_CURRENT_ID, previousQuestionId);
        bundle.putBoolean(ARG_IS_CORRECT, correct);
        bundle.putBoolean(ARG_IS_ANSWERED, answered);
        bundle.putInt(ARGS_TOPIC_ID, topicId);
        topicResultsFragment.setArguments(bundle);

        return topicResultsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        topicResultsBinding = DataBindingUtil.inflate(inflater, R.layout.topic_results, container, false);
        topicResultsBinding.setLifecycleOwner(this);

        topicResultsBinding.recyclerViewTopicResults.setLayoutManager(new LinearLayoutManager(getActivity()));

        return topicResultsBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null) {
            previousQuestionId = getArguments().getInt(ARGS_CURRENT_ID);
            previousIsAnswered = getArguments().getBoolean(ARG_IS_ANSWERED);
            previousIsCorrect = getArguments().getBoolean(ARG_IS_CORRECT);
            topicId = getArguments().getInt(ARGS_TOPIC_ID);
        }

        resultsTitle = topicResultsBinding.textViewTopicTotalResultsTitle;
        resultsPercentage = topicResultsBinding.textViewTopicTotalResultsPercentage;
        resultsDescription = topicResultsBinding.textViewTopicTotalResultsDescription;

        topicViewModel = ViewModelProviders.of(this).get(TopicViewModel.class);

        topicViewModel.getLiveTopicDataFromDB(topicId).observe(this, topic -> {
            mTopic = topic;
            populateView();
            setupAdapter();

            Question previousQuestion;

            if (previousIsAnswered) {
                previousQuestion = questions.get(previousQuestionId - 1);
                previousQuestion.setCorrect(previousIsCorrect);
                previousQuestion.setAnswered(previousIsAnswered);
                mTopic.setResultPercentage(UtilMethods.calculateTotalPercentage(mTopic.getQuestions()));
                topicViewModel.insertTopic(mTopic);

                previousIsAnswered = false;
            }
            addTopicTitleAndResultPref();

        });
    }

    private void setupAdapter() {
        if (isAdded() && mTopic != null) {
            TopicResultsAdapter topicResultsAdapter = new TopicResultsAdapter(this, getContext(), mTopic);
            topicResultsBinding.recyclerViewTopicResults.setAdapter(topicResultsAdapter);
            topicResultsAdapter.notifyDataSetChanged();
        }
    }

    public void populateView() {
        questions = mTopic.getQuestions();
        resultPercentage = mTopic.getResultPercentage();

        String resultPercentageString;
        boolean allQuestionAnswered = true;

        for (Question q : questions) {
            if (!q.isAnswered()) {
                allQuestionAnswered = false;
                break;
            }
        }

        if (allQuestionAnswered) {
            resultPercentageString = getString(R.string.percentage, resultPercentage);
        } else {
            resultPercentageString = getString(R.string.incomplete);
        }

        resultsTitle.setText(getString(R.string.topic_results));

        String resultsTextInTextView = resultsPercentage.getText().toString();

        if(!resultsTextInTextView.equals(resultPercentageString)){
            resultsPercentage.setText(resultPercentageString);
        }

        if (allQuestionAnswered){
            if(resultPercentage == 100){
                String descriptionPerfect = getString(R.string.topic_results_description_perfect, resultPercentage);
                        resultsDescription.setText(descriptionPerfect);
            }else if(resultPercentage >= 80 && resultPercentage < 100){
                String descriptionExcellent = getString(R.string.topic_results_description_excellent, resultPercentage);
                resultsDescription.setText(descriptionExcellent);
            }else if(resultPercentage >= 50 && resultPercentage < 80){
                String descriptionAverage = getString(R.string.topic_results_description_average, resultPercentage);
                resultsDescription.setText(descriptionAverage);
            }else if(resultPercentage < 50){
                String descriptionBelowAverage = getString(R.string.topic_results_description_below_average, resultPercentage);
                resultsDescription.setText(descriptionBelowAverage);
            }
        }else {
            resultsDescription.setText(R.string.topic_results_description_incomplete);
        }
    }

    @Override
    public void onItemClickListener(int itemId) {
        if (!questions.get(itemId).isAnswered()) {
            int questionNumber = itemId + 1;
            Intent intent = new Intent(getContext(), DialogCreations.check(questionNumber));
            intent.putExtra(EXTRA_TOPIC_ID, topicId);
            startActivity(intent);
        }
    }

    private void addTopicTitleAndResultPref() {
        String title = mTopic.getName();

        ResultsSharedPreferences.setPrefTopicId(getContext(), topicId);
        ResultsSharedPreferences.setPrefTopicTitle(getContext(), title);
        ResultsSharedPreferences.setPrefTopicResultPercentage(getContext(), resultPercentage);
    }
}
