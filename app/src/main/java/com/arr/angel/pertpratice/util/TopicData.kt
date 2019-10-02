package com.arr.angel.pertpratice.util

import com.arr.angel.pertpratice.model.Topic
import java.util.*

//TODO: move to FireBase DB
class TopicData {
    private val topicList: MutableList<Topic> = ArrayList()
    private fun makeTopics(): List<Topic> {
        val topicPracticeTest = Topic(0, "Practice Test", QuestionData().getQuestionListPracticeTest())
        val topic1 = Topic(1, "Basic", QuestionData().getQuestionListBasic())
        val topic2 = Topic(2, "Intermediate", QuestionData().getQuestionListIntermediate())
        val topic3 = Topic(3, "Advance", QuestionData().getQuestionListAdvance())
        val topic4 = Topic(4, "Application", QuestionData().getQuestionListApplication())
        topicList.add(topicPracticeTest)
        topicList.add(topic1)
        topicList.add(topic2)
        topicList.add(topic3)
        topicList.add(topic4)
        return topicList
    }

    fun getTopicList(): List<Topic> {
        return makeTopics()
    }
}