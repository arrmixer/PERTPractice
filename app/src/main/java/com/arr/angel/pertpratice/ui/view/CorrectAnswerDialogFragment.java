package com.arr.angel.pertpratice.ui.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.util.Log;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.util.DialogCreations;

import static com.arr.angel.pertpratice.ui.view.MainFragment.ARGS_TOPIC_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;


public class CorrectAnswerDialogFragment extends DialogFragment {

    public static final String EXTRA_IS_CORRECT = "com.arr.angel.pertpratice.ui.view.is.correct.extra";
    public static final String EXTRA_IS_ANSWERED = "com.arr.angel.pertpratice.ui.view.is.answered.extra";
    private static String TAG = CorrectAnswerDialogFragment.class.getSimpleName();

    private int currentQuestion;
    private int nextQuestion;
    private int topicId;

    public static CorrectAnswerDialogFragment newInstance(int currentQuestion, int nextQuestion, int topicId) {
        CorrectAnswerDialogFragment correctAnswerDialogFragment = new CorrectAnswerDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(DialogCreations.currentQuestionNumberArg, currentQuestion);
        bundle.putInt(DialogCreations.nextQuestionNumberArg, nextQuestion);
        bundle.putInt(ARGS_TOPIC_ID, topicId);
        correctAnswerDialogFragment.setArguments(bundle);

        return correctAnswerDialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        if (getArguments() != null) {
            currentQuestion = getArguments().getInt(DialogCreations.currentQuestionNumberArg);
            nextQuestion = getArguments().getInt(DialogCreations.nextQuestionNumberArg);
            topicId = getArguments().getInt(ARGS_TOPIC_ID);
        } else {
            Log.d(TAG, "No int argument for next question");
            nextQuestion = 0;
        }

        builder.setMessage(R.string.dialog_correct)
                .setPositiveButton(R.string.dialog_next, (dialogInterface, i) -> {
                    Intent intent = new Intent(getActivity(), DialogCreations.check(nextQuestion));
                    intent.putExtra(EXTRA_IS_CORRECT, true);
                    intent.putExtra(EXTRA_IS_ANSWERED, true);
                    intent.putExtra(EXTRA_CURRENT_QUESTION_ID, currentQuestion);
                    intent.putExtra(MainFragment.EXTRA_TOPIC_ID, topicId);
                    startActivity(intent);
                });

        return builder.create();
    }
}
