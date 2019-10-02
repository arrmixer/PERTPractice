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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.OverallResultsBinding;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.util.DialogCreations;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.List;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;

public class OverallResultsFragment extends Fragment implements OverallResultsAdapter.ItemClickListenerOverallResults{

    private static final String TAG = OverallResultsFragment.class.getSimpleName();
    private TopicViewModel topicViewModel;
    private OverallResultsBinding overallResultsBinding;

    /*Placeholders for Topics*/
    private List<Topic> mTopicList;


    //views
    TextView overallDescription;

    public static OverallResultsFragment newInstance(){

        return new OverallResultsFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        overallResultsBinding = DataBindingUtil.inflate(inflater, R.layout.overall_results, container, false);

        overallResultsBinding.setLifecycleOwner(this);

        overallResultsBinding.recyclerViewOverallResults.setLayoutManager(new LinearLayoutManager(getActivity()));

        return overallResultsBinding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        overallDescription = overallResultsBinding.textViewOverallResultsDescription;

        topicViewModel = ViewModelProviders.of(this).get(TopicViewModel.class);

        topicViewModel.getLiveTopicListDataFromDB().observe(this, new Observer<List<Topic>>() {
            @Override
            public void onChanged(@Nullable List<Topic> topics) {
//                Log.i(TAG, "OnChanged called!");
                mTopicList = topics;
                setupAdapter();
            }
        });


    }

    //also added text to description textView
    private void setupAdapter(){
        if (isAdded() && mTopicList != null) {
            OverallResultsAdapter overallResultsAdapter = new OverallResultsAdapter(this, getContext(), mTopicList);
            overallResultsBinding.recyclerViewOverallResults.setAdapter(overallResultsAdapter);

            //logic to add description based on whether all topics completed or not
            if(allTopicsComplete(mTopicList)){
                overallDescription.setText(R.string.overall_results_description_complete);
            }else{
                overallDescription.setText(R.string.overall_results_description_incomplete);
            }

            overallResultsAdapter.notifyDataSetChanged();
        }

    }

    // TODO: refactor this method into UTIL folder
    //helper method used to determined if all topics are completed
    public boolean allTopicsComplete(List<Topic> list){
        boolean done = true;


        for(Topic topic : list){

            //check to see if any questions in the topic are unanswered
            //if so, assign done to false and break loop
            for(Question q : topic.getQuestions()){
                if(!q.isAnswered()){
                    done = false;
                    break;
                }
            }

            if(!done){
                break;
            }
        }

        return done;
    }

    @Override
    public void onItemClickListener(int itemId) {

        List<Question> questions = mTopicList.get(itemId).getQuestions();
        int questionNumber = 0;

        for(Question q : questions){
            if(!q.isAnswered()){
                questionNumber = Integer.parseInt(q.getId().substring(3));
                break;
            }
        }

        Log.d(TAG, "Item number is " + itemId);


        Intent intent = new Intent(getContext(), DialogCreations.check(questionNumber));
        intent.putExtra(EXTRA_TOPIC_ID, itemId);
        startActivity(intent);
    }
}
