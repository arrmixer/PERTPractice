package com.arr.angel.pertpratice.util;

import androidx.fragment.app.FragmentManager;

import com.arr.angel.pertpratice.ui.view.AlreadyAnsweredDialogFragment;
import com.arr.angel.pertpratice.ui.view.CorrectAnswerDialogFragment;
import com.arr.angel.pertpratice.ui.view.InCorrectAnswerDialogFragment;
import com.arr.angel.pertpratice.ui.view.Question01Activity;
import com.arr.angel.pertpratice.ui.view.Question02Activity;
import com.arr.angel.pertpratice.ui.view.Question03Activity;
import com.arr.angel.pertpratice.ui.view.Question04Activity;
import com.arr.angel.pertpratice.ui.view.Question05Activity;
import com.arr.angel.pertpratice.ui.view.Question06Activity;
import com.arr.angel.pertpratice.ui.view.TopicResultsActivity;

//utility class used to create the Dialogs within the RadioGroupHelper class
public class DialogCreations {

    //use as key to put string args for next question
    public static final String nextQuestionNumberArg = "com.arr.angel.pertpratice.ui.view.next_question";

    //use as key to put total number of questions
    public static final String currentQuestionNumberArg =  "com.arr.angel.pertpratice.ui.view.current_question_id";

    //use as key to check if already answered question was correct or incorrect
    public static final String currentQuestionIsCorrectArg =  "com.arr.angel.pertpratice.ui.view.current_question_is_correct";

    //helper method to create Correct Dialog Fragment with necessary parameters/arguments and show correct dialog
    public static void showCorrectDialog(FragmentManager fragmentManager, int currentQuestion,  int nextQuestion, int topicId){
        CorrectAnswerDialogFragment correctAnswerDialogFragment = CorrectAnswerDialogFragment.newInstance(currentQuestion, nextQuestion, topicId);
        correctAnswerDialogFragment.setCancelable(false);
        correctAnswerDialogFragment.show(fragmentManager, "correct");
    }

    public static void showIncorrectDialog(FragmentManager fragmentManager, int currentQuestion, int nextQuestion, int topicId){
        InCorrectAnswerDialogFragment inCorrectAnswerDialogFragment = InCorrectAnswerDialogFragment.newInstance(currentQuestion, nextQuestion, topicId);
        inCorrectAnswerDialogFragment.setCancelable(false);
        inCorrectAnswerDialogFragment.show(fragmentManager, "incorrect");
    }

    public static void showAlreadyAnsweredDialog(FragmentManager fragmentManager, int currentQuestion, int nextQuestion, int topicId, boolean isCorrect){
        AlreadyAnsweredDialogFragment alreadyAnsweredDialogFragment = AlreadyAnsweredDialogFragment.newInstance(currentQuestion, nextQuestion, topicId, isCorrect);
        alreadyAnsweredDialogFragment.setCancelable(false);

        if(!alreadyAnsweredDialogFragment.isVisible()) {
            alreadyAnsweredDialogFragment.show(fragmentManager, "already_answered");
        }
    }

    //helper method to launch correct question activity
    public static Class check(int question){

        switch(question){
            case 1:
                return Question01Activity.class;
            case 2:
                return Question02Activity.class;
            case 3:
                return Question03Activity.class;
            case 4:
                return Question04Activity.class;
            case 5:
                return Question05Activity.class;
            case 6:
                return Question06Activity.class;
        }
        return TopicResultsActivity.class;

    }
}
