package com.arr.angel.pertpratice.ui.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.Example04Binding;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;


public class Example4 extends AppCompatActivity {

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
}
