package com.arr.angel.pertpratice.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arr.angel.pertpratice.BuildConfig
import com.arr.angel.pertpratice.model.Topic
import kotlinx.coroutines.CoroutineScope

val dbScope = CoroutineScope(DB)

@Database(entities = [Topic::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mTopicDao(): TopicDao

    companion object {
        private val LOG_TAG: String = AppDatabase::class.java.simpleName
        private const val DATABASE_NAME = "topics"
        private var sInstance: AppDatabase? = null
        fun getInstance(ctx: Context): AppDatabase {
            if (sInstance == null) {
                Log.d(LOG_TAG, "Creating new database instance")
                sInstance = buildDatabase(ctx)
            }
            Log.d(LOG_TAG, "Getting the database instance")
            return sInstance!!
        }

        private fun buildDatabase(ctx: Context) = Room
                .databaseBuilder(ctx, AppDatabase::class.java, DATABASE_NAME)
                .apply { if (BuildConfig.DEBUG) fallbackToDestructiveMigration() }
                .build()
    }
}

