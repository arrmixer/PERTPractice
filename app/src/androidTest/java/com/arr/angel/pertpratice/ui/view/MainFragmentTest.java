package com.arr.angel.pertpratice.ui.view;


import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import com.arr.angel.pertpratice.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onIdle;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.arr.angel.pertpratice.ui.view.TopicResultsFragmentTest.withViewAtPosition;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;


@RunWith(AndroidJUnit4.class)
public class MainFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init() {
        mActivityTestRule.getActivity().getSupportFragmentManager().beginTransaction();
    }


    @Test
    public void recyclerViewIsPresent() {

        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        recyclerView.check(matches(isDisplayed()));


        recyclerView.check(matches(withViewAtPosition(0,
                hasDescendant(allOf(withText(R.string.practice_test),
                        isDisplayed())))));

        recyclerView.check(matches(withViewAtPosition(1,
                hasDescendant(allOf(withText(R.string.basic),
                        isDisplayed())))));

        recyclerView.check(matches(withViewAtPosition(2,
                hasDescendant(allOf(withText(R.string.intermediate),
                        isDisplayed())))));


        recyclerView.perform(RecyclerViewActions.scrollToPosition(3));

        recyclerView.check(matches(withViewAtPosition(3,
                hasDescendant(allOf(withText(R.string.advance),
                        isDisplayed())))));



        recyclerView.perform(RecyclerViewActions.scrollToPosition(4));

        recyclerView.check(matches(withViewAtPosition(4,
                hasDescendant(allOf(withText(R.string.application),
                        isDisplayed())))));


    }



}
