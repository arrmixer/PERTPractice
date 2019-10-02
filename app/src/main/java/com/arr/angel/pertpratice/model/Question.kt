package com.arr.angel.pertpratice.model

class Question(var id: String) {
    var content: String? = null
    var possibleAnswers: List<String>? = null
    var answer: String? = null
    var isAnswered = false
    var isCorrect = false
}