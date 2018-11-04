package com.arr.angel.pertpratice.ui.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.Example06Binding;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;


public class Example6 extends AppCompatActivity {

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

        Example06Binding example06Binding =
                DataBindingUtil.setContentView(this, R.layout.example06);


        //populate the textviews
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
}
