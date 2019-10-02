package com.arr.angel.pertpratice.util

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import com.arr.angel.pertpratice.ui.view.MainFragment
import com.arr.angel.pertpratice.ui.view.OverallTopicResultsActivity
import com.arr.angel.pertpratice.ui.view.Question01Activity

object NavigationDrawerMenuMethods {
    @JvmStatic
    fun mainDrawerMenuNavigation(context: Context, menuItem: MenuItem) {
        when (menuItem.title.toString()) {
            "Practice Test" -> navToTopic(context, 0)
            "Basic" -> navToTopic(context, 1)
            "Intermediate" -> navToTopic(context, 2)
            "Advance" -> navToTopic(context, 3)
            "Application" -> navToTopic(context, 4)
            "Overall Results" -> navToOverallResults(context)
        }
    }

    @JvmStatic
    fun questionDrawerMenuNavigation(context: Context, menuItem: MenuItem, topicId: Int) {
        when (menuItem.title.toString()) {
            "Question 1" -> navToQuestion(context, topicId, 1)
            "Question 2" -> navToQuestion(context, topicId, 2)
            "Question 3" -> navToQuestion(context, topicId, 3)
            "Question 4" -> navToQuestion(context, topicId, 4)
            "Question 5" -> navToQuestion(context, topicId, 5)
            "Question 6" -> navToQuestion(context, topicId, 6)
        }
    }

    //utility method to launch topic from nav menu
    private fun navToTopic(context: Context, topicId: Int) {
        val intent = Intent(context, Question01Activity::class.java)
        intent.putExtra(MainFragment.EXTRA_TOPIC_ID, topicId)
        context.startActivity(intent)
    }

    private fun navToOverallResults(context: Context) {
        val intent = Intent(context, OverallTopicResultsActivity::class.java)
        context.startActivity(intent)
    }

    //utility method to launch question from nav menu
    //using check() method to get correct Question Activity
    // base on the question number
    private fun navToQuestion(context: Context, topicId: Int, questionNumber: Int) {
        val intent = Intent(context, DialogCreations.check(questionNumber))
        intent.putExtra(MainFragment.EXTRA_TOPIC_ID, topicId)
        context.startActivity(intent)
    }
}