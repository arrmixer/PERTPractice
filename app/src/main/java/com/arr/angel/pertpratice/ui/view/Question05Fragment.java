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

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.databinding.Question05Binding;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.util.DialogCreations;
import com.arr.angel.pertpratice.util.RadioGroupHelper;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.arr.angel.pertpratice.ui.view.Question01Fragment.ARGS_CURRENT_ID;
import static com.arr.angel.pertpratice.ui.view.Question01Fragment.ARGS_TOPIC_ID;
import static com.arr.angel.pertpratice.ui.view.Question01Fragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.Question01Fragment.EXTRA_IS_ANSWERED;
import static com.arr.angel.pertpratice.ui.view.Question01Fragment.EXTRA_IS_NEXT_UNANSWERED_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.Question02Fragment.ARG_IS_ANSWERED;
import static com.arr.angel.pertpratice.ui.view.Question02Fragment.ARG_IS_CORRECT;

public class Question05Fragment extends Fragment {
    private static final String TAG = Question05Fragment.class.getSimpleName();

    protected static final String EXTRA_ANSWER = "com.arr.angel.pertpratice.ui.view.answer";
    protected static final String EXTRA_POSSIBLE_ANSWERS = "com.arr.angel.pertpratice.ui.view.possibleAnswers";

    /*Placeholders for Topics*/
    private List<Topic> mTopicList;

    //instance of ViewModel
    private TopicViewModel topicViewModel;

    //DataBinding instance
    Question05Binding questionBinding;

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
    private int topicId;
    private String answer;
    private List<Question> questions;
    private Question question;
    private List<String> possibleAnswers;

    //id for next unanswered question
    //in question list
    private int nextUnansweredQuestionId;

    //boolean data for previous question
    private int previousQuestionId;
    private boolean previousIsAnswered;
    private boolean previousIsCorrect;

    //boolean data for current question
    private boolean isAnswered;
    private boolean isCorrect;

    //placeholder for next question int
    private int nextQuestion = 6;

    //placeholder for current question int
    private int currentQuestion;

    public static Question05Fragment newInstance(int previousQuestionId, boolean correct, boolean answered, int topicId) {
        Question05Fragment question05Fragment = new Question05Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_CURRENT_ID, previousQuestionId);
        bundle.putBoolean(ARG_IS_CORRECT, correct);
        bundle.putBoolean(ARG_IS_ANSWERED, answered);
        bundle.putInt(ARGS_TOPIC_ID, topicId);

        question05Fragment.setArguments(bundle);

        return question05Fragment;
    }

    //Interface for hosting activities
    public interface Callbacks {
        void onTopicSelected(Topic topic, List<Topic> topics);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EXTRA_ANSWER, answer);
        outState.putStringArrayList(EXTRA_POSSIBLE_ANSWERS, (ArrayList<String>) possibleAnswers);
        outState.putBoolean(EXTRA_IS_ANSWERED, isAnswered);
        outState.putInt(EXTRA_IS_NEXT_UNANSWERED_QUESTION_ID, nextUnansweredQuestionId);
        outState.putInt(EXTRA_CURRENT_QUESTION_ID, currentQuestion);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        questionBinding = DataBindingUtil.inflate(inflater, R.layout.question05, container, false);
        questionBinding.setLifecycleOwner(this);


        return questionBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {

            answer = savedInstanceState.getString(EXTRA_ANSWER);
            possibleAnswers = savedInstanceState.getStringArrayList(EXTRA_POSSIBLE_ANSWERS);
            isAnswered = savedInstanceState.getBoolean(EXTRA_IS_ANSWERED);
            nextUnansweredQuestionId = savedInstanceState.getInt(EXTRA_IS_NEXT_UNANSWERED_QUESTION_ID);
            currentQuestion = savedInstanceState.getInt(EXTRA_CURRENT_QUESTION_ID);

        }

        if (getArguments() != null) {

            previousQuestionId = getArguments().getInt(ARGS_CURRENT_ID);
            previousIsAnswered = getArguments().getBoolean(ARG_IS_ANSWERED);
            previousIsCorrect = getArguments().getBoolean(ARG_IS_CORRECT);
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

                //questions are indexed at 1 not 0
                if (previousIsAnswered) {

                    //questions are indexed at 1 not 0
                    Question previousQuestion = questions.get(previousQuestionId - 1);
                    previousQuestion.setCorrect(previousIsCorrect);
                    previousQuestion.setAnswered(previousIsAnswered);
                    topicViewModel.insertTopic(mTopic);

                    //reset boolean to keep onchange from updating
                    previousIsAnswered = false;
                }

                //check to see if question is already answered
                isAnswered = question.isAnswered();
                Log.d(TAG, "isAnswered is " + isAnswered);

                //redirect user to next available question if
                // question is already answer; if any, otherwise
                // go to results menu
                if (isAnswered) {
                    //placeholder for next unanswered question if any
                    nextUnansweredQuestionId = 0;

                    //check to see if question was answered correctly
                    isCorrect = question.isCorrect();

                    //check to see if question is already answered
                    //and redirect user to next available question if any
                    for (Question q : questions) {
                        if (!q.isAnswered()) {
                            //get question number from question id
                            //example string PT01 question number is 1
                            String number = q.getId().substring(3);
                            nextUnansweredQuestionId = Integer.parseInt(number);
                            break;
                        }

                    }


                }


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

                if (!isAnswered) {
                    RadioGroupHelper.radioButtonLogic(radioGroup, getFragmentManager(),
                            checkId, answer, possibleAnswers, currentQuestion, nextQuestion, topicId);
                } else {
                    DialogCreations.showAlreadyAnsweredDialog(getFragmentManager(), currentQuestion,  nextUnansweredQuestionId, topicId, isCorrect);
                }


            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        radioGroup.clearCheck();

    }

    public void populateView() {
        questions = mTopic.getQuestions();
        question = questions.get(4);

        //get question int
        currentQuestion = Integer.parseInt(question.getId().substring(3));

        answer = question.getAnswer();
        possibleAnswers = question.getPossibleAnswers();
        content.setText(question.getContent());

        radio1.setText(possibleAnswers.get(0));
        radio2.setText(possibleAnswers.get(1));
        radio3.setText(possibleAnswers.get(2));
        radio4.setText(possibleAnswers.get(3));

    }

}
