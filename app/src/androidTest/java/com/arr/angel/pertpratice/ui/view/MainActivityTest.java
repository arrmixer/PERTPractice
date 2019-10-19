package com.arr.angel.pertpratice.ui.view;


import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.appcompat.widget.Toolbar;
import android.view.Gravity;

import com.arr.angel.pertpratice.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private IdlingResource mIdlingResource;

    @Before
    public void registerIdlingResource() {
        mIdlingResource = mActivityTestRule.getActivity().getIdlingResource();
        // To prove that the test fails, omit this call:
        IdlingRegistry.getInstance().register(mIdlingResource);
    }

    @Test
    public void clickOnYourNavigationItem_ShowsYourScreen() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.practice_test));

        registerIdlingResource();

        CharSequence title = InstrumentationRegistry
                .getTargetContext().getString(R.string.practice_test);
        matchToolbarTitle(title);

    }

    @Test
    public void clickOnYourNavigationItem_ShowsYourScreen2() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.basic));

        registerIdlingResource();

        CharSequence title = InstrumentationRegistry
                .getTargetContext().getString(R.string.basic);
        matchToolbarTitle(title);

    }

    @Test
    public void clickOnYourNavigationItem_ShowsYourScreen3() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.intermediate));

        registerIdlingResource();

        CharSequence title = InstrumentationRegistry
                .getTargetContext().getString(R.string.intermediate);
        matchToolbarTitle(title);

    }

    @Test
    public void clickOnYourNavigationItem_ShowsYourScreen4() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.advance));

        registerIdlingResource();

        CharSequence title = InstrumentationRegistry
                .getTargetContext().getString(R.string.advance);
        matchToolbarTitle(title);

    }

    @Test
    public void clickOnYourNavigationItem_ShowsYourScreen5() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.application));

        registerIdlingResource();

        CharSequence title = InstrumentationRegistry
                .getTargetContext().getString(R.string.application);
        matchToolbarTitle(title);

    }

    @Test
    public void clickOnYourNavigationItem_ShowsYourScreen6() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.overall_results));

        registerIdlingResource();

        CharSequence title = InstrumentationRegistry
                .getTargetContext().getString(R.string.overall_results);
        matchToolbarTitle(title);

    }

    // Remember to unregister resources when not needed to avoid malfunction.
    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(mIdlingResource);
        }
    }

    @Test public void toolbarTitle() {
        CharSequence title = InstrumentationRegistry
                .getTargetContext().getString(R.string.app_name);
        matchToolbarTitle(title);
    }

    private static ViewInteraction matchToolbarTitle(
            CharSequence title) {
        return onView(isAssignableFrom(Toolbar.class))
                .check(matches(withToolbarTitle(is(title))));
    }

    /*matcher used from the great @chiuki:
    http://chiuki.github.io/advanced-android-espresso/#/17
    https://www.youtube.com/watch?v=JlHJFZvZyxw#t=7m40s*/
    private static Matcher<Object> withToolbarTitle(
            final Matcher<CharSequence> textMatcher) {
        return new BoundedMatcher<Object, Toolbar>(Toolbar.class) {
            @Override public boolean matchesSafely(Toolbar toolbar) {
                return textMatcher.matches(toolbar.getTitle());
            }
            @Override public void describeTo(Description description) {
                description.appendText("with toolbar title: ");
                textMatcher.describeTo(description);
            }
        };
    }


}
