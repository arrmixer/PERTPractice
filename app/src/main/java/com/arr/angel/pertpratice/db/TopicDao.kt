package com.arr.angel.pertpratice.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arr.angel.pertpratice.model.Topic

@Dao
interface TopicDao {
    @Query("SELECT * FROM topics ORDER BY topic_id ASC")
    fun loadAllTopics(): LiveData<List<Topic>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopic(topic: Topic?)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTopic(topic: Topic?)

    @Delete
    fun deleteTopic(topic: Topic?)

    @Query("SELECT * FROM topics WHERE topic_id = :id")
    fun loadTopicById(id: Int): LiveData<Topic>
}