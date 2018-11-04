package com.arr.angel.pertpratice.ui.view;


import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.CoordinatesProvider;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.arr.angel.pertpratice.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.arr.angel.pertpratice.ui.view.TopicResultsFragmentTest.withViewAtPosition;
import static org.hamcrest.Matchers.allOf;


@RunWith(AndroidJUnit4.class)
public class MainFragmentTest {

    private final String TAG = MainFragment.class.getSimpleName();

    private IdlingResource mIdlingResource;


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init() {
        mActivityTestRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Before
    public void registerIdlingResource() {
        mIdlingResource = mActivityTestRule.getActivity().getIdlingResource();
        // To prove that the test fails, omit this call:
        IdlingRegistry.getInstance().register(mIdlingResource);
    }


    @Test
    public void recyclerViewIsPresent() {

        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        recyclerView.check(matches(isDisplayed()));

    }

    //the next tests verify all the elements on each
    // recycler view item is shown on screen

    @Test
    public void recyclerViewItemsArePresent() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        checkElementsInItem(recyclerView, 0, R.string.practice_test, R.id.buttonPractice, R.id.buttonResults);

    }

    @Test
    public void recyclerViewItemsArePresent1() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        checkElementsInItem(recyclerView, 1, R.string.basic, R.id.buttonPractice, R.id.buttonResults);

    }

    @Test
    public void recyclerViewItemsArePresent2() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));
        recyclerView.perform(RecyclerViewActions.scrollToPosition(3));

        checkElementsInItem(recyclerView, 2, R.string.intermediate, R.id.buttonPractice, R.id.buttonResults);

    }

    @Test
    public void recyclerViewItemsArePresent3() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));
        recyclerView.perform(RecyclerViewActions.scrollToPosition(4));

        checkElementsInItem(recyclerView, 3, R.string.advance, R.id.buttonPractice, R.id.buttonResults);

    }

    //scroll to position doesn't work with coordinator
    //found a work around on stack over flow https://stackoverflow.com/a/43724594/5104935

    @Test
    public void recyclerViewItemsArePresent4() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));


        onView(withId(R.id.recycler_view_topics)).perform(swipeFromCenterToTop());

        registerIdlingResource();

        onView(withId(R.id.recycler_view_topics)).perform(swipeFromCenterToTop());

        checkElementsInItem(recyclerView, 4, R.string.application, R.id.buttonPractice, R.id.buttonResults);

    }

    // Remember to unregister resources when not needed to avoid malfunction.
    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(mIdlingResource);
        }
    }


    public void checkElementsInItem(ViewInteraction view, int position, @StringRes int text, @IdRes int id, @IdRes int id2) {

        view.check(matches(withViewAtPosition(position,
                hasDescendant(allOf(withText(text),
                        isDisplayed())))));

        view.check(matches(withViewAtPosition(position,
                hasDescendant(allOf(withId(id),
                        isDisplayed())))));

        view.check(matches(withViewAtPosition(position,
                hasDescendant(allOf(withId(id2),
                        isDisplayed())))));

    }

    public static ViewAction swipeFromCenterToTop() {
        return new CenterSwipeAction(Swipe.FAST,
                GeneralLocation.CENTER,
                new CoordinatesProvider() {
                    @Override
                    public float[] calculateCoordinates(View view) {
                        float[] coordinates = GeneralLocation.CENTER.calculateCoordinates(view);
                        coordinates[1] = 0;
                        return coordinates;
                    }
                },
                Press.FINGER);
    }


}
