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
import android.widget.Toast;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.MainFragmentBinding;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.List;

public class MainFragment extends Fragment implements TopicListAdapter.ItemClickListener {

    private static final String TAG = MainFragment.class.getSimpleName();
    public static final String EXTRA_TOPIC_ID = "com.arr.angel.pertpratice.ui.view.topic.id";
    public static final String EXTRA_ANSWER = "com.arr.angel.pertpratice.ui.view.answer";
    public static final String EXTRA_POSSIBLE_ANSWERS = "com.arr.angel.pertpratice.ui.view.possibleAnswers";
    public static final String EXTRA_IS_NEXT_UNANSWERED_QUESTION_ID = "com.arr.angel.pertpratice.ui.view.is.next.unanswered.question.id";
    public static final String EXTRA_CURRENT_QUESTION_ID = "com.arr.angel.pertpratice.ui.view.is.current.question.id";

    public static final String ARGS_TOPIC_ID = "com.arr.angel.pertpratice.ui.view.topic.id";
    public static final String ARGS_CURRENT_ID = "com.arr.angel.pertpratice.ui.view.topic.question.id";
    public static final String ARG_IS_CORRECT = "com.arr.angel.pertpratice.ui.view.is.correct.arg";
    public static final String ARG_IS_ANSWERED = "com.arr.angel.pertpratice.ui.view.is.answered.arg";

    /*Placeholders for Topics*/
    private List<Topic> mTopicList;

    //instance of ViewModel
    private TopicViewModel topicViewModel;

    //DataBinding instance
    MainFragmentBinding mainFragmentBinding;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);
        mainFragmentBinding.setLifecycleOwner(this);

        mainFragmentBinding.recyclerViewTopics.setLayoutManager(new LinearLayoutManager(getActivity()));


        return mainFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        topicViewModel = ViewModelProviders.of(this).get(TopicViewModel.class);
        topicViewModel.getLiveTopicListDataFromDB().observe(this, new Observer<List<Topic>>() {
            @Override
            public void onChanged(@Nullable List<Topic> topics) {
                Log.i(TAG, "OnChanged called!");
                if(topics != null){
                    if(topics.isEmpty()){
                        topicViewModel.loadDataIntoDb();
                    }
                }

                mTopicList = topics;
                setupAdapter();
            }
        });


    }

    //release the callback once the fragment is detached
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mCallbacks = null;
//    }

    @Override
    public void onItemClickListener(int itemId, String tag) {
//        Toast.makeText(getContext(), "working: " + tag + " "+ itemId, Toast.LENGTH_SHORT).show();
        if(tag.equals(getString(R.string.topic_practice))){
            Intent intent = new Intent(getContext(), Question01Activity.class);
            intent.putExtra(EXTRA_TOPIC_ID, itemId);
            startActivity(intent);
        }else if(tag.equals(getString(R.string.topic_results))){
            Intent intent = new Intent(getContext(), TopicResultsActivity.class);
            intent.putExtra(EXTRA_TOPIC_ID, itemId);
            startActivity(intent);
        }
    }


    //make sure data is in before assigning to adapter
    private void setupAdapter(){
        if(isAdded() && mTopicList != null){
            TopicListAdapter topicListAdapter = new TopicListAdapter(this, getContext(), mTopicList);
            mainFragmentBinding.recyclerViewTopics.setAdapter(topicListAdapter);
            topicListAdapter.notifyDataSetChanged();
        }
    }

}
