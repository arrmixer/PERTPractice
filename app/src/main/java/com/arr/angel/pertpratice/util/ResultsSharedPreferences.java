package com.arr.angel.pertpratice.util;

import android.content.Context;
import android.preference.PreferenceManager;

public class ResultsSharedPreferences {

    private static final String PREF_TOPIC_TITLE = "com.arr.angel.pertpratice.util.topic.title";
    private static final String PREF_TOPIC_RESULT_PERCENTAGE = "com.arr.angel.pertpratice.util.topic.result.percentage";
    private static final String PREF_TOPIC_TITLE_ID = "com.arr.angel.pertpratice.util.topic.title.id";

    public static void setPrefTopicTitle(Context context, String title){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_TOPIC_TITLE, title)
                .apply();
    }

    public static String getPrefTopicTitle(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_TOPIC_TITLE, "Practice Test");
    }

    public static void setPrefTopicResultPercentage(Context context, int percentage){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(PREF_TOPIC_RESULT_PERCENTAGE, percentage)
                .apply();
    }

    public static int getPrefTopicPercentage(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getInt(PREF_TOPIC_RESULT_PERCENTAGE, 0);
    }

    public static void setPrefTopicId(Context context, int id){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(PREF_TOPIC_TITLE_ID, id)
                .apply();
    }

    public static int getPrefTopicId(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getInt(PREF_TOPIC_TITLE_ID, 0);
    }
}
