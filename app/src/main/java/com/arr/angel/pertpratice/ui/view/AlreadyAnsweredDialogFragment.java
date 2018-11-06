package com.arr.angel.pertpratice.ui.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.Toast;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.util.DialogCreations;

import static com.arr.angel.pertpratice.ui.view.MainFragment.ARGS_TOPIC_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;


public class AlreadyAnsweredDialogFragment extends DialogFragment {

    private static String TAG = CorrectAnswerDialogFragment.class.getSimpleName();

    //placeholder for int to the next question
    //and topic id
    private int currentQuestion;
    private int nextQuestion;
    private int topicId;
    private boolean isCorrect;

    //adding the int of the next question to figure out the next activity to launch
    public static AlreadyAnsweredDialogFragment newInstance(int currentQuestion, int nextQuestion, int topicId, boolean isCorrect) {

        AlreadyAnsweredDialogFragment alreadyAnsweredDialogFragment = new AlreadyAnsweredDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(DialogCreations.currentQuestionNumberArg, currentQuestion);
        bundle.putInt(DialogCreations.nextQuestionNumberArg, nextQuestion);
        bundle.putInt(ARGS_TOPIC_ID, topicId);
        bundle.putBoolean(DialogCreations.currentQuestionIsCorrectArg, isCorrect);
        alreadyAnsweredDialogFragment.setArguments(bundle);

        return alreadyAnsweredDialogFragment;
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        //make sure bundle has int value
        if (getArguments() != null) {
            currentQuestion = getArguments().getInt(DialogCreations.currentQuestionNumberArg);
            nextQuestion = getArguments().getInt(DialogCreations.nextQuestionNumberArg);
            topicId = getArguments().getInt(ARGS_TOPIC_ID);
            isCorrect = getArguments().getBoolean(DialogCreations.currentQuestionIsCorrectArg);
        } else {
            Log.d(TAG, "No int argument for next question");
            nextQuestion = 0;
        }


        builder.setMessage(R.string.dialog_already_answer)
                .setPositiveButton(R.string.dialog_next, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(getContext(), R.string.next_toast, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), DialogCreations.check(nextQuestion));
                        intent.putExtra(EXTRA_CURRENT_QUESTION_ID, currentQuestion);
                        intent.putExtra(MainFragment.EXTRA_TOPIC_ID, topicId);
                        intent.putExtra(CorrectAnswerDialogFragment.EXTRA_IS_ANSWERED, true);
                        intent.putExtra(CorrectAnswerDialogFragment.EXTRA_IS_CORRECT, isCorrect);
                        startActivity(intent);
                    }
                });

        return builder.create();
    }
}
