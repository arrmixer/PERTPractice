package com.arr.angel.pertpratice.util;


import com.arr.angel.pertpratice.model.Question;


import java.util.ArrayList;
import java.util.List;

public class QuestionData {

    private List<Question> questionListPraticeTest = new ArrayList<>();
    private List<String> mPossibleAnswers;


    //adding mock question01 data
    private List<Question> makePracticeTestQuestions(){
        Question question1PT = new Question("PT01");
        Question question2PT = new Question("PT02");
        Question question3PT = new Question("PT03");
        Question question4PT = new Question("PT04");
        Question question5PT = new Question("PT05");
        Question question6PT = new Question("PT06");

        question1PT.setContent("Which of the following is a solution to the equation c + (4 - 3c) - 2 = 0");

        question1PT.setPossibleAnswers(makePossibleAnswers("-1", "0", "1", "2"));
        question1PT.setAnswer(question1PT.getPossibleAnswers().get(2));


        question2PT.setContent("Which of the following is a solution to the equation x\u00B2 - 6x + 5 = 0?");
        question2PT.setPossibleAnswers(makePossibleAnswers("-5", "-1", "1/5", "5"));
        question2PT.setAnswer(question2PT.getPossibleAnswers().get(3));

        question3PT.setContent("Which of the following is equivalent to the expression (3ab)(-5ab)?");
        question3PT.setPossibleAnswers( makePossibleAnswers("-2ab", "-2a\u00B2b\u00B2", "-15ab", "-15a\u00B2b\u00B2"));
        question3PT.setAnswer(question3PT.getPossibleAnswers().get(3));

        question4PT.setContent("Factor completely: x\u00B2 - x - 6");
        question4PT.setPossibleAnswers(makePossibleAnswers("(x - 2)(x + 3)", "(x - 1)(x - 6)", "(x + 2)(x - 3)","(x + 1)(x - 6)"));
        question4PT.setAnswer(question4PT.getPossibleAnswers().get(2));

        question5PT.setContent("Which of the following is equivalent to (8 - 5) / 2\u00B3?");
        question5PT.setPossibleAnswers(makePossibleAnswers("3/8", "19/8", "27/48", "1/125"));
        question5PT.setAnswer(question5PT.getPossibleAnswers().get(0));

        question6PT.setContent("What is the value of the algebraic expression if x = 1/2, y = -1, and z = 2? 6x(y\u00B2z)");
        question6PT.setPossibleAnswers(makePossibleAnswers("-12", "-6", "1", "6"));
        question6PT.setAnswer(question6PT.getPossibleAnswers().get(3));


        questionListPraticeTest.add(question1PT);
        questionListPraticeTest.add(question2PT);
        questionListPraticeTest.add(question3PT);
        questionListPraticeTest.add(question4PT);
        questionListPraticeTest.add(question5PT);
        questionListPraticeTest.add(question6PT);

        return questionListPraticeTest;
    }

    public List<Question> getQuestionListPracticeTest() {
        return makePracticeTestQuestions();
    }

    public List<String> makePossibleAnswers(String a, String b, String c, String d){

        List<String> possibleAnswers = new ArrayList<>();

        possibleAnswers.add(a);
        possibleAnswers.add(b);
        possibleAnswers.add(c);
        possibleAnswers.add(d);



        return possibleAnswers;

    }

}
