package com.arr.angel.pertpratice.ui.view;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.annotation.IdRes;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.view.Gravity;

import com.arr.angel.pertpratice.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNot.not;


public class QuestionActivityIntentTest {

    @Rule
    public IntentsTestRule<Question01Activity> mActivityRule = new IntentsTestRule<>(
            Question01Activity.class);

    @Before
    public void stubAllExternalIntents() {
        // By default Espresso Intents does not stub any Intents. Stubbing needs to be setup before
        // every test run. In this case all external Intents will be blocked.
        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    @Test
    public void intentNavItemHasExtras() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        // though the user sees a different title it is still the same id
        // for the first item

        checkIntentsFromNavMenu(
                R.id.nav_view,
                R.id.practice_test,
                MainFragment.EXTRA_TOPIC_ID,
                "com.arr.angel.pertpratice.ui.view.Question01Activity");

    }

    @Test
    public void intentNavItemHasExtras2() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        // though the user sees a different title it is still the same id
        // for the first item

        checkIntentsFromNavMenu(
                R.id.nav_view,
                R.id.basic,
                MainFragment.EXTRA_TOPIC_ID,
                "com.arr.angel.pertpratice.ui.view.Question02Activity");

    }

    @Test
    public void intentNavItemHasExtras3() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        // though the user sees a different title it is still the same id
        // for the first item

        checkIntentsFromNavMenu(
                R.id.nav_view,
                R.id.intermediate,
                MainFragment.EXTRA_TOPIC_ID,
                "com.arr.angel.pertpratice.ui.view.Question03Activity");

    }

    @Test
    public void intentNavItemHasExtras4() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        // though the user sees a different title it is still the same id
        // for the first item

        checkIntentsFromNavMenu(
                R.id.nav_view,
                R.id.advance,
                MainFragment.EXTRA_TOPIC_ID,
                "com.arr.angel.pertpratice.ui.view.Question04Activity");

    }

    @Test
    public void intentNavItemHasExtras5() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        // though the user sees a different title it is still the same id
        // for the first item

        checkIntentsFromNavMenu(
                R.id.nav_view,
                R.id.application,
                MainFragment.EXTRA_TOPIC_ID,
                "com.arr.angel.pertpratice.ui.view.Question05Activity");

    }

    @Test
    public void intentNavItemHasExtras6() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        // though the user sees a different title it is still the same id
        // for the first item

        checkIntentsFromNavMenu(
                R.id.nav_view,
                R.id.overall_results,
                MainFragment.EXTRA_TOPIC_ID,
                "com.arr.angel.pertpratice.ui.view.Question06Activity");

    }


    public static void checkIntentsFromNavMenu(@IdRes int navId, @IdRes int itemId, String key, String className) {
        onView(withId(navId)).perform(NavigationViewActions.navigateTo(itemId));

        intended(allOf(
                hasExtraWithKey(key))
        );

        intended(allOf(
                hasComponent(className))
        );
    }


}
