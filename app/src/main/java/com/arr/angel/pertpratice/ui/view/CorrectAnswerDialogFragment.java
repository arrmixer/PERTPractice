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

    private static String TAG = CorrectAnswerDialogFragment.class.getSimpleName();

    //placeholder for int to the next question
    private int nextQuestion;

    //adding the int of the next question to figure out the next activity to launch
    public static CorrectAnswerDialogFragment newInstance(int nextQuestion){

        CorrectAnswerDialogFragment correctAnswerDialogFragment = new CorrectAnswerDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(DialogCreations.questionNumberArg, nextQuestion);
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
        }else{
            Log.d(TAG, "No int argument for next question");
            nextQuestion = 0;
        }


        builder.setMessage(R.string.dialog_correct)
                .setPositiveButton(R.string.dialog_next, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Next!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), DialogCreations.check(nextQuestion));
                        startActivity(intent);
                    }
                });

        return  builder.create();
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
