package com.arr.angel.pertpratice.ui.view;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.AdvanceExample05Binding;
import com.arr.angel.pertpratice.databinding.Example05Binding;
import com.arr.angel.pertpratice.databinding.BasicExample05Binding;
import com.arr.angel.pertpratice.databinding.IntermediateExample05Binding;
import com.arr.angel.pertpratice.databinding.ApplicationExample05Binding;


import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;

public class Example5 extends AppCompatActivity {

    private static String TAG = Example5.class.getSimpleName();

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

        Example05Binding example05Binding =
                DataBindingUtil.setContentView(this, R.layout.example05);

        example05Binding.textView1.setText(R.string.t1_example_question05_txt1);

        example05Binding.textView2.setText(R.string.t1_example_question05_txt2);

        example05Binding.textView3.setText(R.string.t1_example_question05_txt3);

        example05Binding.textView4.setText(R.string.t1_example_question05_txt4);

        example05Binding.textView5.setText(R.string.t1_example_question05_txt5);

        example05Binding.textView6.setText(R.string.t1_example_question05_txt6);
    }

    private void basicExample() {
        BasicExample05Binding basicExample05Binding =
                DataBindingUtil.setContentView(this, R.layout.basic_example05);

        basicExample05Binding.textView1.setText(R.string.t2_example_question05_txt1);

        basicExample05Binding.textView2.setText(R.string.t2_example_question05_txt2);

        basicExample05Binding.textView3.setText(R.string.t2_example_question05_txt3);

        basicExample05Binding.textView4.setText(R.string.t2_example_question05_txt4);

        basicExample05Binding.textView5.setText(R.string.t2_example_question05_txt5);

        basicExample05Binding.textView6.setText(R.string.t2_example_question05_txt6);
    }

    private void intermediateExample() {
        IntermediateExample05Binding intermediateExample05Binding =
                DataBindingUtil.setContentView(this, R.layout.intermediate_example05);

        //populate the text views
        intermediateExample05Binding.textView1.setText(R.string.t3_example_question05_txt1);

        intermediateExample05Binding.textView2.setText(R.string.t3_example_question05_txt2);

        intermediateExample05Binding.textView3.setText(R.string.t3_example_question05_txt3);

        intermediateExample05Binding.textView4.setText(R.string.t3_example_question05_txt4);

        intermediateExample05Binding.textView5.setText(R.string.t3_example_question05_txt5);

        intermediateExample05Binding.textView6.setText(R.string.t3_example_question05_txt6);

        intermediateExample05Binding.textView7.setText(R.string.t3_example_question05_txt7);
    }

    private void advanceExample() {
        AdvanceExample05Binding advanceExample05Binding =
                DataBindingUtil.setContentView(this, R.layout.advance_example05);

        //populate the text views
        advanceExample05Binding.textView1.setText(R.string.t4_example_question05_txt1);

        advanceExample05Binding.textView2.setText(R.string.t4_example_question05_txt2);

        advanceExample05Binding.textView3.setText(R.string.t4_example_question05_txt3);

        advanceExample05Binding.textView4.setText(R.string.t4_example_question05_txt4);

        advanceExample05Binding.textView5.setText(R.string.t4_example_question05_txt5);

        advanceExample05Binding.textView6.setText(R.string.t4_example_question05_txt6);

        advanceExample05Binding.textView7.setText(R.string.t4_example_question05_txt7);

        advanceExample05Binding.textView8.setText(R.string.t4_example_question05_txt8);

        advanceExample05Binding.textView9.setText(R.string.t4_example_question05_txt9);

        advanceExample05Binding.textView10.setText(R.string.t4_example_question05_txt10);

        advanceExample05Binding.textView11.setText(R.string.t4_example_question05_txt11);
    }

    private void applicationTestExample() {
        ApplicationExample05Binding applicationExample05Binding =
                DataBindingUtil.setContentView(this, R.layout.application_example05);

        applicationExample05Binding.textView1.setText(R.string.t5_example_question05_txt1);

        applicationExample05Binding.textView2.setText(R.string.t5_example_question05_txt2);

        applicationExample05Binding.textView3.setText(R.string.t5_example_question05_txt3);

        applicationExample05Binding.textView4.setText(R.string.t5_example_question05_txt4);

        applicationExample05Binding.textView5.setText(R.string.t5_example_question05_txt5);

        applicationExample05Binding.textView6.setText(R.string.t5_example_question05_txt6);

        applicationExample05Binding.textView7.setText(R.string.t5_example_question05_txt7);
    }
}
