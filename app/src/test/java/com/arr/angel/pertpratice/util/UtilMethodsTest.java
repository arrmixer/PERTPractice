package com.arr.angel.pertpratice.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilMethodsTest {

    @Test
    public void showTopicTitle() {

        assertEquals(UtilMethods.showTopicTitle(0), "Practice Test");
        assertEquals(UtilMethods.showTopicTitle(1), "Basic");
        assertEquals(UtilMethods.showTopicTitle(2), "Intermediate");
        assertEquals(UtilMethods.showTopicTitle(3), "Advance");
        assertEquals(UtilMethods.showTopicTitle(4), "Application");
        assertEquals(UtilMethods.showTopicTitle(5), "PERTPractice");

    }

    @Test
    public void calculatePercentage() {
        assertEquals(UtilMethods.calculatePercentage(3, 6), 50);
        assertEquals(UtilMethods.calculatePercentage(1, 6), 17);
        assertEquals(UtilMethods.calculatePercentage(2, 6), 33);
        assertEquals(UtilMethods.calculatePercentage(5, 6), 83);

    }
}