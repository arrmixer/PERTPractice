package com.arr.angel.pertpratice.util;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.List;

//util class for the radio groups in each question
public class RadioGroupHelper {

    public static void radioButtonLogic(Context context, FragmentManager fragmentManager,
                                        RadioGroup radioGroup, int checkId,
                                        String answer, List<String> possibleAnswers, int nextQuestion, int topicId) {
        switch (checkId) {
            case R.id.radioButton:
                if (answer.contentEquals(possibleAnswers.get(0))) {
                    Toast.makeText(context, "correct!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showCorrectDialog(radioGroup, fragmentManager, nextQuestion, topicId);

                }else{
                    Toast.makeText(context, "incorrect!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showIncorrectDialog(radioGroup, fragmentManager, nextQuestion, topicId);

                }
                break;
            case R.id.radioButton2:
                if (answer.contentEquals(possibleAnswers.get(1))) {
                    Toast.makeText(context, "correct!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showCorrectDialog(radioGroup, fragmentManager, nextQuestion, topicId);
                }else{
                    Toast.makeText(context, "incorrect!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showIncorrectDialog(radioGroup, fragmentManager, nextQuestion, topicId);
                }
                break;
            case R.id.radioButton3:
                if (answer.contentEquals(possibleAnswers.get(2))) {
                    Toast.makeText(context, "correct!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showCorrectDialog(radioGroup, fragmentManager, nextQuestion, topicId);
                }else{
                    Toast.makeText(context, "incorrect!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showIncorrectDialog(radioGroup, fragmentManager, nextQuestion, topicId);
                }
                break;
            case R.id.radioButton4:
                if (answer.contentEquals(possibleAnswers.get(3))) {
                    Toast.makeText(context, "correct!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showCorrectDialog(radioGroup, fragmentManager, nextQuestion, topicId);
                }else{
                    Toast.makeText(context, "incorrect!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showIncorrectDialog(radioGroup, fragmentManager, nextQuestion, topicId);
                }
                break;

        }

    }
}
