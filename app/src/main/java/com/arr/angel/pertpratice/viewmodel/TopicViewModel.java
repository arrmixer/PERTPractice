package com.arr.angel.pertpratice.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;
import com.arr.angel.pertpratice.db.TopicRepository;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;

import java.util.List;

public class TopicViewModel extends AndroidViewModel {

    private Topic mTopic;
    private final TopicRepository topicRepository;

    public TopicViewModel(@NonNull Application application) {
        super(application);
        topicRepository = new TopicRepository(application);
    }

    public void loadDataIntoDb(){
        if(!topicRepository.getTopicsList().hasActiveObservers())
        topicRepository.loadData();
    }

    public LiveData<Topic> getLiveTopicDataFromDB(int id) {
        return topicRepository.getTopicFromDB(id);
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

    public void insertTopic(Topic topic){
        topicRepository.insertTopic(topic);
    }
}
