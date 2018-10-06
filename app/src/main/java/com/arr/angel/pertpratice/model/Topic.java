package com.arr.angel.pertpratice.model;


import java.util.List;

public class Topic {

    private int id;
    private String name;
    private List<Question> questions;

    public Topic(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    //calculate the percentage for each topic
    public int calculateTotalPercentage(List<Question> questions){
        int totalQuestions = questions.size();
        int correct = 0;

        for(Question q : questions){
            if(q.isCorrect()){
                correct++;
            }
        }

        float percentage = (float) correct/ (float) totalQuestions;
        int roundPercentage = Math.round(percentage * 100);
        return roundPercentage;
    }


}
