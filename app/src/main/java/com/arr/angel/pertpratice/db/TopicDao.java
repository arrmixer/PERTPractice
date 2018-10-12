package com.arr.angel.pertpratice.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

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
