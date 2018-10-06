package com.arr.angel.pertpratice.util;

import com.arr.angel.pertpratice.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class TopicData {

    private List<Topic> topicList = new ArrayList<>();

    private List<Topic> makeTopics(){
        Topic topicPracticeTest = new Topic("Practice Test", new QuestionData().getQuestionListPraticeTest());
        Topic topic1 = new Topic("Basic", new QuestionData().getQuestionListPraticeTest());
        Topic topic2 = new Topic("Intermediate", new QuestionData().getQuestionListPraticeTest());
        Topic topic3 = new Topic("Advanced", new QuestionData().getQuestionListPraticeTest());
        Topic topic4 = new Topic("Application", new QuestionData().getQuestionListPraticeTest());

        topicList.add(topicPracticeTest);
        topicList.add(topic1);
        topicList.add(topic2);
        topicList.add(topic3);
        topicList.add(topic4);


        return topicList;
    }

    public List<Topic> getTopicList() {
        return makeTopics();
    }
}
