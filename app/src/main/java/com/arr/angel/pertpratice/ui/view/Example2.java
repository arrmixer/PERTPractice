package com.arr.angel.pertpratice.ui.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.AdvanceExample02Binding;
import com.arr.angel.pertpratice.databinding.ApplicationExample02Binding;
import com.arr.angel.pertpratice.databinding.BasicExample02Binding;
import com.arr.angel.pertpratice.databinding.Example02Binding;
import com.arr.angel.pertpratice.databinding.IntermediateExample02Binding;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;

public class Example2 extends AppCompatActivity {

    private static String TAG = Example2.class.getSimpleName();


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
                applicationExample();
                break;
            default:
                setContentView(R.layout.no_example_available);
                break;
        }


    }

    private void practiceTestExample() {
        Example02Binding example02Binding =
                DataBindingUtil.setContentView(this, R.layout.example02);

        //populate the text views
        example02Binding.textView1.setText(R.string.t1_example_question02_txt1);

        example02Binding.textView2.setText(R.string.t1_example_question02_txt2);

        example02Binding.textView3.setText(R.string.t1_example_question02_txt3);

        example02Binding.textView4.setText(R.string.t1_example_question02_txt4);

        example02Binding.textView5.setText(R.string.t1_example_question02_txt5);

        example02Binding.textView6.setText(R.string.t1_example_question02_txt6);

        example02Binding.textView7.setText(R.string.t1_example_question02_txt7);

        example02Binding.textView8.setText(R.string.t1_example_question02_txt8);

        example02Binding.textView9.setText(R.string.t1_example_question02_txt9);

        example02Binding.textView10.setText(R.string.t1_example_question02_txt10);

        example02Binding.textView11.setText(R.string.t1_example_question02_txt11);

        example02Binding.textView12.setText(R.string.t1_example_question02_txt12);

        example02Binding.textView13.setText(R.string.t1_example_question02_txt13);

        example02Binding.textView14.setText(R.string.t1_example_question02_txt14);

        example02Binding.textView15.setText(R.string.t1_example_question02_txt15);

    }

    private void basicExample() {
        BasicExample02Binding basicExample02Binding =
                DataBindingUtil.setContentView(this, R.layout.basic_example02);

        //populate the text views
        basicExample02Binding.textView1.setText(R.string.t2_example_question02_txt1);

        basicExample02Binding.textView2.setText(R.string.t2_example_question02_txt2);

        basicExample02Binding.textView3.setText(R.string.t2_example_question02_txt3);

        basicExample02Binding.textView4.setText(R.string.t2_example_question02_txt4);

        basicExample02Binding.textView5.setText(R.string.t2_example_question02_txt5);

        basicExample02Binding.textView6.setText(R.string.t2_example_question02_txt6);

        basicExample02Binding.textView7.setText(R.string.t2_example_question02_txt7);

        basicExample02Binding.textView8.setText(R.string.t2_example_question02_txt8);

    }

    private void intermediateExample() {
        IntermediateExample02Binding intermediateExample02Binding =
                DataBindingUtil.setContentView(this, R.layout.intermediate_example02);

        //populate the text views
        intermediateExample02Binding.textView1.setText(R.string.t3_example_question02_txt1);

        intermediateExample02Binding.textView2.setText(R.string.t3_example_question02_txt2);

        intermediateExample02Binding.textView3.setText(R.string.t3_example_question02_txt3);

        intermediateExample02Binding.textView4.setText(R.string.t3_example_question02_txt4);

        intermediateExample02Binding.textView5.setText(R.string.t3_example_question02_txt5);

        intermediateExample02Binding.textView6.setText(R.string.t3_example_question02_txt6);

        intermediateExample02Binding.textView7.setText(R.string.t3_example_question02_txt7);

    }

    private void advanceExample() {

        AdvanceExample02Binding advanceExample02Binding =
                DataBindingUtil.setContentView(this, R.layout.advance_example02);

        //populate the text views
        advanceExample02Binding.textView1.setText(R.string.t4_example_question02_txt1);

        advanceExample02Binding.textView2.setText(R.string.t4_example_question02_txt2);

        advanceExample02Binding.textView3.setText(R.string.t4_example_question02_txt3);

        advanceExample02Binding.textView4.setText(R.string.t4_example_question02_txt4);

        advanceExample02Binding.textView5.setText(R.string.t4_example_question02_txt5);

        advanceExample02Binding.textView6.setText(R.string.t4_example_question02_txt6);

        advanceExample02Binding.textView7.setText(R.string.t4_example_question02_txt7);

        advanceExample02Binding.textView8.setText(R.string.t4_example_question02_txt8);

        advanceExample02Binding.textView9.setText(R.string.t4_example_question02_txt9);

        advanceExample02Binding.textView10.setText(R.string.t4_example_question02_txt10);

        advanceExample02Binding.textView11.setText(R.string.t4_example_question02_txt11);

        advanceExample02Binding.textView12.setText(R.string.t4_example_question02_txt12);

        advanceExample02Binding.textView13.setText(R.string.t4_example_question02_txt13);

        advanceExample02Binding.textView14.setText(R.string.t4_example_question02_txt14);

        advanceExample02Binding.textView15.setText(R.string.t4_example_question02_txt15);

        advanceExample02Binding.textView16.setText(R.string.t4_example_question02_txt16);

        advanceExample02Binding.textView17.setText(R.string.t4_example_question02_txt17);



    }

    private void applicationExample() {
        ApplicationExample02Binding applicationExample02Binding =
                DataBindingUtil.setContentView(this, R.layout.application_example02);

        //populate the text views
        applicationExample02Binding.textView1.setText(R.string.t5_example_question02_txt1);

        applicationExample02Binding.textView2.setText(R.string.t5_example_question02_txt2);

        applicationExample02Binding.textView3.setText(R.string.t5_example_question02_txt3);

        applicationExample02Binding.textView4.setText(R.string.t5_example_question02_txt4);

        applicationExample02Binding.textView5.setText(R.string.t5_example_question02_txt5);

        applicationExample02Binding.textView6.setText(R.string.t5_example_question02_txt6);

        applicationExample02Binding.textView7.setText(R.string.t5_example_question02_txt7);

        applicationExample02Binding.textView8.setText(R.string.t5_example_question02_txt8);

        applicationExample02Binding.textView9.setText(R.string.t5_example_question02_txt9);

        applicationExample02Binding.textView10.setText(R.string.t5_example_question02_txt10);

        applicationExample02Binding.textView11.setText(R.string.t5_example_question02_txt11);

    }
}
