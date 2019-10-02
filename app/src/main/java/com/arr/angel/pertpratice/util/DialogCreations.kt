package com.arr.angel.pertpratice.util

import androidx.fragment.app.FragmentManager
import com.arr.angel.pertpratice.ui.view.*


object DialogCreations {
    const val nextQuestionNumberArg = "com.arr.angel.pertpratice.ui.view.next_question"
    const val currentQuestionNumberArg = "com.arr.angel.pertpratice.ui.view.current_question_id"
    const val currentQuestionIsCorrectArg = "com.arr.angel.pertpratice.ui.view.current_question_is_correct"

    @JvmStatic
    fun showCorrectDialog(fragmentManager: FragmentManager?, currentQuestion: Int, nextQuestion: Int, topicId: Int) {
        val correctAnswerDialogFragment: CorrectAnswerDialogFragment = CorrectAnswerDialogFragment.newInstance(currentQuestion, nextQuestion, topicId)
        correctAnswerDialogFragment.isCancelable = false
        correctAnswerDialogFragment.show(fragmentManager!!, "correct")
    }

    @JvmStatic
    fun showIncorrectDialog(fragmentManager: FragmentManager?, currentQuestion: Int, nextQuestion: Int, topicId: Int) {
        val inCorrectAnswerDialogFragment: InCorrectAnswerDialogFragment = InCorrectAnswerDialogFragment.newInstance(currentQuestion, nextQuestion, topicId)
        inCorrectAnswerDialogFragment.isCancelable = false
        inCorrectAnswerDialogFragment.show(fragmentManager!!, "incorrect")
    }

    @JvmStatic
    fun showAlreadyAnsweredDialog(fragmentManager: FragmentManager?, currentQuestion: Int, nextQuestion: Int, topicId: Int, isCorrect: Boolean) {
        val alreadyAnsweredDialogFragment: AlreadyAnsweredDialogFragment = AlreadyAnsweredDialogFragment.newInstance(currentQuestion, nextQuestion, topicId, isCorrect)
        alreadyAnsweredDialogFragment.isCancelable = false
        if (!alreadyAnsweredDialogFragment.isVisible) {
            alreadyAnsweredDialogFragment.show(fragmentManager!!, "already_answered")
        }
    }

    @JvmStatic
    fun check(question: Int): Class<*> {
        when (question) {
            1 -> return Question01Activity::class.java
            2 -> return Question02Activity::class.java
            3 -> return Question03Activity::class.java
            4 -> return Question04Activity::class.java
            5 -> return Question05Activity::class.java
            6 -> return Question06Activity::class.java
        }
        return TopicResultsActivity::class.java
    }
}