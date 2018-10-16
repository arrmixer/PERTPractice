package com.arr.angel.pertpratice.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.arr.angel.pertpratice.ui.view.MainActivity;
import com.arr.angel.pertpratice.ui.view.MainFragment;
import com.arr.angel.pertpratice.ui.view.Question01Activity;

//class used to generic helper methods
public class UtilMethods {

    public static String showTopicTitle(int topicId){

        switch (topicId){
            case 0:
                return "Practice Test";
            case 1:
                return "Basic";
            case 2:
                return "Intermediate";
            case 3:
                return "Advance";
            case 4:
                return "Application";
        }

        return "PERTPractice";
    }



}
