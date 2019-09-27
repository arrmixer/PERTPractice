package com.arr.angel.pertpratice.ui.view;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.AdvanceExample04Binding;
import com.arr.angel.pertpratice.databinding.ApplicationExample04Binding;
import com.arr.angel.pertpratice.databinding.BasicExample04Binding;
import com.arr.angel.pertpratice.databinding.Example04Binding;
import com.arr.angel.pertpratice.databinding.IntermediateExample04Binding;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;


public class Example4 extends AppCompatActivity {

    private static String TAG = Example4.class.getSimpleName();

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

    private void practiceTestExample() {

        Example04Binding example04Binding =
                DataBindingUtil.setContentView(this, R.layout.example04);


        //populate the text views
        example04Binding.textView1.setText(R.string.t1_example_question04_txt1);

        example04Binding.textView2.setText(R.string.t1_example_question04_txt2);

        example04Binding.textView3.setText(R.string.t1_example_question04_txt3);

        example04Binding.textView4.setText(R.string.t1_example_question04_txt4);

        example04Binding.textView5.setText(R.string.t1_example_question04_txt5);

        example04Binding.textView6.setText(R.string.t1_example_question04_txt6);

        example04Binding.textView7.setText(R.string.t1_example_question04_txt7);

        example04Binding.textView8.setText(R.string.t1_example_question04_txt8);

        example04Binding.textView9.setText(R.string.t1_example_question04_txt9);

        example04Binding.textView10.setText(R.string.t1_example_question04_txt10);

        example04Binding.textView11.setText(R.string.t1_example_question04_txt11);

        example04Binding.textView12.setText(R.string.t1_example_question04_txt12);

        example04Binding.textView13.setText(R.string.t1_example_question04_txt13);


    }

    private void basicExample() {
        BasicExample04Binding basicExample04Binding =
                DataBindingUtil.setContentView(this, R.layout.basic_example04);

        //populate the text views
        basicExample04Binding.textView1.setText(R.string.t2_example_question04_txt1);

        basicExample04Binding.textView2.setText(R.string.t2_example_question04_txt2);

        basicExample04Binding.textView3.setText(R.string.t2_example_question04_txt3);

        basicExample04Binding.textView4.setText(R.string.t2_example_question04_txt4);

        basicExample04Binding.textView5.setText(R.string.t2_example_question04_txt5);

        basicExample04Binding.textView6.setText(R.string.t2_example_question04_txt6);

    }

    private void intermediateExample() {
        IntermediateExample04Binding intermediateExample04Binding =
                DataBindingUtil.setContentView(this, R.layout.intermediate_example04);

        //populate the text views
        intermediateExample04Binding.textView1.setText(R.string.t3_example_question04_txt1);

        intermediateExample04Binding.textView2.setText(R.string.t3_example_question04_txt2);

        intermediateExample04Binding.textView3.setText(R.string.t3_example_question04_txt3);

        intermediateExample04Binding.textView4.setText(R.string.t3_example_question04_txt4);

        intermediateExample04Binding.textView5.setText(R.string.t3_example_question04_txt5);

        intermediateExample04Binding.textView6.setText(R.string.t3_example_question04_txt6);

        intermediateExample04Binding.textView7.setText(R.string.t3_example_question04_txt7);

    }

    private void advanceExample() {

        AdvanceExample04Binding advanceExample04Binding =
                DataBindingUtil.setContentView(this, R.layout.advance_example04);

        //populate the text views
        advanceExample04Binding.textView1.setText(R.string.t4_example_question04_txt1);

        advanceExample04Binding.textView2.setText(R.string.t4_example_question04_txt2);

        advanceExample04Binding.textView3.setText(R.string.t4_example_question04_txt3);

        advanceExample04Binding.textView4.setText(R.string.t4_example_question04_txt4);

        advanceExample04Binding.textView5.setText(R.string.t4_example_question04_txt5);

        advanceExample04Binding.textView6.setText(R.string.t4_example_question04_txt6);

        advanceExample04Binding.textView7.setText(R.string.t4_example_question04_txt7);

        advanceExample04Binding.textView8.setText(R.string.t4_example_question04_txt8);

        advanceExample04Binding.textView9.setText(R.string.t4_example_question04_txt9);

        advanceExample04Binding.textView10.setText(R.string.t4_example_question04_txt10);

        advanceExample04Binding.textView11.setText(R.string.t4_example_question04_txt11);

        advanceExample04Binding.textView12.setText(R.string.t4_example_question04_txt12);

    }

    private void applicationTestExample() {
        ApplicationExample04Binding applicationExample04Binding =
                DataBindingUtil.setContentView(this, R.layout.application_example04);

        //populate the text views
        applicationExample04Binding.textView1.setText(R.string.t5_example_question04_txt1);

        applicationExample04Binding.textView2.setText(R.string.t5_example_question04_txt2);

        applicationExample04Binding.textView3.setText(R.string.t5_example_question04_txt3);

        applicationExample04Binding.textView4.setText(R.string.t5_example_question04_txt4);

        applicationExample04Binding.textView5.setText(R.string.t5_example_question04_txt5);

        applicationExample04Binding.textView6.setText(R.string.t5_example_question04_txt6);

        applicationExample04Binding.textView7.setText(R.string.t5_example_question04_txt7);

        applicationExample04Binding.textView8.setText(R.string.t5_example_question04_txt8);

        applicationExample04Binding.textView9.setText(R.string.t5_example_question04_txt9);

        applicationExample04Binding.textView10.setText(R.string.t5_example_question04_txt10);

    }
}
