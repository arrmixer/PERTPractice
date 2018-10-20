package com.arr.angel.pertpratice.ui.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.TopicResultsBinding;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.util.DialogCreations;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.List;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;
import static com.arr.angel.pertpratice.ui.view.Question01Fragment.ARGS_TOPIC_ID;
import static com.arr.angel.pertpratice.ui.view.Question02Fragment.ARG_IS_ANSWERED;
import static com.arr.angel.pertpratice.ui.view.Question02Fragment.ARG_IS_CORRECT;

public class TopicResultsFragment extends Fragment implements TopicResultsAdapter.ItemClickListenerTopicResults{

    private static final String TAG = TopicResultsFragment.class.getSimpleName();

    //instance of ViewModel
    private TopicViewModel topicViewModel;

    //DataBinding instance
    TopicResultsBinding topicResultsBinding;


    //views
    private TextView resultsPercentage;
    private TextView resultsDescription;


    /*Placeholders for Topics, question fields,
     * and topicId*/
    private Topic mTopic;
    private List<Question> questions;
    private Question question;

    //boolean values of previous questions
    private boolean previousIsAnswered;
    private boolean previousIsCorrect;
    private int topicId;


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        //must implement interface on MainActivity
//        //because cast is unchecked
//        mCallbacks = (Callbacks) context;
//    }

    public static TopicResultsFragment newInstance(boolean correct, boolean answered, int topicId) {

        TopicResultsFragment topicResultsFragment = new TopicResultsFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(ARG_IS_CORRECT, correct);
        bundle.putBoolean(ARG_IS_ANSWERED, answered);
        bundle.putInt(Question01Fragment.ARGS_TOPIC_ID, topicId);
        topicResultsFragment.setArguments(bundle);

        return topicResultsFragment;

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
            previousIsAnswered = getArguments().getBoolean(ARG_IS_ANSWERED);
            previousIsCorrect = getArguments().getBoolean(ARG_IS_CORRECT);
            topicId = getArguments().getInt(ARGS_TOPIC_ID);
        }

        resultsPercentage = topicResultsBinding.textViewTopicTotalResultsPercentage;
        resultsDescription = topicResultsBinding.textViewTopicTotalResultsDescription;

        topicViewModel = ViewModelProviders.of(this).get(TopicViewModel.class);

        topicViewModel.getLiveTopicDataFromDB(topicId).observe(this, new Observer<Topic>() {
            @Override
            public void onChanged(@Nullable Topic topic) {
                mTopic = topic;
                populateView();
                setupAdapter();
                if (previousIsAnswered) {
                    Question previousQuestion = questions.get(5);
                    previousQuestion.setCorrect(previousIsCorrect);
                    previousQuestion.setAnswered(previousIsAnswered);
                    topicViewModel.insertTopic(mTopic);
                }
            }
        });


    }

    //release the callback once the fragment is detached
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mCallbacks = null;
//    }

    //    make sure data is in before assigning to adapter
    private void setupAdapter() {
        if (isAdded() && mTopic != null) {
            TopicResultsAdapter topicResultsAdapter = new TopicResultsAdapter(this, getContext(), mTopic);
            topicResultsBinding.recyclerViewTopicResults.setAdapter(topicResultsAdapter);
            topicResultsAdapter.notifyDataSetChanged();
        }
    }

    public void populateView() {


        questions = mTopic.getQuestions();
        int resultPercentage = mTopic.getResultPercentage();

        //format String percentage
        String resultPercentageString = getString(R.string.percentage, resultPercentage);
        resultsPercentage.setText(resultPercentageString);
        resultsDescription.setText(R.string.latin_text);

    }

    @Override
    public void onItemClickListener(int itemId) {
        if(!questions.get(itemId).isAnswered()){
            int questionNumber = itemId + 1;
            Intent intent = new Intent(getContext(), DialogCreations.check(questionNumber));
            intent.putExtra(EXTRA_TOPIC_ID, topicId);
            startActivity(intent);
        }
    }
}
