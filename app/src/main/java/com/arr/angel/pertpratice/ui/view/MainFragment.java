package com.arr.angel.pertpratice.ui.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
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
import com.arr.angel.pertpratice.util.TopicData;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.List;

public class MainFragment extends Fragment implements TopicListAdapter.ItemClickListener {

    private static final String TAG = MainFragment.class.getSimpleName();

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
        mainFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);
        mainFragmentBinding.setLifecycleOwner(this);

        mainFragmentBinding.recyclerViewTopics.setLayoutManager(new LinearLayoutManager(getActivity()));


        return mainFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        topicViewModel = ViewModelProviders.of(this).get(TopicViewModel.class);
        fetchTopics();

        topicViewModel.getLiveTopicListData().observe(this, new Observer<List<Topic>>() {
            @Override
            public void onChanged(@Nullable List<Topic> topics) {
                Log.i(TAG, "OnChanged called!");
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
    public void onItemClickListener(int itemId) {
        Toast.makeText(getContext(), "working: " + itemId, Toast.LENGTH_SHORT).show();
    }

    //get Topic and Question data and set data into viewModel
    public void fetchTopics(){
        mTopicList = new TopicData().getTopicList();
        topicViewModel.setLiveTopicListData(mTopicList);
    }

    //make sure data is in before assigning to adapter
    private void setupAdapter(){
        if(isAdded() && mTopicList != null){
            TopicListAdapter topicListAdapter = new TopicListAdapter(this, getContext(), topicViewModel);
            mainFragmentBinding.recyclerViewTopics.setAdapter(topicListAdapter);
            topicListAdapter.notifyDataSetChanged();
        }
    }

}
