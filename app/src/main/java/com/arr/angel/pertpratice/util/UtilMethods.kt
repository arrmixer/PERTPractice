package com.arr.angel.pertpratice.util

import com.arr.angel.pertpratice.model.Question

//class used to generic helper methods
object UtilMethods {
    @JvmStatic
    fun showTopicTitle(topicId: Int): String {
        when (topicId) {
            0 -> return "Practice Test"
            1 -> return "Basic"
            2 -> return "Intermediate"
            3 -> return "Advance"
            4 -> return "Application"
        }
        return "PERTPractice"
    }

    @JvmStatic
    fun calculateTotalPercentage(questions: List<Question>): Int {
        val totalQuestions = questions.size
        var correct = 0
        for (q in questions) {
            if (q.isCorrect && q.isAnswered) {
                correct++
            }
        }
        return calculatePercentage(correct, totalQuestions)
    }

    @JvmStatic
    fun calculatePercentage(correct: Int, totalQuestions: Int): Int {
        val percentage = correct.toFloat() / totalQuestions.toFloat()
        return Math.round(percentage * 100)
    }
}