package com.arr.angel.pertpratice.ui.view;


import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import android.view.Gravity;

import com.arr.angel.pertpratice.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class QuestionActivityTest {

    @Rule
    public ActivityTestRule<Question01Activity> mActivityTestRule = new ActivityTestRule<>(Question01Activity.class);


    //test to check if the right labels are displayed in the
    //question's nav menu
    @Test
    public void showCorrectItemLabelInDrawer() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer


        onView(withId(R.id.nav_view)).check(matches(hasDescendant(withText(R.string.question1)))).check(matches(isDisplayed()));

        onView(withId(R.id.nav_view)).check(matches(hasDescendant(withText(R.string.question2)))).check(matches(isDisplayed()));

        onView(withId(R.id.nav_view)).check(matches(hasDescendant(withText(R.string.question3)))).check(matches(isDisplayed()));

        onView(withId(R.id.nav_view)).check(matches(hasDescendant(withText(R.string.question4)))).check(matches(isDisplayed()));

        onView(withId(R.id.nav_view)).check(matches(hasDescendant(withText(R.string.question5)))).check(matches(isDisplayed()));

        onView(withId(R.id.nav_view)).check(matches(hasDescendant(withText(R.string.question6)))).check(matches(isDisplayed()));


    }

    //just make sure all the components are present
    //example button, cardView, radio group with four options
    @Test
    public void showItemsGroupPresent(){
        onView(withId(R.id.materialCardView)).check(matches(hasDescendant(withId(R.id.button_Example)))).check(matches(isDisplayed()));
        onView(withId(R.id.radio_group)).check(matches(isDisplayed()));
        onView(withId(R.id.radio_group)).check(matches(hasChildCount(4)));

    }


}
