package com.arr.angel.pertpratice.util;

import com.arr.angel.pertpratice.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class TopicData {

    private List<Topic> topicList = new ArrayList<>();

    private List<Topic> makeTopics(){
        Topic topicPracticeTest = new Topic(00,"Practice Test", new QuestionData().getQuestionListPracticeTest());
        Topic topic1 = new Topic(01,"Basic", new QuestionData().getQuestionListPracticeTest());
        Topic topic2 = new Topic(02,"Intermediate", new QuestionData().getQuestionListPracticeTest());
        Topic topic3 = new Topic(03,"Advanced", new QuestionData().getQuestionListPracticeTest());
        Topic topic4 = new Topic(04,"Application", new QuestionData().getQuestionListPracticeTest());

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
