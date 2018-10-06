package com.arr.angel.pertpratice.util;


import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Test;

import java.util.ArrayList;
import java.util.List;

public class QuestionData {

    private List<Question> questionListPraticeTest = new ArrayList<>();


    private List<Question> makePracticeTestQuestions(){
        Question question1PT = new Question("PT01");
        Question question2PT = new Question("PT02");
        Question question3PT = new Question("PT03");
        Question question4PT = new Question("PT04");
        Question question5PT = new Question("PT05");
        Question question6PT = new Question("PT06");

        questionListPraticeTest.add(question1PT);
        questionListPraticeTest.add(question2PT);
        questionListPraticeTest.add(question3PT);
        questionListPraticeTest.add(question4PT);
        questionListPraticeTest.add(question5PT);
        questionListPraticeTest.add(question6PT);

        return questionListPraticeTest;
    }

    public List<Question> getQuestionListPraticeTest() {
        return makePracticeTestQuestions();
    }
}
