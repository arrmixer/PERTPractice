package com.arr.angel.pertpratice.util;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import com.arr.angel.pertpratice.ui.view.MainFragment;
import com.arr.angel.pertpratice.ui.view.OverallTopicResultsActivity;
import com.arr.angel.pertpratice.ui.view.Question01Activity;

public class NavigationDrawerMenuMethods {


    public static void mainDrawerMenuNavigation(Context context, MenuItem menuItem) {

        switch (menuItem.getTitle().toString()) {

            case "Practice Test":
                navToTopic(context, 0);
                break;
            case "Basic":
               navToTopic(context, 1);
                break;
            case "Intermediate":
                navToTopic(context, 2);
                break;
            case "Advance":
                navToTopic(context, 3);
                break;
            case "Application":
                navToTopic(context, 4);
                break;
            case "Overall Results":
                navToOverallResults(context);
                break;

        }


    }

    public static void questionDrawerMenuNavigation(Context context, MenuItem menuItem, int topicId){
        switch (menuItem.getTitle().toString()) {
            case "Question 1":
                navToQuestion(context, topicId, 1);
                break;
            case "Question 2":
                navToQuestion(context, topicId, 2);
                break;
            case "Question 3":
                navToQuestion(context, topicId, 3);
                break;
            case "Question 4":
                navToQuestion(context, topicId, 4);
                break;
            case "Question 5":
                navToQuestion(context, topicId, 5);
                break;
            case "Question 6":
                navToQuestion(context, topicId, 6);
                break;

        }
    }

    //utility method to launch topic from nav menu
    private static void navToTopic(Context context, int topicId) {
        Intent intent = new Intent(context, Question01Activity.class);
        intent.putExtra(MainFragment.EXTRA_TOPIC_ID, topicId);

        context.startActivity(intent);

    }

    private static void navToOverallResults(Context context) {
        Intent intent = new Intent(context, OverallTopicResultsActivity.class);

        context.startActivity(intent);

    }

    //utility method to launch question from nav menu
    //using check() method to get correct Question Activity
    // base on the question number
    private static void navToQuestion(Context context, int topicId, int questionNumber){
        Intent intent = new Intent(context, DialogCreations.check(questionNumber));
        intent.putExtra(MainFragment.EXTRA_TOPIC_ID, topicId);

        context.startActivity(intent);

    }
}
