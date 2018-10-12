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

import static com.arr.angel.pertpratice.ui.view.CorrectAnswerDialogFragment.EXTRA_IS_ANSWERED;
import static com.arr.angel.pertpratice.ui.view.CorrectAnswerDialogFragment.EXTRA_IS_CORRECT;

public class InCorrectAnswerDialogFragment extends DialogFragment {

    private static String TAG = InCorrectAnswerDialogFragment.class.getSimpleName();

    //placeholder for int to the next question
    //and topic id
    private int nextQuestion;
    private int topicId;

    public static InCorrectAnswerDialogFragment newInstance(int nextQuestion, int topicId) {

        InCorrectAnswerDialogFragment inCorrectAnswerDialogFragment = new InCorrectAnswerDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(DialogCreations.questionNumberArg, nextQuestion);
        bundle.putInt(Question01Fragment.ARGS_TOPIC_ID, topicId);
        inCorrectAnswerDialogFragment.setArguments(bundle);

        return inCorrectAnswerDialogFragment;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //make sure bundle has int value
        if (getArguments() != null) {
            nextQuestion = getArguments().getInt(DialogCreations.questionNumberArg);
            topicId = getArguments().getInt(Question01Fragment.ARGS_TOPIC_ID);
        }else{
            Log.d(TAG, "No int argument for next question");
            nextQuestion = 0;
        }

        builder.setMessage(R.string.dialog_incorrect)
                .setPositiveButton(R.string.dialog_next, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Next!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), DialogCreations.check(nextQuestion));
                        intent.putExtra(EXTRA_IS_CORRECT, false);
                        intent.putExtra(EXTRA_IS_ANSWERED, true);
                        intent.putExtra(MainFragment.EXTRA_TOPIC_ID, topicId);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.dialog_retry, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Retry!", Toast.LENGTH_SHORT).show();

                    }
                });

        return builder.create();
    }
}
