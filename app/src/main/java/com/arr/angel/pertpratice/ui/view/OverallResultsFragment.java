package com.arr.angel.pertpratice.ui.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.OverallResultsBinding;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.List;

public class OverallResultsFragment extends Fragment {

    private static final String TAG = OverallResultsFragment.class.getSimpleName();

    //instance of ViewModel
    private TopicViewModel topicViewModel;

    //DataBinding instance
    OverallResultsBinding overallResultsBinding;

    /*Placeholders for Topics*/
    private List<Topic> mTopicList;


    //views
    TextView overallDescription;

    public static OverallResultsFragment newInstance(){
        OverallResultsFragment overallResultsFragment = new OverallResultsFragment();

        return overallResultsFragment;
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
                Log.i(TAG, "OnChanged called!");
                mTopicList = topics;
                setupAdapter();
            }
        });


    }

    private void setupAdapter(){
        if (isAdded() && mTopicList != null) {
            OverallResultsAdapter overallResultsAdapter = new OverallResultsAdapter(getContext(), mTopicList);
            overallResultsBinding.recyclerViewOverallResults.setAdapter(overallResultsAdapter);
            overallResultsAdapter.notifyDataSetChanged();
        }

    }
}
