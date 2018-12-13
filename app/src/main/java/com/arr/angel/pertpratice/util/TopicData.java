package com.arr.angel.pertpratice.util;

import com.arr.angel.pertpratice.model.Topic;

import java.util.ArrayList;
import java.util.List;

//TODO: move to FireBase DB
public class TopicData {

    private List<Topic> topicList = new ArrayList<>();

    private List<Topic> makeTopics(){
        Topic topicPracticeTest = new Topic(0,"Practice Test", new QuestionData().getQuestionListPracticeTest());
        Topic topic1 = new Topic(1,"Basic", new QuestionData().getQuestionListBasic());
        Topic topic2 = new Topic(2,"Intermediate", new QuestionData().getQuestionListIntermediate());
        Topic topic3 = new Topic(3,"Advance", new QuestionData().getQuestionListAdvance());
        Topic topic4 = new Topic(4,"Application", new QuestionData().getQuestionListApplication());

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
