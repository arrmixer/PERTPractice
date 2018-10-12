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
import com.arr.angel.pertpratice.util.DialogCreations;
import com.arr.angel.pertpratice.util.RadioGroupHelper;
import com.arr.angel.pertpratice.util.TopicData;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.ArrayList;
import java.util.List;

public class Question01Fragment extends Fragment {

    private static final String TAG = Question01Fragment.class.getSimpleName();

    protected static final String EXTRA_ANSWER = "com.arr.angel.pertpratice.ui.view.answer";
    protected static final String EXTRA_POSSIBLE_ANSWERS = "com.arr.angel.pertpratice.ui.view.possibleAnswers";
    protected static final String EXTRA_ISANSWERED = "com.arr.angel.pertpratice.ui.view.is.answered";

    protected static final String ARGS_TOPIC_ID = "com.arr.angel.pertpratice.ui.view.topic.id";

    //instance of ViewModel
    private TopicViewModel topicViewModel;

    //DataBinding instance
    Question01Binding questionBinding;

    //views
    private TextView content;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private Button exampleButton;
    private RadioGroup radioGroup;

    //place holder for question fields
    private Topic mTopic;
    private String answer;
    private List<Question> questions;
    private Question question;
    private List<String> possibleAnswers;
    private boolean isAnswered;
    private boolean isCorrect;
    private int topicId;

    //placeholder for next question int
    private int nextQuestion = 2;


    public static Question01Fragment newInstance(int topicId) {

        Question01Fragment question01Fragment = new Question01Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_TOPIC_ID, topicId);
        question01Fragment.setArguments(bundle);

        return question01Fragment;
    }

    //Interface for hosting activities
    public interface Callbacks {
//        void onTopicSelected(Topic topic, List<Topic> topics);
//        void correctDialogFragment();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EXTRA_ANSWER, answer);
        outState.putStringArrayList(EXTRA_POSSIBLE_ANSWERS, (ArrayList<String>) possibleAnswers);
        outState.putBoolean(EXTRA_ISANSWERED, isAnswered);

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
            isAnswered = savedInstanceState.getBoolean(EXTRA_ISANSWERED);
        }

        if(getArguments() != null){
            topicId = getArguments().getInt(ARGS_TOPIC_ID);
        }

        content = questionBinding.questionText;
        radio1 = questionBinding.radioButton;
        radio2 = questionBinding.radioButton2;
        radio3 = questionBinding.radioButton3;
        radio4 = questionBinding.radioButton4;
        exampleButton = questionBinding.buttonExample;
        radioGroup = questionBinding.radioGroup;

        topicViewModel = ViewModelProviders.of(this).get(TopicViewModel.class);
        topicViewModel.getLiveTopicDataFromDB(topicId).observe(this, new Observer<Topic>() {
            @Override
            public void onChanged(@Nullable Topic topic) {
                mTopic = topic;
                populateView();
                Log.d(TAG, "isAnswered is " + isAnswered);


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

                //use helper method to generate radio group logic
                RadioGroupHelper.radioButtonLogic(getContext(), getFragmentManager(), radioGroup, checkId, answer, possibleAnswers, nextQuestion, topicId);

            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "isAnswered is " + isAnswered);
        if (isAnswered) {
            radioGroup.setVisibility(View.INVISIBLE);
            DialogCreations.showCorrectDialog(radioGroup, getFragmentManager(), nextQuestion, topicId);
        }

    }

    public void populateView() {

        questions = mTopic.getQuestions();
        question = questions.get(topicId);
        answer = question.getAnswer();
        possibleAnswers = question.getPossibleAnswers();
        content.setText(question.getContent());
        isAnswered = question.isAnswered();
        isCorrect = question.isCorrect();

        radio1.setText(possibleAnswers.get(0));
        radio2.setText(possibleAnswers.get(1));
        radio3.setText(possibleAnswers.get(2));
        radio4.setText(possibleAnswers.get(3));

    }




}
