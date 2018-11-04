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
import com.arr.angel.pertpratice.databinding.Question02Binding;
import com.arr.angel.pertpratice.model.Question;
import com.arr.angel.pertpratice.model.Topic;
import com.arr.angel.pertpratice.util.DialogCreations;
import com.arr.angel.pertpratice.util.RadioGroupHelper;
import com.arr.angel.pertpratice.viewmodel.TopicViewModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import static com.arr.angel.pertpratice.ui.view.CorrectAnswerDialogFragment.EXTRA_IS_ANSWERED;
import static com.arr.angel.pertpratice.ui.view.MainFragment.ARGS_CURRENT_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.ARGS_TOPIC_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.ARG_IS_ANSWERED;
import static com.arr.angel.pertpratice.ui.view.MainFragment.ARG_IS_CORRECT;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_ANSWER;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_IS_NEXT_UNANSWERED_QUESTION_ID;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_POSSIBLE_ANSWERS;

public class Question02Fragment extends Fragment {
    private static final String TAG = Question02Fragment.class.getSimpleName();

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
    private int nextQuestion = 3;

    //placeholder for current question int
    private int currentQuestion;

    //placeholder for ads
    private AdView mAdView;

    public static Question02Fragment newInstance(int previousQuestionId, boolean correct, boolean answered, int topicId) {
        Question02Fragment question02Fragment = new Question02Fragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_CURRENT_ID, previousQuestionId);
        bundle.putBoolean(ARG_IS_CORRECT, correct);
        bundle.putBoolean(ARG_IS_ANSWERED, answered);
        bundle.putInt(ARGS_TOPIC_ID, topicId);
        question02Fragment.setArguments(bundle);

        return question02Fragment;
    }


    //DataBinding instance
    Question02Binding questionBinding;

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
        questionBinding = DataBindingUtil.inflate(inflater, R.layout.question02, container, false);
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


                if (isAnswered) {
                    //placeholder for next unanswered question if any
                    nextUnansweredQuestionId = 0;

                    //check to see if question was answered correctly
                    isCorrect = question.isCorrect();

                    for (Question q : questions) {

                        //check to see if question is already answered
                        //and redirect user to next available question if any
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

        Log.d(TAG, "previousIsAnswered is " + previousIsAnswered);


        exampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Example2.class);
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
                    DialogCreations.showAlreadyAnsweredDialog(getFragmentManager(), currentQuestion, nextUnansweredQuestionId, topicId, isCorrect );
                }

            }
        });

        mAdView = questionBinding.adView;
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);


    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onPause() {
        mAdView.pause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mAdView.destroy();
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        radioGroup.clearCheck();
        mAdView.resume();

    }

    public void populateView() {

        questions = mTopic.getQuestions();
        question = questions.get(1);

        //get question int
        currentQuestion = Integer.parseInt(question.getId().substring(3));
        answer = question.getAnswer();
        possibleAnswers = question.getPossibleAnswers();
        content.setText(questions.get(1).getContent());

        radio1.setText(possibleAnswers.get(0));
        radio2.setText(possibleAnswers.get(1));
        radio3.setText(possibleAnswers.get(2));
        radio4.setText(possibleAnswers.get(3));

    }

}
