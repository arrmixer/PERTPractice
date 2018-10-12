package com.arr.angel.pertpratice.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.util.TopicData;

import java.util.List;
import java.util.concurrent.Executor;

public class TopicRepository {


    private final TopicDao mTopicDao;
    private LiveData<List<Topic>> mTopicsListLiveData;
    private LiveData<Topic> mTopicLiveData;
    private List<Topic> topics;
    private final Executor executor;

    public TopicRepository(Application application, Executor executor) {
        AppDatabase db = AppDatabase.getInstance(application);
        mTopicDao = db.mTopicDao();
        this.executor = executor;
    }

    public LiveData<List<Topic>> getTopicsList() {
        mTopicsListLiveData = mTopicDao.loadAllTopics();
        return mTopicsListLiveData;
    }

    public void deleteTopic(final Topic topic) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mTopicDao.deleteTopic(topic);
            }
        });
    }

    public void insertTopic(final Topic topic) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mTopicDao.insertTopic(topic);
            }
        });
    }

    public void updateTopic(final Topic topic) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mTopicDao.updateTopic(topic);
            }
        });
    }

    public LiveData<Topic> getTopicFromDB(int topicId) {
        mTopicLiveData = mTopicDao.loadTopicById(topicId);
        return mTopicLiveData;
    }

    private void addTopicsToDB() {
        topics = new TopicData().getTopicList();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (Topic t : topics) {
                    mTopicDao.insertTopic(t);
                }
            }
        });
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void loadData(){
        addTopicsToDB();
    }
}
