package com.arr.angel.pertpratice.ui.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.Example01Binding;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;


public class Example extends AppCompatActivity {


    //placeholder for current question int
    //and topicId
    private int currentQuestion;
    private int topicId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent() != null) {
            currentQuestion = getIntent().getIntExtra(EXTRA_CURRENT_QUESTION_ID, 0);
            topicId = getIntent().getIntExtra(EXTRA_TOPIC_ID, 0);
        }

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
}
