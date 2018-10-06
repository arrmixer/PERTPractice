package com.arr.angel.pertpratice.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;

import java.util.List;

public class TopicViewModel extends AndroidViewModel {

    private Topic mTopic;

    private final MutableLiveData<List<Topic>> mLiveTopicListData;
    private final MutableLiveData<Topic> mLiveTopicData;


    public TopicViewModel(@NonNull Application application) {
        super(application);
        mLiveTopicListData = new MutableLiveData<>();
        mLiveTopicData = new MutableLiveData<>();

    }

    public void setLiveTopicData(Topic topicData){
        mLiveTopicData.setValue(topicData);
    }

    public MutableLiveData<Topic> getLiveTopicData() {
        return mLiveTopicData;
    }

    public void setLiveTopicListData(List<Topic> topics){
        mLiveTopicListData.setValue(topics);
    }

    public MutableLiveData<List<Topic>> getLiveTopicListData() {
        return mLiveTopicListData;
    }

    public void setTopic(Topic topic){
        mTopic = topic;
    }

    public String getName() {
        return mTopic.getName();
    }

    public List<Question> getQuestions(){
        return mTopic.getQuestions();
    }




}
