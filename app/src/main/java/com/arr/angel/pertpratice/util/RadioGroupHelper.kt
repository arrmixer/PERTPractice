package com.arr.angel.pertpratice.util

import android.widget.RadioGroup
import androidx.fragment.app.FragmentManager
import com.arr.angel.pertpratice.R.id

object RadioGroupHelper {
    @JvmStatic
    fun radioButtonLogic(radioGroup: RadioGroup, fragmentManager: FragmentManager?,
                         checkId: Int,
                         answer: String?, possibleAnswers: List<String>?, currentQuestion: Int, nextQuestion: Int, topicId: Int) {
        when (checkId) {
            id.radioButton -> if (answer!!.contentEquals(possibleAnswers!![0])) {
                radioGroup.clearCheck()
                DialogCreations.showCorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId)
            } else {
                radioGroup.clearCheck()
                DialogCreations.showIncorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId)
            }
            id.radioButton2 -> if (answer!!.contentEquals(possibleAnswers!![1])) {
                radioGroup.clearCheck()
                DialogCreations.showCorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId)
            } else {
                radioGroup.clearCheck()
                DialogCreations.showIncorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId)
            }
            id.radioButton3 -> if (answer!!.contentEquals(possibleAnswers!![2])) {
                radioGroup.clearCheck()
                DialogCreations.showCorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId)
            } else {
                radioGroup.clearCheck()
                DialogCreations.showIncorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId)
            }
            id.radioButton4 -> if (answer!!.contentEquals(possibleAnswers!![3])) {
                radioGroup.clearCheck()

                DialogCreations.showCorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId)
            } else {
                radioGroup.clearCheck()
                DialogCreations.showIncorrectDialog(fragmentManager, currentQuestion, nextQuestion, topicId)
            }
        }
    }
}