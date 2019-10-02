package com.arr.angel.pertpratice.util

import android.content.Context
import android.preference.PreferenceManager
import com.arr.angel.pertpratice.R.string

object ResultsSharedPreferences {
    private const val PREF_TOPIC_TITLE = "com.arr.angel.pertpratice.util.topic.title"
    private const val PREF_TOPIC_RESULT_PERCENTAGE = "com.arr.angel.pertpratice.util.topic.result.percentage"
    private const val PREF_TOPIC_TITLE_ID = "com.arr.angel.pertpratice.util.topic.title.id"
    @JvmStatic
    fun setPrefTopicTitle(context: Context?, title: String?) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_TOPIC_TITLE, title)
                .apply()
    }

    @JvmStatic
    fun getPrefTopicTitle(context: Context): String? {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_TOPIC_TITLE, context.getString(string.default_title_shared_pref))
    }

    @JvmStatic
    fun setPrefTopicResultPercentage(context: Context?, percentage: Int) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(PREF_TOPIC_RESULT_PERCENTAGE, percentage)
                .apply()
    }

    @JvmStatic
    fun getPrefTopicPercentage(context: Context?): Int {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getInt(PREF_TOPIC_RESULT_PERCENTAGE, 0)
    }

    @JvmStatic
    fun setPrefTopicId(context: Context?, id: Int) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(PREF_TOPIC_TITLE_ID, id)
                .apply()
    }

    @JvmStatic
    fun getPrefTopicId(context: Context?): Int {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getInt(PREF_TOPIC_TITLE_ID, 0)
    }
}