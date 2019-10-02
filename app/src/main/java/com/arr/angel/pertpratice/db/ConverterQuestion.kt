package com.arr.angel.pertpratice.db

import androidx.room.TypeConverter
import com.arr.angel.pertpratice.model.Question
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class ConverterQuestion {
    private val moshi = Moshi.Builder().build()
    private val questionList = Types.newParameterizedType(
            List::class.java, Question::class.java
    )

    private val adapter = moshi.adapter<List<Question>>(questionList)

    @TypeConverter
    fun questionsToString(questions: List<Question> ) : String = adapter.toJson(questions)

    @TypeConverter
    fun jsonToQuestionsList(json: String) : List<Question> = adapter.fromJson(json) ?: emptyList()
}