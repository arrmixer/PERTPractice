package com.arr.angel.pertpratice.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.arr.angel.pertpratice.db.AppExecutors;
import com.arr.angel.pertpratice.db.TopicRepository;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Executor;

public class TopicViewModel extends AndroidViewModel {

    private Topic mTopic;


    private final TopicRepository topicRepository;
    private MutableLiveData<List<Topic>> mLiveTopicListData;


    public TopicViewModel(@NonNull Application application) {
        super(application);
        topicRepository = new TopicRepository(application, AppExecutors.getInstance().diskIO());
    }

    public void setLiveTopicData(Topic topicData) {
        MutableLiveData mLiveTopicData = new MutableLiveData<>();
        mLiveTopicData.setValue(topicData);
    }

    public LiveData<Topic> getLiveTopicDataFromDB(int id) {

        return topicRepository.getTopicFromDB(id);
    }

    public void setLiveTopicListData() {
        mLiveTopicListData = new MutableLiveData<>();
        mLiveTopicListData.setValue(topicRepository.getTopics());
    }

    public MutableLiveData<List<Topic>> getLiveTopicListData() {
        return mLiveTopicListData;
    }

    public LiveData<List<Topic>> getLiveTopicListDataFromDB() {

        return topicRepository.getTopicsList();
    }

    public void setTopic(Topic topic) {
        mTopic = topic;
    }

    public String getName() {
        return mTopic.getName();
    }

    public int getId() {
        return mTopic.getId();
    }

    public List<Question> getQuestions() {
        return mTopic.getQuestions();
    }


}
