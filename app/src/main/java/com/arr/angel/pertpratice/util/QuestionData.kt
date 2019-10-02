package com.arr.angel.pertpratice.util

import com.arr.angel.pertpratice.model.Question
import java.util.*

//TODO: move to FireBase DB
class QuestionData {
    //list for questions for each topic
    private val questionListPracticeTest: MutableList<Question> = ArrayList()
    private val questionListBasic: MutableList<Question> = ArrayList()
    private val questionListIntermediate: MutableList<Question> = ArrayList()
    private val questionListAdvance: MutableList<Question> = ArrayList()
    private val questionListApplication: MutableList<Question> = ArrayList()
    /*method used to populate question data will transfer to cloud storage
     * and create a service via Firebase later on*/
    private fun makePracticeTestQuestions(): List<Question> {
        val question1PT = Question("PT01")
        val question2PT = Question("PT02")
        val question3PT = Question("PT03")
        val question4PT = Question("PT04")
        val question5PT = Question("PT05")
        val question6PT = Question("PT06")
        question1PT.content = "Which of the following is a solution to the equation c + (4 - 3c) - 2 = 0?"
        question1PT.possibleAnswers = makePossibleAnswers("-1", "0", "1", "2")
        question1PT.answer = question1PT.possibleAnswers!![2]
        question2PT.content = "Which of the following is a solution to the equation x\u00B2 - 6x + 5 = 0?"
        question2PT.possibleAnswers = makePossibleAnswers("-5", "-1", "1/5", "5")
        question2PT.answer = question2PT.possibleAnswers!![3]
        question3PT.content = "Which of the following is equivalent to the expression (3ab)(-5ab)?"
        question3PT.possibleAnswers = makePossibleAnswers("-2ab", "-2a\u00B2b\u00B2", "-15ab", "-15a\u00B2b\u00B2")
        question3PT.answer = question3PT.possibleAnswers!![3]
        question4PT.content = "Factor completely: x\u00B2 - x - 6"
        question4PT.possibleAnswers = makePossibleAnswers("(x - 2)(x + 3)", "(x - 1)(x - 6)", "(x + 2)(x - 3)", "(x + 1)(x - 6)")
        question4PT.answer = question4PT.possibleAnswers!![2]
        question5PT.content = "Which of the following is equivalent to (8 - 5) / 2\u00B3?"
        question5PT.possibleAnswers = makePossibleAnswers("3/8", "19/8", "27/48", "1/125")
        question5PT.answer = question5PT.possibleAnswers!![0]
        question6PT.content = "What is the value of the algebraic expression if x = 1/2, y = -1, and z = 2? 6x(y\u00B2z)?"
        question6PT.possibleAnswers = makePossibleAnswers("-12", "-6", "1", "6")
        question6PT.answer = question6PT.possibleAnswers!![3]
        questionListPracticeTest.add(question1PT)
        questionListPracticeTest.add(question2PT)
        questionListPracticeTest.add(question3PT)
        questionListPracticeTest.add(question4PT)
        questionListPracticeTest.add(question5PT)
        questionListPracticeTest.add(question6PT)
        return questionListPracticeTest
    }

    private fun makeBasicQuestions(): List<Question> {
        val question1Basic = Question("BA01")
        val question2Basic = Question("BA02")
        val question3Basic = Question("BA03")
        val question4Basic = Question("BA04")
        val question5Basic = Question("BA05")
        val question6Basic = Question("BA06")
        question1Basic.content = "Which of the following is equivalent to 7 ⋅ 9 - 4(6 + 7)?"
        question1Basic.possibleAnswers = makePossibleAnswers("676", "455", "13", "11")
        question1Basic.answer = question1Basic.possibleAnswers!![3]
        question2Basic.content = "Which of the following is equivalent to 22 ÷ 11 ⋅ 9 - 3\u00B3?"
        question2Basic.possibleAnswers = makePossibleAnswers("72", "9", "0.5", "12")
        question2Basic.answer = question2Basic.possibleAnswers!![1]
        question3Basic.content = "Which of the following is equivalent to 2[5\u00B2 + (36 ÷ 6)]?"
        question3Basic.possibleAnswers = makePossibleAnswers("62", "32", "56", "242")
        question3Basic.answer = question3Basic.possibleAnswers!![0]
        question4Basic.content = "Evaluate the expression a\u00B2 + b - c\u00B2 if a = 12, b = 9, and c = 4."
        question4Basic.possibleAnswers = makePossibleAnswers("7", "137", "152", "169")
        question4Basic.answer = question4Basic.possibleAnswers!![3]
        question5Basic.content = "Evaluate the expression 2c(a + b) if a = 12, b = 9, and c = 4."
        question5Basic.possibleAnswers = makePossibleAnswers("126", "160", "8", "168")
        question5Basic.answer = question5Basic.possibleAnswers!![3]
        question6Basic.content = "Evaluate the expression (a\u00B2 ÷ 4b) + c if a = 12, b = 9, and c = 4."
        question6Basic.possibleAnswers = makePossibleAnswers("8", "31", "328", "36")
        question6Basic.answer = question6Basic.possibleAnswers!![2]
        questionListBasic.add(question1Basic)
        questionListBasic.add(question2Basic)
        questionListBasic.add(question3Basic)
        questionListBasic.add(question4Basic)
        questionListBasic.add(question5Basic)
        questionListBasic.add(question6Basic)
        return questionListBasic
    }

    private fun makeIntermediateQuestions(): List<Question> {
        val question1Intermediate = Question("IN01")
        val question2Intermediate = Question("IN02")
        val question3Intermediate = Question("IN03")
        val question4Intermediate = Question("IN04")
        val question5Intermediate = Question("IN05")
        val question6Intermediate = Question("IN06")
        question1Intermediate.content = "Which of the following is a solution to the equation -7(-6x + 5) = 385?"
        question1Intermediate.possibleAnswers = makePossibleAnswers("9", "10", "55", "1")
        question1Intermediate.answer = question1Intermediate.possibleAnswers!![1]
        question2Intermediate.content = "Which of the following is a solution to the equation 16 = -x + 2x + 8?"
        question2Intermediate.possibleAnswers = makePossibleAnswers("8", "16/9", "-8", "24")
        question2Intermediate.answer = question2Intermediate.possibleAnswers!![0]
        question3Intermediate.content = "Which of the following is a solution to the equation -2x + 7 = -35 + 5x?"
        question3Intermediate.possibleAnswers = makePossibleAnswers("14", "7", "6", "4")
        question3Intermediate.answer = question3Intermediate.possibleAnswers!![2]
        question4Intermediate.content = "Find the y-intercept for the equation 2x - y = 3"
        question4Intermediate.possibleAnswers = makePossibleAnswers("3", "3/2", "-3/2", "-3")
        question4Intermediate.answer = question4Intermediate.possibleAnswers!![3]
        question5Intermediate.content = "Find the x-intercept for the equation 2x - y = 3"
        question5Intermediate.possibleAnswers = makePossibleAnswers("3", "3/2", "-3/2", "-3")
        question5Intermediate.answer = question5Intermediate.possibleAnswers!![1]
        question6Intermediate.content = "Which of the following is equivalent to the expression (2a + b)(3a + b)?"
        question6Intermediate.possibleAnswers = makePossibleAnswers("-12a\u00B2b\u00B2", "6a\u00B2-10ab-4b\u00B2", "6a\u00B2+6ab+b\u00B2", "13a\u00B3b\u00B3")
        question6Intermediate.answer = question6Intermediate.possibleAnswers!![2]
        questionListIntermediate.add(question1Intermediate)
        questionListIntermediate.add(question2Intermediate)
        questionListIntermediate.add(question3Intermediate)
        questionListIntermediate.add(question4Intermediate)
        questionListIntermediate.add(question5Intermediate)
        questionListIntermediate.add(question6Intermediate)
        return questionListIntermediate
    }

    private fun makeAdvanceQuestions(): List<Question> {
        val question1Advance = Question("AD01")
        val question2Advance = Question("AD02")
        val question3Advance = Question("AD03")
        val question4Advance = Question("AD04")
        val question5Advance = Question("AD05")
        val question6Advance = Question("AD06")
        question1Advance.content = "Which of the following is a solution to the equation: x\u00B2 - 29x + 100 = 0?"
        question1Advance.possibleAnswers = makePossibleAnswers("x = 4, x = 25", "x = -4, x = -25", "x = -10, x = -10", "x = 10, x = 10")
        question1Advance.answer = question1Advance.possibleAnswers!![0]
        question2Advance.content = "Which of the following is a solution to the equation: x\u00B2 + 7x + 12 = 0?"
        question2Advance.possibleAnswers = makePossibleAnswers("x = 3, x = 4", "x = -3, x = -4", "x = -6, x = -2", "x = 6, x = 2")
        question2Advance.answer = question2Advance.possibleAnswers!![1]
        question3Advance.content = "Which of the following is a solution to the equation: 4x\u00B2 + 6x + 2 = 0?"
        question3Advance.possibleAnswers = makePossibleAnswers("x = 2, x = 1", "x = -2, x = -1", "x = -1/2, x = -1", "x = 1/2, x = -1")
        question3Advance.answer = question3Advance.possibleAnswers!![2]
        question4Advance.content = "Which of the following is a solution to the inequality 15 - 4(x + 10) < 15?"
        question4Advance.possibleAnswers = makePossibleAnswers("x < -10", "x > -10", "x > -2.5", "x < -2.5")
        question4Advance.answer = question4Advance.possibleAnswers!![1]
        question5Advance.content = "Which of the following is a solution to the inequality 16 + 3(3x - 4) ≥ 76?"
        question5Advance.possibleAnswers = makePossibleAnswers("x ≤ 8", "x ≥ 11 ", "x ≥ 12", "x ≥ 8")
        question5Advance.answer = question5Advance.possibleAnswers!![3]
        question6Advance.content = "Factor completely: x\u00B2 - 3x + 2"
        question6Advance.possibleAnswers = makePossibleAnswers("(x + 1)(x + 2)", "(x - 2)(x - 1)", "(x + 3)(x - 1)", "(x - 3)(x + 1)")
        question6Advance.answer = question6Advance.possibleAnswers!![1]
        questionListAdvance.add(question1Advance)
        questionListAdvance.add(question2Advance)
        questionListAdvance.add(question3Advance)
        questionListAdvance.add(question4Advance)
        questionListAdvance.add(question5Advance)
        questionListAdvance.add(question6Advance)
        return questionListAdvance
    }

    private fun makeApplicationQuestions(): List<Question> {
        val question1Application = Question("AP01")
        val question2Application = Question("AP02")
        val question3Application = Question("AP03")
        val question4Application = Question("AP04")
        val question5Application = Question("AP05")
        val question6Application = Question("AP06")
        question1Application.content = "What is 25% of $50?"
        question1Application.possibleAnswers = makePossibleAnswers("$25", "$10", "5.50", "$12.50")
        question1Application.answer = question1Application.possibleAnswers!![3]
        question2Application.content = "What is 20% of $124?"
        question2Application.possibleAnswers = makePossibleAnswers("$20", "$24.80", "$15.30", "30")
        question2Application.answer = question2Application.possibleAnswers!![1]
        question3Application.content = "What is 15% of $112?"
        question3Application.possibleAnswers = makePossibleAnswers("$16.80", "$15.00", "$26.25", "$5.50")
        question3Application.answer = question3Application.possibleAnswers!![0]
        question4Application.content = "A rectangular garden has a length of x - 3 and a width of x\u00B2 + 8x + 1. " +
                "Which of the following expressions is equivalent to the area of the yard."
        question4Application.possibleAnswers = makePossibleAnswers("x\u00B2 + 9x - 2", "2x\u00B2 + 18x - 4", "x³ + 5x\u00B2 - 23x - 3", "x\u00B2 - 6x + 9")
        question4Application.answer = question4Application.possibleAnswers!![2]
        question5Application.content = "The area of a rectangular garden is x\u00B2 - 3x + 2. Which of the following expressions represent the length and the width of the garden?"
        question5Application.possibleAnswers = makePossibleAnswers("(x - 2)(x - 3)", "(x - 1)(x - 2)", "(x + 2)(x + 1)", "(x + 2)(x + 3)")
        question5Application.answer = question5Application.possibleAnswers!![1]
        question6Application.content = "Best Buy is selling a television for $1250.00. " +
                "Sales tax in Miami-Dade County is 7%. Using P as the amount I will have to pay " +
                "for the television (including sales tax),write an algebraic equation " +
                "that describes this transaction."
        question6Application.possibleAnswers = makePossibleAnswers("P = (0.07)(1250)", "P = 1250 ÷ 0.06", "P = 1250 + (0.07)(1250)", "P = 1250(0.93)")
        question6Application.answer = question6Application.possibleAnswers!![2]
        questionListApplication.add(question1Application)
        questionListApplication.add(question2Application)
        questionListApplication.add(question3Application)
        questionListApplication.add(question4Application)
        questionListApplication.add(question5Application)
        questionListApplication.add(question6Application)
        return questionListApplication
    }

    fun getQuestionListPracticeTest(): List<Question> {
        return makePracticeTestQuestions()
    }

    fun getQuestionListBasic(): List<Question> {
        return makeBasicQuestions()
    }

    fun getQuestionListIntermediate(): List<Question> {
        return makeIntermediateQuestions()
    }

    fun getQuestionListAdvance(): List<Question> {
        return makeAdvanceQuestions()
    }

    fun getQuestionListApplication(): List<Question> {
        return makeApplicationQuestions()
    }

    fun makePossibleAnswers(a: String, b: String, c: String, d: String): List<String> {
        val possibleAnswers: MutableList<String> = ArrayList()
        possibleAnswers.add(a)
        possibleAnswers.add(b)
        possibleAnswers.add(c)
        possibleAnswers.add(d)
        return possibleAnswers
    }
}