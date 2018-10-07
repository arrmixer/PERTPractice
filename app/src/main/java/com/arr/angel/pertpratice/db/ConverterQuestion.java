package com.arr.angel.pertpratice.db;

import android.arch.persistence.room.TypeConverter;

import com.arr.angel.pertpratice.model.Question;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ConverterQuestion {

    @TypeConverter
    public static List<Question> fromStringQuestion(String value) {
        Type listType = new TypeToken<ArrayList<Question>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayListQuestion(List<Question> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
