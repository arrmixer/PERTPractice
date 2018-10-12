package com.arr.angel.pertpratice.util;

import android.support.v4.app.FragmentManager;
import android.widget.RadioGroup;

import com.arr.angel.pertpratice.ui.view.CorrectAnswerDialogFragment;
import com.arr.angel.pertpratice.ui.view.InCorrectAnswerDialogFragment;
import com.arr.angel.pertpratice.ui.view.MainActivity;
import com.arr.angel.pertpratice.ui.view.Question02Activity;
import com.arr.angel.pertpratice.ui.view.Question03Activity;
import com.arr.angel.pertpratice.ui.view.Question04Activity;
import com.arr.angel.pertpratice.ui.view.Question05Activity;
import com.arr.angel.pertpratice.ui.view.Question06Activity;
import com.arr.angel.pertpratice.ui.view.TopicResultsActivity;

//utility class used to create the Dialogs within the RadioGroupHelper class
public class DialogCreations {

    //use as key to put string args for next question
    public static final String questionNumberArg = "com.arr.angel.pertpratice.ui.view.correct_answer_next";

    //use as key to put total number of questions
    public static final String questionTotalArg =  "com.arr.angel.pertpratice.ui.view.total_questions";

    //helper method to create Correct Dialog Fragment with necessary parameters/arguments and show correct dialog
    public static void showCorrectDialog(RadioGroup radioGroup, FragmentManager fragmentManager, int nextQuestion, int topicId){
        CorrectAnswerDialogFragment correctAnswerDialogFragment = CorrectAnswerDialogFragment.newInstance(nextQuestion, topicId);
        radioGroup.clearCheck();
        correctAnswerDialogFragment.setCancelable(false);
        correctAnswerDialogFragment.show(fragmentManager, "Correct");
    }

    public static void showIncorrectDialog(RadioGroup radioGroup, FragmentManager fragmentManager, int nextQuestion, int topicId){
        InCorrectAnswerDialogFragment inCorrectAnswerDialogFragment = InCorrectAnswerDialogFragment.newInstance(nextQuestion, topicId);
        radioGroup.clearCheck();
        inCorrectAnswerDialogFragment.setCancelable(false);
        inCorrectAnswerDialogFragment.show(fragmentManager, "incorrect");
    }



    //helper method to launch correct question activity based on next question int argument
    public static Class check(int nextQuestion){

        switch(nextQuestion){
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
