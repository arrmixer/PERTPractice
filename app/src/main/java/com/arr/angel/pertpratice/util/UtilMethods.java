package com.arr.angel.pertpratice.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.ui.view.MainActivity;
import com.arr.angel.pertpratice.ui.view.MainFragment;
import com.arr.angel.pertpratice.ui.view.Question01Activity;

import java.util.List;

//class used to generic helper methods
public class UtilMethods {

    public static String showTopicTitle(int topicId){

        switch (topicId){
            case 0:
                return "Practice Test";
            case 1:
                return "Basic";
            case 2:
                return "Intermediate";
            case 3:
                return "Advance";
            case 4:
                return "Application";
        }

        return "PERTPractice";
    }

    //calculate the percentage for each topic
    public static int calculateTotalPercentage(List<Question> questions) {
        int totalQuestions = questions.size();
        int correct = 0;

        for (Question q : questions) {
            if (q.isCorrect() && q.isAnswered()) {
                correct++;
            }
        }

//        float percentage = (float) correct / (float) totalQuestions;
////        int roundPercentage = Math.round(percentage * 100);

        int roundPercentage = calculatePercentage(correct, totalQuestions);
        return roundPercentage;
    }


    public static int calculatePercentage(int correct, int totalQuestions){
        float percentage = (float) correct / (float) totalQuestions;
        int roundPercentage = Math.round(percentage * 100);
        return roundPercentage;
    }

}
