package com.arr.angel.pertpratice.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import androidx.annotation.NonNull;

import com.arr.angel.pertpratice.db.ConverterQuestion;

import java.util.List;

@Entity(tableName = "topics")
public class Topic {

    @PrimaryKey
    @ColumnInfo(name = "topic_id")
    @NonNull
    private int id;

    private String name;

    private int resultPercentage;

    @TypeConverters(ConverterQuestion.class)
    private List<Question> questions;

    public Topic(int id, String name, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getResultPercentage() {
        return resultPercentage;
    }

    public void setResultPercentage(int resultPercentage) {
        this.resultPercentage = resultPercentage;
    }

    //calculate the percentage for each topic
    private int calculateTotalPercentage() {
        List<Question> questions = getQuestions();
        int totalQuestions = questions.size();
        int correct = 0;

        for (Question q : questions) {
            if (q.isCorrect() && q.isAnswered()) {
                correct++;
            }
        }

        float percentage = (float) correct / (float) totalQuestions;
        int roundPercentage = Math.round(percentage * 100);
        return roundPercentage;
    }


}
