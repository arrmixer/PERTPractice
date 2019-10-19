package com.arr.angel.pertpratice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.arr.angel.pertpratice.db.TopicRepository
import com.arr.angel.pertpratice.model.Topic

class TopicViewModel(application: Application) : AndroidViewModel(application){
    private val topicRepository =  TopicRepository(application)

    fun loadDataIntoDb() {
        if (topicRepository.getTopicsList().hasActiveObservers()) {
            topicRepository.loadData()
        }
    }

    fun getLiveTopicDataFromDB(id: Int) : LiveData<Topic> {
        return topicRepository.getTopicFromDB(id)
    }

    fun getLiveTopicListDataFromDB(): LiveData<List<Topic>> {
        return topicRepository.getTopicsList()
    }

    fun insertTopic(topic: Topic) {
        topicRepository.insertTopic(topic)
    }
}