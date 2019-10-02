package com.arr.angel.pertpratice.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.arr.angel.pertpratice.model.Topic
import com.arr.angel.pertpratice.util.TopicData
import kotlinx.coroutines.launch

class TopicRepository(ctx: Context) {
    val topics : List<Topic>? = TopicData().getTopicList()
    lateinit var mTopicsListLiveData : LiveData<List<Topic>>
    lateinit var mTopicLiveData : LiveData<Topic>

    private val topicDao by lazy { AppDatabase.getInstance(ctx).mTopicDao() }

    fun getTopicsList() : LiveData<List<Topic>> {
        mTopicsListLiveData = topicDao.loadAllTopics()
        return mTopicsListLiveData
    }

    fun getTopicFromDB(topicId : Int) : LiveData<Topic> {
        mTopicLiveData = topicDao.loadTopicById(topicId)
        return mTopicLiveData
    }

    fun addTopicsToDB() {
        for (topic in topics?: emptyList()) {
            dbScope.launch {
                topicDao.insertTopic(topic)
            }
        }
    }

    fun updateTopic(topic: Topic) {
        dbScope.launch { topicDao.updateTopic(topic) }
    }

    fun deleteTopic(topic: Topic) {
        dbScope.launch { topicDao.deleteTopic(topic) }
    }

    fun insertTopic(topic: Topic) {
        dbScope.launch { topicDao.insertTopic(topic) }
    }

    fun loadData() {
        addTopicsToDB()
    }
}