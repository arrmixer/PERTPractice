package com.arr.angel.pertpratice.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.arr.angel.pertpratice.db.ConverterQuestion

@Entity(tableName = "topics")
class Topic(@field:ColumnInfo(name = "topic_id") @field:PrimaryKey var id: Int, var name: String, @field:TypeConverters(ConverterQuestion::class) var questions: List<Question>) {
    var resultPercentage = 0

    //calculate the percentage for each topic
    private fun calculateTotalPercentage(): Int {
        val questions = questions
        val totalQuestions = questions.size
        var correct = 0
        for (q in questions) {
            if (q.isCorrect && q.isAnswered) {
                correct++
            }
        }
        val percentage = correct.toFloat() / totalQuestions.toFloat()
        return Math.round(percentage * 100)
    }

}