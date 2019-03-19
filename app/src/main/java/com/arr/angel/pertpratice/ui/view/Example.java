package com.arr.angel.pertpratice.ui.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.AdvanceExample01Binding;
import com.arr.angel.pertpratice.databinding.ApplicationExample01Binding;
import com.arr.angel.pertpratice.databinding.BasicExample01Binding;
import com.arr.angel.pertpratice.databinding.Example01Binding;
import com.arr.angel.pertpratice.databinding.IntermediateExample01Binding;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;


public class Example extends AppCompatActivity {

    private static String TAG = Example.class.getSimpleName();

    //placeholder for current question int
    //and topicId
    private int currentQuestion;
    private int topicId;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_TOPIC_ID, topicId);
        outState.putInt(EXTRA_CURRENT_QUESTION_ID, currentQuestion);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent() != null) {
            currentQuestion = getIntent().getIntExtra(EXTRA_CURRENT_QUESTION_ID, 0);
            topicId = getIntent().getIntExtra(EXTRA_TOPIC_ID, 0);
        }

        if (savedInstanceState != null) {
            topicId = savedInstanceState.getInt(EXTRA_TOPIC_ID);
            currentQuestion = savedInstanceState.getInt(EXTRA_CURRENT_QUESTION_ID);
        }


        switch (topicId) {
            case 0:
                Log.d(TAG, "I'm in topic " + topicId);
                practiceTestExample();
                break;
            case 1:
                Log.d(TAG, "I'm in topic " + topicId);
                basicExample();
                break;
            case 2:
                Log.d(TAG, "I'm in topic " + topicId);
                intermediateExample();
                break;
            case 3:
                Log.d(TAG, "I'm in topic " + topicId);
                advanceExample();
                break;
            case 4:
                Log.d(TAG, "I'm in topic " + topicId);
                applicationTestExample();
                break;
            default:
                setContentView(R.layout.no_example_available);
                break;
        }


    }

    /*Decided to just keep example to just 6 activities that inflate the
     * different xml's for each topic once I move the data into the cloud
     * FireBase I'll probably add each example data into it's corresponding
     * Question object. */

    //TODO: move question example strings into question object inside FireBase

    private void practiceTestExample() {

        Example01Binding example01Binding =
                DataBindingUtil.setContentView(this, R.layout.example01);


        //populate the text views
        example01Binding.textView1.setText(R.string.t1_example_question01_txt1);

        example01Binding.textView2.setText(R.string.t1_example_question01_txt2);

        example01Binding.textView3.setText(R.string.t1_example_question01_txt3);

        example01Binding.textView4.setText(R.string.t1_example_question01_txt4);

        example01Binding.textView5.setText(R.string.t1_example_question01_txt5);

        example01Binding.textView6.setText(R.string.t1_example_question01_txt6);

        example01Binding.textView7.setText(R.string.t1_example_question01_txt5);

        example01Binding.textView8.setText(R.string.t1_example_question01_txt8);

        example01Binding.textView9.setText(R.string.t1_example_question01_txt9);

        example01Binding.textView10.setText(R.string.t1_example_question01_txt10);

        example01Binding.textView11.setText(R.string.t1_example_question01_txt11);

    }

    private void basicExample() {

        BasicExample01Binding basicExample01Binding =
                DataBindingUtil.setContentView(this, R.layout.basic_example01);


        //populate the text views
        basicExample01Binding.textView1.setText(R.string.t2_example_question01_txt1);

        basicExample01Binding.textView2.setText(R.string.t2_example_question01_txt2);

        basicExample01Binding.textView3.setText(R.string.t2_example_question01_txt3);

        basicExample01Binding.textView4.setText(R.string.t2_example_question01_txt4);

        basicExample01Binding.textView5.setText(R.string.t2_example_question01_txt5);

        basicExample01Binding.textView6.setText(R.string.t2_example_question01_txt6);

    }

    private void intermediateExample(){

        IntermediateExample01Binding intermediateExample01Binding =
                DataBindingUtil.setContentView(this, R.layout.intermediate_example01);


        //populate the text views
        intermediateExample01Binding.textView1.setText(R.string.t3_example_question01_txt1);

        intermediateExample01Binding.textView2.setText(R.string.t3_example_question01_txt2);

        intermediateExample01Binding.textView3.setText(R.string.t3_example_question01_txt3);

        intermediateExample01Binding.textView4.setText(R.string.t3_example_question01_txt4);

        intermediateExample01Binding.textView5.setText(R.string.t3_example_question01_txt5);

        intermediateExample01Binding.textView6.setText(R.string.t3_example_question01_txt6);

        intermediateExample01Binding.textView7.setText(R.string.t3_example_question01_txt5);

        intermediateExample01Binding.textView8.setText(R.string.t3_example_question01_txt8);

    }

    private void advanceExample(){

        AdvanceExample01Binding advanceExample01Binding =
                DataBindingUtil.setContentView(this, R.layout.advance_example01);


        //populate the text views
        advanceExample01Binding.textView1.setText(R.string.t4_example_question01_txt1);

        advanceExample01Binding.textView2.setText(R.string.t4_example_question01_txt2);

        advanceExample01Binding.textView3.setText(R.string.t4_example_question01_txt3);

        advanceExample01Binding.textView4.setText(R.string.t4_example_question01_txt4);

        advanceExample01Binding.textView5.setText(R.string.t4_example_question01_txt5);

        advanceExample01Binding.textView6.setText(R.string.t4_example_question01_txt6);

        advanceExample01Binding.textView7.setText(R.string.t4_example_question01_txt5);

        advanceExample01Binding.textView8.setText(R.string.t4_example_question01_txt8);

        advanceExample01Binding.textView9.setText(R.string.t4_example_question01_txt9);

        advanceExample01Binding.textView10.setText(R.string.t4_example_question01_txt10);

        advanceExample01Binding.textView11.setText(R.string.t4_example_question01_txt11);

        advanceExample01Binding.textView12.setText(R.string.t4_example_question01_txt12);

        advanceExample01Binding.textView13.setText(R.string.t4_example_question01_txt13);

        advanceExample01Binding.textView14.setText(R.string.t4_example_question01_txt14);

        advanceExample01Binding.textView15.setText(R.string.t4_example_question01_txt15);

        advanceExample01Binding.textView16.setText(R.string.t4_example_question01_txt16);

        advanceExample01Binding.textView17.setText(R.string.t4_example_question01_txt17);

        advanceExample01Binding.textView18.setText(R.string.t4_example_question01_txt18);

    }

    private void applicationTestExample() {

        ApplicationExample01Binding applicationExample01Binding =
                DataBindingUtil.setContentView(this, R.layout.application_example01);


        //populate the text views
        applicationExample01Binding.textView1.setText(R.string.t5_example_question01_txt1);

        applicationExample01Binding.textView2.setText(R.string.t5_example_question01_txt2);

        applicationExample01Binding.textView3.setText(R.string.t5_example_question01_txt3);

        applicationExample01Binding.textView4.setText(R.string.t5_example_question01_txt4);

        applicationExample01Binding.textView5.setText(R.string.t5_example_question01_txt5);

        applicationExample01Binding.textView6.setText(R.string.t5_example_question01_txt6);

        applicationExample01Binding.textView7.setText(R.string.t5_example_question01_txt5);

        applicationExample01Binding.textView8.setText(R.string.t5_example_question01_txt8);

        applicationExample01Binding.textView9.setText(R.string.t5_example_question01_txt9);

        applicationExample01Binding.textView10.setText(R.string.t5_example_question01_txt10);

        applicationExample01Binding.textView11.setText(R.string.t5_example_question01_txt11);

    }


}
