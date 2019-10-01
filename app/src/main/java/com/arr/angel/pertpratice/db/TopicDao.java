package com.arr.angel.pertpratice.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.arr.angel.pertpratice.model.Topic;

import java.util.List;

@Dao
interface TopicDao {
    @Query("SELECT * FROM topics ORDER BY topic_id ASC")
    LiveData<List<Topic>> loadAllTopics();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopic(Topic topic);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTopic(Topic topic);

    @Delete
    void deleteTopic(Topic topic);

    @Query("SELECT * FROM topics WHERE topic_id = :id")
    LiveData<Topic> loadTopicById(int id);

}
