package com.arr.angel.pertpratice.util;


import com.arr.angel.pertpratice.model.Question;


import java.util.ArrayList;
import java.util.List;

//TODO: move to FireBase DB
public class QuestionData {

    //list for questions for each topic
    private List<Question> questionListPracticeTest = new ArrayList<>();
    private List<Question> questionListBasic = new ArrayList<>();
    private List<Question> questionListIntermediate = new ArrayList<>();
    private List<Question> questionListAdvance = new ArrayList<>();
    private List<Question> questionListApplication = new ArrayList<>();


    /*method used to populate question data will transfer to cloud storage
     * and create a service via Firebase later on*/
    private List<Question> makePracticeTestQuestions() {
        Question question1PT = new Question("PT01");
        Question question2PT = new Question("PT02");
        Question question3PT = new Question("PT03");
        Question question4PT = new Question("PT04");
        Question question5PT = new Question("PT05");
        Question question6PT = new Question("PT06");

        question1PT.setContent("Which of the following is a solution to the equation c + (4 - 3c) - 2 = 0?");
        question1PT.setPossibleAnswers(makePossibleAnswers("-1", "0", "1", "2"));
        question1PT.setAnswer(question1PT.getPossibleAnswers().get(2));


        question2PT.setContent("Which of the following is a solution to the equation x\u00B2 - 6x + 5 = 0?");
        question2PT.setPossibleAnswers(makePossibleAnswers("-5", "-1", "1/5", "5"));
        question2PT.setAnswer(question2PT.getPossibleAnswers().get(3));

        question3PT.setContent("Which of the following is equivalent to the expression (3ab)(-5ab)?");
        question3PT.setPossibleAnswers(makePossibleAnswers("-2ab", "-2a\u00B2b\u00B2", "-15ab", "-15a\u00B2b\u00B2"));
        question3PT.setAnswer(question3PT.getPossibleAnswers().get(3));

        question4PT.setContent("Factor completely: x\u00B2 - x - 6");
        question4PT.setPossibleAnswers(makePossibleAnswers("(x - 2)(x + 3)", "(x - 1)(x - 6)", "(x + 2)(x - 3)", "(x + 1)(x - 6)"));
        question4PT.setAnswer(question4PT.getPossibleAnswers().get(2));

        question5PT.setContent("Which of the following is equivalent to (8 - 5) / 2\u00B3?");
        question5PT.setPossibleAnswers(makePossibleAnswers("3/8", "19/8", "27/48", "1/125"));
        question5PT.setAnswer(question5PT.getPossibleAnswers().get(0));

        question6PT.setContent("What is the value of the algebraic expression if x = 1/2, y = -1, and z = 2? 6x(y\u00B2z)?");
        question6PT.setPossibleAnswers(makePossibleAnswers("-12", "-6", "1", "6"));
        question6PT.setAnswer(question6PT.getPossibleAnswers().get(3));


        questionListPracticeTest.add(question1PT);
        questionListPracticeTest.add(question2PT);
        questionListPracticeTest.add(question3PT);
        questionListPracticeTest.add(question4PT);
        questionListPracticeTest.add(question5PT);
        questionListPracticeTest.add(question6PT);

        return questionListPracticeTest;
    }

    private List<Question> makeBasicQuestions() {
        Question question1Basic = new Question("BA01");
        Question question2Basic = new Question("BA02");
        Question question3Basic = new Question("BA03");
        Question question4Basic = new Question("BA04");
        Question question5Basic = new Question("BA05");
        Question question6Basic = new Question("BA06");

        question1Basic.setContent("Which of the following is equivalent to 7 ⋅ 9 - 4(6 + 7)?");
        question1Basic.setPossibleAnswers(makePossibleAnswers("676", "455", "13", "4"));
        question1Basic.setAnswer(question1Basic.getPossibleAnswers().get(3));

        question2Basic.setContent("Which of the following is equivalent to 22 ÷ 11 ⋅ 9 - 3\u00B3?");
        question2Basic.setPossibleAnswers(makePossibleAnswers("72", "9", "0.5", "12"));
        question2Basic.setAnswer(question2Basic.getPossibleAnswers().get(1));

        question3Basic.setContent("Which of the following is equivalent to 2[5\u00B2 + (36 ÷ 6)]?");
        question3Basic.setPossibleAnswers(makePossibleAnswers("62", "32", "56", "242"));
        question3Basic.setAnswer(question3Basic.getPossibleAnswers().get(0));

        question4Basic.setContent("Evaluate the expression a\u00B2 + b - c\u00B2 if a = 12, b = 9, and c = 4.");
        question4Basic.setPossibleAnswers(makePossibleAnswers("7", "137", "152", "169"));
        question4Basic.setAnswer(question4Basic.getPossibleAnswers().get(1));

        question5Basic.setContent("Evaluate the expression 2c(a + b) if a = 12, b = 9, and c = 4.");
        question5Basic.setPossibleAnswers(makePossibleAnswers("126", "160", "8", "168"));
        question5Basic.setAnswer(question5Basic.getPossibleAnswers().get(3));

        question6Basic.setContent("Evaluate the expression (a\u00B2 ÷ 4b) + c if a = 12, b = 9, and c = 4.");
        question6Basic.setPossibleAnswers(makePossibleAnswers("4.75", "31", "8", "36"));
        question6Basic.setAnswer(question6Basic.getPossibleAnswers().get(2));

        questionListBasic.add(question1Basic);
        questionListBasic.add(question2Basic);
        questionListBasic.add(question3Basic);
        questionListBasic.add(question4Basic);
        questionListBasic.add(question5Basic);
        questionListBasic.add(question6Basic);


        return questionListBasic;
    }

    private List<Question> makeIntermediateQuestions() {
        Question question1Intermediate = new Question("IN01");
        Question question2Intermediate = new Question("IN02");
        Question question3Intermediate = new Question("IN03");
        Question question4Intermediate = new Question("IN04");
        Question question5Intermediate = new Question("IN05");
        Question question6Intermediate = new Question("IN06");

        question1Intermediate.setContent("Which of the following is a solution to the equation -7(-6x + 5) = 385?");
        question1Intermediate.setPossibleAnswers(makePossibleAnswers("9", "10", "55", "1"));
        question1Intermediate.setAnswer(question1Intermediate.getPossibleAnswers().get(1));

        question2Intermediate.setContent("Which of the following is a solution to the equation 16 = -x + 2x + 8?");
        question2Intermediate.setPossibleAnswers(makePossibleAnswers("8", "16/9", "-8", "24"));
        question2Intermediate.setAnswer(question2Intermediate.getPossibleAnswers().get(0));

        question3Intermediate.setContent("Which of the following is a solution to the equation -2x + 7 = -35 + 5x?");
        question3Intermediate.setPossibleAnswers(makePossibleAnswers("14", "7", "6", "4"));
        question3Intermediate.setAnswer(question3Intermediate.getPossibleAnswers().get(2));

        question4Intermediate.setContent("Find the y-intercept for the equation 2x - y = 3");
        question4Intermediate.setPossibleAnswers(makePossibleAnswers("3", "3/2", "-3/2", "-3"));
        question4Intermediate.setAnswer(question4Intermediate.getPossibleAnswers().get(3));

        question5Intermediate.setContent("Find the x-intercept for the equation 2x - y = 3");
        question5Intermediate.setPossibleAnswers(makePossibleAnswers("3", "3/2", "-3/2", "-3"));
        question5Intermediate.setAnswer(question5Intermediate.getPossibleAnswers().get(1));

        question6Intermediate.setContent("Which of the following is equivalent to the expression (2a + b)(3a + b)?");
        question6Intermediate.setPossibleAnswers(makePossibleAnswers("-12a\u00B2b\u00B2", "6a\u00B2-14ab-4b\u00B2", "6a\u00B2-10ab-4b\u00B2", "(2a + b)(3a + b)"));
        question6Intermediate.setAnswer(question6Intermediate.getPossibleAnswers().get(2));

        questionListIntermediate.add(question1Intermediate);
        questionListIntermediate.add(question2Intermediate);
        questionListIntermediate.add(question3Intermediate);
        questionListIntermediate.add(question4Intermediate);
        questionListIntermediate.add(question5Intermediate);
        questionListIntermediate.add(question6Intermediate);


        return questionListIntermediate;
    }

    private List<Question> makeAdvanceQuestions(){

        Question question1Advance= new Question("AD01");
        Question question2Advance= new Question("AD02");
        Question question3Advance= new Question("AD03");
        Question question4Advance= new Question("AD04");
        Question question5Advance= new Question("AD05");
        Question question6Advance= new Question("AD06");

        question1Advance.setContent("Which of the following is a solution to the equation: x\u00B2 - 29x + 100 = 0?");
        question1Advance.setPossibleAnswers(makePossibleAnswers("x = 4, x = 25", "x = -4, x = -25","x = -10, x = -10", "x = 10, x = 10"));
        question1Advance.setAnswer(question1Advance.getPossibleAnswers().get(1));

        question2Advance.setContent("Which of the following is a solution to the equation: x\u00B2 + 7x + 12 = 0?");
        question2Advance.setPossibleAnswers(makePossibleAnswers("x = 3, x = 4", "x = -3, x = -4","x = -6, x = -2", "x = 6, x = 2"));
        question2Advance.setAnswer(question2Advance.getPossibleAnswers().get(0));


        question3Advance.setContent("Which of the following is a solution to the equation: 4x\u00B2 + 6x + 2 = 0?");
        question3Advance.setPossibleAnswers(makePossibleAnswers("x = 2, x = 1", "x = -2, x = -1","x = -1/2, x = -1", "x = 1/2, x = -1"));
        question3Advance.setAnswer(question3Advance.getPossibleAnswers().get(3));

        question4Advance.setContent("Which of the following is a solution to the inequality 15 - 4(x + 10) < 15?");
        question4Advance.setPossibleAnswers(makePossibleAnswers("x < -10","x > -10","x > -2.5","x < -2.5"));
        question4Advance.setAnswer(question4Advance.getPossibleAnswers().get(1));

        question5Advance.setContent("Which of the following is a solution to the inequality 16 + 3(3x - 4) ≥ 76?");
        question5Advance.setPossibleAnswers(makePossibleAnswers("x ≤ 8","x ≥ 11 ","x ≥ 12","x ≥ 8"));
        question5Advance.setAnswer(question5Advance.getPossibleAnswers().get(3));

        question6Advance.setContent("Factor completely: x\u00B2 -3x + 2");
        question6Advance.setPossibleAnswers(makePossibleAnswers("(x + 1)(x + 2)","(x - 2)(x - 1)","(x + 3)(x - 1)","(x - 3)(x + 1)"));
        question6Advance.setAnswer(question6Advance.getPossibleAnswers().get(1));

        questionListAdvance.add(question1Advance);
        questionListAdvance.add(question2Advance);
        questionListAdvance.add(question3Advance);
        questionListAdvance.add(question4Advance);
        questionListAdvance.add(question5Advance);
        questionListAdvance.add(question6Advance);

        return questionListAdvance;
    }

    private List<Question> makeApplicationQuestions(){

        Question question1Application = new Question("AP01");
        Question question2Application = new Question("AP02");
        Question question3Application = new Question("AP03");
        Question question4Application = new Question("AP04");
        Question question5Application = new Question("AP05");
        Question question6Application = new Question("AP06");

        question1Application.setContent("What is 25% of $50?");
        question1Application.setPossibleAnswers(makePossibleAnswers("$25", "$10", "5.50","$12.50"));
        question1Application.setAnswer(question1Application.getPossibleAnswers().get(3));

        question2Application.setContent("What is 20% of $124?");
        question2Application.setPossibleAnswers(makePossibleAnswers("$20", "$24.80", "$15.30", "30"));
        question2Application.setAnswer(question2Application.getPossibleAnswers().get(1));

        question3Application.setContent("What is 15% of $112?");
        question3Application.setPossibleAnswers(makePossibleAnswers("$16.80", "$15.00", "$26.25", "$5.50"));
        question3Application.setAnswer(question3Application.getPossibleAnswers().get(0));

        question4Application.setContent("A rectangular garden has a length of x - 3 and a width of x\u00B2 + 8x + 1. " +
                "Which of the following expressions is equivalent to the area of the yard.");
        question4Application.setPossibleAnswers(makePossibleAnswers("x\u00B2 + 9x - 2","2x\u00B2 + 18x - 4","x³ + 5x\u00B2 - 23x - 3","x\u00B2 - 6x + 9"));
        question4Application.setAnswer(question4Application.getPossibleAnswers().get(2));

        question5Application.setContent("The area of a rectangular garden is x\u00B2 - 3x + 2. Which of the following expressions represent the length and the width of the garden?");
        question5Application.setPossibleAnswers(makePossibleAnswers("(x - 2)(x - 3)","(x - 1)(x - 2)","(x + 2)(x + 1)","(x + 2)(x + 3)"));
        question5Application.setAnswer(question5Application.getPossibleAnswers().get(1));

        question6Application.setContent("Best Buy is selling a television for $1250.00. " +
                "Sales tax in Miami-Dade County is 7%. Using P as the amount I will have to pay " +
                "for the television (including sales tax),write an algebraic equation " +
                "that describes this transaction.");
        question6Application.setPossibleAnswers(makePossibleAnswers("P = (0.07)(1250)","P = 1250 ÷ 0.06","P = 1250 + (0.07)(1250)","P = 1250(0.93)"));
        question6Application.setAnswer(question6Application.getPossibleAnswers().get(2));

        questionListApplication.add(question1Application);
        questionListApplication.add(question2Application);
        questionListApplication.add(question3Application);
        questionListApplication.add(question4Application);
        questionListApplication.add(question5Application);
        questionListApplication.add(question6Application);


        return questionListApplication;
    }




    public List<Question> getQuestionListPracticeTest() {

        return makePracticeTestQuestions();
    }

    public List<Question> getQuestionListBasic() {

        return makeBasicQuestions();
    }

    public List<Question> getQuestionListIntermediate() {

        return makeIntermediateQuestions();
    }

    public List<Question> getQuestionListAdvance() {

        return makeAdvanceQuestions();
    }

    public List<Question> getQuestionListApplication() {
        return makeApplicationQuestions();
    }

    public List<String> makePossibleAnswers(String a, String b, String c, String d) {

        List<String> possibleAnswers = new ArrayList<>();

        possibleAnswers.add(a);
        possibleAnswers.add(b);
        possibleAnswers.add(c);
        possibleAnswers.add(d);


        return possibleAnswers;

    }

}
