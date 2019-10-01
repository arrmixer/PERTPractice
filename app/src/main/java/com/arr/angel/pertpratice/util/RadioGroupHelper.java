package com.arr.angel.pertpratice.util;

import androidx.fragment.app.FragmentManager;
import android.widget.RadioGroup;

import com.arr.angel.pertpratice.R;

import java.util.List;

//util class for the radio groups in each question
public class RadioGroupHelper {

    public static void radioButtonLogic(RadioGroup radioGroup, FragmentManager fragmentManager,
                                        int checkId,
                                        String answer, List<String> possibleAnswers, int currentQuestion, int nextQuestion, int topicId) {
        switch (checkId) {
            case R.id.radioButton:
                if (answer.contentEquals(possibleAnswers.get(0))) {

//                    Toast.makeText(context, "correct!", Toast.LENGTH_SHORT).show();
                    radioGroup.clearCheck();
                    DialogCreations.showCorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId);


                } else {
                    radioGroup.clearCheck();
//                    Toast.makeText(context, "incorrect!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showIncorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId);


                }
                break;
            case R.id.radioButton2:
                if (answer.contentEquals(possibleAnswers.get(1))) {
                    radioGroup.clearCheck();
//                    Toast.makeText(context, "correct!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showCorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId);

                } else {
                    radioGroup.clearCheck();
//                    Toast.makeText(context, "incorrect!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showIncorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId);
                }
                break;
            case R.id.radioButton3:
                if (answer.contentEquals(possibleAnswers.get(2))) {
                    radioGroup.clearCheck();
//                    Toast.makeText(context, "correct!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showCorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId);

                } else {
                    radioGroup.clearCheck();
//                    Toast.makeText(context, "incorrect!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showIncorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId);
                }
                break;
            case R.id.radioButton4:
                if (answer.contentEquals(possibleAnswers.get(3))) {
                    radioGroup.clearCheck();
//                    Toast.makeText(context, "correct!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showCorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId);

                } else {
                    radioGroup.clearCheck();
//                    Toast.makeText(context, "incorrect!", Toast.LENGTH_SHORT).show();
                    DialogCreations.showIncorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId);
                }
                break;

        }

    }
}
