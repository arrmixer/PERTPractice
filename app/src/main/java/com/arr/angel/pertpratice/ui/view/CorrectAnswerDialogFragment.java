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

public class CorrectAnswerDialogFragment extends DialogFragment {

    public static final String EXTRA_IS_CORRECT = "com.arr.angel.pertpratice.ui.view.is.correct.extra";
    public static final String EXTRA_IS_ANSWERED = "com.arr.angel.pertpratice.ui.view.is.answered.extra";
    private static String TAG = CorrectAnswerDialogFragment.class.getSimpleName();

    //placeholder for int to the next question
    //and topic id
    private int nextQuestion;
    private int topicId;

    //adding the int of the next question to figure out the next activity to launch
    public static CorrectAnswerDialogFragment newInstance(int nextQuestion, int topicId) {

        CorrectAnswerDialogFragment correctAnswerDialogFragment = new CorrectAnswerDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(DialogCreations.questionNumberArg, nextQuestion);
        bundle.putInt(Question01Fragment.ARGS_TOPIC_ID, topicId);
        correctAnswerDialogFragment.setArguments(bundle);

        return correctAnswerDialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        //make sure bundle has int value
        if (getArguments() != null) {
            nextQuestion = getArguments().getInt(DialogCreations.questionNumberArg);
            topicId = getArguments().getInt(Question01Fragment.ARGS_TOPIC_ID);
        } else {
            Log.d(TAG, "No int argument for next question");
            nextQuestion = 0;
        }


        builder.setMessage(R.string.dialog_correct)
                .setPositiveButton(R.string.dialog_next, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(getContext(), "Next!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), DialogCreations.check(nextQuestion));
                        intent.putExtra(EXTRA_IS_CORRECT, true);
                        intent.putExtra(EXTRA_IS_ANSWERED, true);
                        intent.putExtra(MainFragment.EXTRA_TOPIC_ID, topicId);
                        startActivity(intent);
                    }
                });

        return builder.create();
    }

//    private Class check(){
////        Log.d(TAG, "next question number is " + getArguments().getInt("QuestionNumber"));
//        int nextQuestion = getArguments().getInt(DialogCreations.questionNumberArg);
//        switch(nextQuestion){
//            case 2:
//                return Question02Activity.class;
//            case 3:
//                return Question03Activity.class;
//            case 4:
//                return Question04Activity.class;
//            case 5:
//                return Question05Activity.class;
//        }
//        return MainActivity.class;
//    }
}
