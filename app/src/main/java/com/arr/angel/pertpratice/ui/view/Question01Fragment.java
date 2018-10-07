package com.arr.angel.pertpratice.ui.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.Question01Binding;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.ArrayList;
import java.util.List;

public class Question01Fragment extends Fragment {

    private static final String TAG = Question01Fragment.class.getSimpleName();

    protected static final String EXTRA_ANSWER = "com.arr.angel.pertpratice.ui.view.answer";
    protected static final String EXTRA_POSSIBLE_ANSWERS = "com.arr.angel.pertpratice.ui.view.possibleAnswers";

    /*Placeholders for Topics*/
    private List<Topic> mTopicList;

    //instance of ViewModel
    private TopicViewModel topicViewModel;

    //views
    private TextView content;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private Button exampleButton;
    private RadioGroup radioGroup;

    //place holder for question fields
    private String answer;
    private List<Question> questions;
    private Question question;
    List<String> possibleAnswers;
    boolean isAnswered;
    boolean isCorrect;

    public static Question01Fragment newInstance() {
        Question01Fragment question01Fragment = new Question01Fragment();

        return question01Fragment;
    }

    //DataBinding instance
    Question01Binding questionBinding;

    //Interface for hosting activities
    public interface Callbacks {
        void onTopicSelected(Topic topic, List<Topic> topics);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EXTRA_ANSWER, answer);
        outState.putStringArrayList(EXTRA_POSSIBLE_ANSWERS, (ArrayList<String>) possibleAnswers);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        questionBinding = DataBindingUtil.inflate(inflater, R.layout.question01, container, false);
        questionBinding.setLifecycleOwner(this);


        return questionBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            answer = savedInstanceState.getString(EXTRA_ANSWER);
            possibleAnswers = savedInstanceState.getStringArrayList(EXTRA_POSSIBLE_ANSWERS);
        }

        content = questionBinding.questionText;
        radio1 = questionBinding.radioButton;
        radio2 = questionBinding.radioButton2;
        radio3 = questionBinding.radioButton3;
        radio4 = questionBinding.radioButton4;
        exampleButton = questionBinding.buttonExample;
        radioGroup = questionBinding.radioGroup01;

        topicViewModel = ViewModelProviders.of(this).get(TopicViewModel.class);
        topicViewModel.setLiveTopicListData();
        topicViewModel.getLiveTopicListDataFromDB().observe(this, new Observer<List<Topic>>() {
            @Override
            public void onChanged(@Nullable List<Topic> topics) {
                Log.i(TAG, "OnChanged called!");
                mTopicList = topics;
                populateView();

            }
        });

        exampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Example01.class);
                startActivity(intent);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
//                Log.d(TAG, "Radio clicked is " + getResources().getResourceName(radioGroup.getCheckedRadioButtonId()) +
//                " and the id is " + getResources().getResourceName(checkId));

                switch (checkId) {
                    case R.id.radioButton:
                        if (answer.contentEquals(possibleAnswers.get(0))) {
                            Toast.makeText(getContext(), "correct!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.radioButton2:
                        if (answer.contentEquals(possibleAnswers.get(1))) {
                            Toast.makeText(getContext(), "correct!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.radioButton3:
                        if (answer.contentEquals(possibleAnswers.get(2))) {
                            Toast.makeText(getContext(), "correct!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.radioButton4:
                        if (answer.contentEquals(possibleAnswers.get(3))) {
                            Toast.makeText(getContext(), "correct!", Toast.LENGTH_SHORT).show();
                        }
                        break;

                }

            }
        });


    }

    public void populateView() {
//        mTopicList = topicViewModel.getLiveTopicListData().getValue();
        questions = mTopicList.get(0).getQuestions();
        question = questions.get(0);
        answer = question.getAnswer();
        possibleAnswers = question.getPossibleAnswers();
        content.setText(questions.get(0).getContent());

        radio1.setText(possibleAnswers.get(0));
        radio2.setText(possibleAnswers.get(1));
        radio3.setText(possibleAnswers.get(2));
        radio4.setText(possibleAnswers.get(3));

    }


}
