package com.arr.angel.pertpratice.ui.view;

import com.arr.angel.pertpratice.model.Question;

import java.util.ArrayList;
import java.util.List;

public class FakeData {



    public List<Question> makeQuestions(){

        Question question = new Question("PT01");
       question.setContent("Which of the following is equivalent to the expression (3ab)(-5ab)?");
       question.setAnswer("-15a^2b^2");
       List<String> possibleAnswers = new ArrayList<>();
       possibleAnswers.add("-2ab");
       possibleAnswers.add("-2a^2b^2");
       possibleAnswers.add("-15ab");

       return null;

    }





}
