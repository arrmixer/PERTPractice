package com.arr.angel.pertpratice.util;

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
