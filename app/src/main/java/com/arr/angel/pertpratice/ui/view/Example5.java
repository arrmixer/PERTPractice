package com.arr.angel.pertpratice.ui.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.Example05Binding;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;

public class Example5 extends AppCompatActivity {

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

        Example05Binding example05Binding =
                DataBindingUtil.setContentView(this, R.layout.example05);


        //populate the text views
        example05Binding.textView1.setText(R.string.t1_example_question05_txt1);

        example05Binding.textView2.setText(R.string.t1_example_question05_txt2);

        example05Binding.textView3.setText(R.string.t1_example_question05_txt3);

        example05Binding.textView4.setText(R.string.t1_example_question05_txt4);

        example05Binding.textView5.setText(R.string.t1_example_question05_txt5);

        example05Binding.textView6.setText(R.string.t1_example_question05_txt6);


    }
}
