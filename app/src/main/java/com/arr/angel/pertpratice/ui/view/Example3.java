package com.arr.angel.pertpratice.ui.view;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.AdvanceExample03Binding;
import com.arr.angel.pertpratice.databinding.ApplicationExample03Binding;
import com.arr.angel.pertpratice.databinding.BasicExample03Binding;
import com.arr.angel.pertpratice.databinding.Example03Binding;
import com.arr.angel.pertpratice.databinding.IntermediateExample03Binding;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;

public class Example3 extends AppCompatActivity {

    private static String TAG = Example3.class.getSimpleName();

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

        Example03Binding example03Binding =
                DataBindingUtil.setContentView(this, R.layout.example03);


        //populate the text views
        example03Binding.textView1.setText(R.string.t1_example_question03_txt1);

        example03Binding.textView2.setText(R.string.t1_example_question03_txt2);

        example03Binding.textView3.setText(R.string.t1_example_question03_txt3);

        example03Binding.textView4.setText(R.string.t1_example_question03_txt4);

    }

    private void basicExample() {
        BasicExample03Binding basicExample03Binding =
                DataBindingUtil.setContentView(this, R.layout.basic_example03);

        //populate the text views
        basicExample03Binding.textView1.setText(R.string.t2_example_question03_txt1);

        basicExample03Binding.textView2.setText(R.string.t2_example_question03_txt2);

        basicExample03Binding.textView3.setText(R.string.t2_example_question03_txt3);

        basicExample03Binding.textView4.setText(R.string.t2_example_question03_txt4);

        basicExample03Binding.textView5.setText(R.string.t2_example_question03_txt5);

        basicExample03Binding.textView6.setText(R.string.t2_example_question03_txt6);

        basicExample03Binding.textView7.setText(R.string.t2_example_question03_txt7);

        basicExample03Binding.textView8.setText(R.string.t2_example_question03_txt8);

    }

    private void intermediateExample() {
        IntermediateExample03Binding intermediateExample03Binding =
                DataBindingUtil.setContentView(this, R.layout.intermediate_example03);

        //populate the text views
        intermediateExample03Binding.textView1.setText(R.string.t3_example_question03_txt1);

        intermediateExample03Binding.textView2.setText(R.string.t3_example_question03_txt2);

        intermediateExample03Binding.textView3.setText(R.string.t3_example_question03_txt3);

        intermediateExample03Binding.textView4.setText(R.string.t3_example_question03_txt4);

        intermediateExample03Binding.textView5.setText(R.string.t3_example_question03_txt5);

        intermediateExample03Binding.textView6.setText(R.string.t3_example_question03_txt6);

        intermediateExample03Binding.textView7.setText(R.string.t3_example_question03_txt7);

        intermediateExample03Binding.textView8.setText(R.string.t3_example_question03_txt8);

        intermediateExample03Binding.textView9.setText(R.string.t3_example_question03_txt9);

        intermediateExample03Binding.textView10.setText(R.string.t3_example_question03_txt10);

        intermediateExample03Binding.textView11.setText(R.string.t3_example_question03_txt11);

    }

    private void advanceExample() {

        AdvanceExample03Binding advanceExample03Binding =
                DataBindingUtil.setContentView(this, R.layout.advance_example03);

        //populate the text views
        advanceExample03Binding.textView1.setText(R.string.t4_example_question03_txt1);

        advanceExample03Binding.textView2.setText(R.string.t4_example_question03_txt2);

        advanceExample03Binding.textView3.setText(R.string.t4_example_question03_txt3);

        advanceExample03Binding.textView4.setText(R.string.t4_example_question03_txt4);

        advanceExample03Binding.textView5.setText(R.string.t4_example_question03_txt5);

        advanceExample03Binding.textView6.setText(R.string.t4_example_question03_txt6);

        advanceExample03Binding.textView7.setText(R.string.t4_example_question03_txt7);

        advanceExample03Binding.textView8.setText(R.string.t4_example_question03_txt8);

        advanceExample03Binding.textView9.setText(R.string.t4_example_question03_txt9);

        advanceExample03Binding.textView10.setText(R.string.t4_example_question03_txt10);

        advanceExample03Binding.textView11.setText(R.string.t4_example_question03_txt11);

        advanceExample03Binding.textView12.setText(R.string.t4_example_question03_txt12);

        advanceExample03Binding.textView13.setText(R.string.t4_example_question03_txt13);

        advanceExample03Binding.textView14.setText(R.string.t4_example_question03_txt14);

        advanceExample03Binding.textView15.setText(R.string.t4_example_question03_txt15);

        advanceExample03Binding.textView16.setText(R.string.t4_example_question03_txt16);

        advanceExample03Binding.textView17.setText(R.string.t4_example_question03_txt17);

        advanceExample03Binding.textView18.setText(R.string.t4_example_question03_txt18);

        advanceExample03Binding.textView19.setText(R.string.t4_example_question03_txt19);

        advanceExample03Binding.textView20.setText(R.string.t4_example_question03_txt20);

        advanceExample03Binding.textView21.setText(R.string.t4_example_question03_txt21);

        advanceExample03Binding.textView22.setText(R.string.t4_example_question03_txt22);

        advanceExample03Binding.textView23.setText(R.string.t4_example_question03_txt23);

        advanceExample03Binding.textView24.setText(R.string.t4_example_question03_txt24);

        advanceExample03Binding.textView25.setText(R.string.t4_example_question03_txt25);

        advanceExample03Binding.textView26.setText(R.string.t4_example_question03_txt26);

        advanceExample03Binding.textView27.setText(R.string.t4_example_question03_txt27);

        advanceExample03Binding.textView28.setText(R.string.t4_example_question03_txt28);

        advanceExample03Binding.textView29.setText(R.string.t4_example_question03_txt29);


    }

    private void applicationTestExample() {
        ApplicationExample03Binding applicationExample03Binding =
                DataBindingUtil.setContentView(this, R.layout.application_example03);

        //populate the text views
        applicationExample03Binding.textView1.setText(R.string.t5_example_question03_txt1);

        applicationExample03Binding.textView2.setText(R.string.t5_example_question03_txt2);

        applicationExample03Binding.textView3.setText(R.string.t5_example_question03_txt3);

        applicationExample03Binding.textView4.setText(R.string.t5_example_question03_txt4);

        applicationExample03Binding.textView5.setText(R.string.t5_example_question03_txt5);

        applicationExample03Binding.textView6.setText(R.string.t5_example_question03_txt6);

        applicationExample03Binding.textView7.setText(R.string.t5_example_question03_txt7);

        applicationExample03Binding.textView8.setText(R.string.t5_example_question03_txt8);

        applicationExample03Binding.textView9.setText(R.string.t5_example_question03_txt9);

        applicationExample03Binding.textView10.setText(R.string.t5_example_question03_txt10);

        applicationExample03Binding.textView11.setText(R.string.t5_example_question03_txt11);

    }

}
