package com.arr.angel.pertpratice.ui.view;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.Example06Binding;
import com.arr.angel.pertpratice.databinding.BasicExample06Binding;
import com.arr.angel.pertpratice.databinding.IntermediateExample06Binding;
import com.arr.angel.pertpratice.databinding.AdvanceExample06Binding;
import com.arr.angel.pertpratice.databinding.ApplicationExample06Binding;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;


public class Example6 extends AppCompatActivity {

    private static String TAG = Example6.class.getSimpleName();
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

    private void practiceTestExample() {
        Example06Binding example06Binding =
                DataBindingUtil.setContentView(this, R.layout.example06);

        example06Binding.textView1.setText(R.string.t1_example_question06_txt1);

        example06Binding.textView2.setText(R.string.t1_example_question06_txt2);

        example06Binding.textView3.setText(R.string.t1_example_question06_txt3);

        example06Binding.textView4.setText(R.string.t1_example_question06_txt4);

        example06Binding.textView5.setText(R.string.t1_example_question06_txt5);

        example06Binding.textView6.setText(R.string.t1_example_question06_txt6);

        example06Binding.textView7.setText(R.string.t1_example_question06_txt7);

        example06Binding.textView8.setText(R.string.t1_example_question06_txt8);

        example06Binding.textView9.setText(R.string.t1_example_question06_txt9);
    }

    private void basicExample() {
        BasicExample06Binding basicExample06Binding =
                DataBindingUtil.setContentView(this, R.layout.basic_example06);

        basicExample06Binding.textView1.setText(R.string.t2_example_question06_txt1);

        basicExample06Binding.textView2.setText(R.string.t2_example_question06_txt2);

        basicExample06Binding.textView3.setText(R.string.t2_example_question06_txt3);

        basicExample06Binding.textView4.setText(R.string.t2_example_question06_txt4);

        basicExample06Binding.textView5.setText(R.string.t2_example_question06_txt5);

        basicExample06Binding.textView6.setText(R.string.t2_example_question06_txt6);

        basicExample06Binding.textView7.setText(R.string.t2_example_question06_txt7);

        basicExample06Binding.textView8.setText(R.string.t2_example_question06_txt8);

        basicExample06Binding.textView9.setText(R.string.t2_example_question06_txt9);

        basicExample06Binding.textView10.setText(R.string.t2_example_question06_txt10);

    }

    private void intermediateExample() {
        IntermediateExample06Binding intermediateExample06Binding =
                DataBindingUtil.setContentView(this, R.layout.intermediate_example06);

        intermediateExample06Binding.textView1.setText(R.string.t3_example_question06_txt1);

        intermediateExample06Binding.textView2.setText(R.string.t3_example_question06_txt2);

        intermediateExample06Binding.textView3.setText(R.string.t3_example_question06_txt3);

        intermediateExample06Binding.textView4.setText(R.string.t3_example_question06_txt4);

        intermediateExample06Binding.textView5.setText(R.string.t3_example_question06_txt5);

        intermediateExample06Binding.textView6.setText(R.string.t3_example_question06_txt6);

        intermediateExample06Binding.textView7.setText(R.string.t3_example_question06_txt7);

    }

    private void advanceExample() {

        AdvanceExample06Binding advanceExample06Binding =
                DataBindingUtil.setContentView(this, R.layout.advance_example06);

        advanceExample06Binding.textView1.setText(R.string.t4_example_question06_txt1);

        advanceExample06Binding.textView2.setText(R.string.t4_example_question06_txt2);

        advanceExample06Binding.textView3.setText(R.string.t4_example_question06_txt3);

        advanceExample06Binding.textView4.setText(R.string.t4_example_question06_txt4);

        advanceExample06Binding.textView5.setText(R.string.t4_example_question06_txt5);

        advanceExample06Binding.textView6.setText(R.string.t4_example_question06_txt6);

        advanceExample06Binding.textView7.setText(R.string.t4_example_question06_txt7);

        advanceExample06Binding.textView8.setText(R.string.t4_example_question06_txt8);

        advanceExample06Binding.textView9.setText(R.string.t4_example_question06_txt9);
    }

    private void applicationTestExample() {
        ApplicationExample06Binding applicationExample06Binding =
                DataBindingUtil.setContentView(this, R.layout.application_example06);

        applicationExample06Binding.textView1.setText(R.string.t5_example_question06_txt1);

        applicationExample06Binding.textView2.setText(R.string.t5_example_question06_txt2);

        applicationExample06Binding.textView3.setText(R.string.t5_example_question06_txt3);

        applicationExample06Binding.textView4.setText(R.string.t5_example_question06_txt4);

        applicationExample06Binding.textView5.setText(R.string.t5_example_question06_txt5);

        applicationExample06Binding.textView6.setText(R.string.t5_example_question06_txt6);
    }
}
