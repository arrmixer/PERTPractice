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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.TopicResultsBinding;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.List;

import static com.arr.angel.pertpratice.ui.view.Question01Fragment.ARGS_TOPIC_ID;
import static com.arr.angel.pertpratice.ui.view.Question02Fragment.ARG_IS_ANSWERED;
import static com.arr.angel.pertpratice.ui.view.Question02Fragment.ARG_IS_CORRECT;

public class TopicResultsFragment extends Fragment {

    private static final String TAG = TopicResultsFragment.class.getSimpleName();
    public static final String EXTRA_TOPIC_ID = "com.arr.angel.pertpratice.ui.view.topic.id";

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
    private boolean isAnswered;
    private boolean isCorrect;
    private int topicId;


    //instance of Callback
    private Callbacks mCallbacks;

    //Interface for hosting activities
    public interface Callbacks {
        void onTopicSelected(Topic topic, List<Topic> topics);
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        //must implement interface on MainActivity
//        //because cast is unchecked
//        mCallbacks = (Callbacks) context;
//    }

    public static TopicResultsFragment newInstance(boolean correct, boolean answered,int topicId) {

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

        topicResultsBinding = DataBindingUtil.inflate(inflater, R.layout.topic_results,container, false);
        topicResultsBinding.setLifecycleOwner(this);

        topicResultsBinding.recyclerViewTopicResults.setLayoutManager(new LinearLayoutManager(getActivity()));


        return topicResultsBinding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null){
            isAnswered = getArguments().getBoolean(ARG_IS_ANSWERED);
            isCorrect = getArguments().getBoolean(ARG_IS_CORRECT);
            topicId = getArguments().getInt(ARGS_TOPIC_ID);
        }

        topicViewModel = ViewModelProviders.of(this).get(TopicViewModel.class);

        topicViewModel.getLiveTopicDataFromDB(topicId).observe(this, new Observer<Topic>() {
            @Override
            public void onChanged(@Nullable Topic topic) {
                mTopic = topic;
                populateView();
                if (isAnswered){
                    Question previousQuestion = questions.get(0);
                    previousQuestion.setCorrect(isCorrect);
                    previousQuestion.setAnswered(isAnswered);
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

    //make sure data is in before assigning to adapter
//    private void setupAdapter(){
//        if(isAdded() && mTopicList != null){
//            TopicListAdapter topicListAdapter = new TopicListAdapter(this, getContext(), mTopicList);
//            mainFragmentBinding.recyclerViewTopics.setAdapter(topicListAdapter);
//            topicListAdapter.notifyDataSetChanged();
//        }
//    }

    public void populateView() {

//        questions = mTopic.getQuestions();
//        question = questions.get(1);

    }
}
