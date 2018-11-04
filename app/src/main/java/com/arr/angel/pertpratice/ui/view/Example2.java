package com.arr.angel.pertpratice.ui.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.Example02Binding;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;

public class Example2 extends AppCompatActivity {

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
}
