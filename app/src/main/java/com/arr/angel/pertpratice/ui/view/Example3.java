package com.arr.angel.pertpratice.ui.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.Example03Binding;

import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_TOPIC_ID;

public class Example3 extends AppCompatActivity {

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

        Example03Binding example03Binding =
                DataBindingUtil.setContentView(this, R.layout.example03);


        //populate the text views
        example03Binding.textView1.setText(R.string.t1_example_question03_txt1);

        example03Binding.textView2.setText(R.string.t1_example_question03_txt2);

        example03Binding.textView3.setText(R.string.t1_example_question03_txt3);

        example03Binding.textView4.setText(R.string.t1_example_question03_txt4);


    }
}
