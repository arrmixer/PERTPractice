package com.arr.angel.pertpratice.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.annotation.NonNull;

import com.arr.angel.pertpratice.db.AppExecutors;
import com.arr.angel.pertpratice.db.TopicRepository;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;

import java.util.List;

public class TopicViewModel extends AndroidViewModel {

    private Topic mTopic;


    private final TopicRepository topicRepository;
    private MutableLiveData<List<Topic>> mLiveTopicListData;


    public TopicViewModel(@NonNull Application application) {
        super(application);
        topicRepository = new TopicRepository(application, AppExecutors.getInstance().diskIO());
    }

    public void loadDataIntoDb(){
        if(!topicRepository.getTopicsList().hasActiveObservers())
        topicRepository.loadData();
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

    public void updateTopic(Topic topic){
        topicRepository.updateTopic(topic);
    }

    public void insertTopic(Topic topic){
        topicRepository.insertTopic(topic);
    }


}
