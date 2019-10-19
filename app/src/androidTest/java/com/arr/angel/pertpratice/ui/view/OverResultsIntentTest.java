package com.arr.angel.pertpratice.ui.view;

import android.app.Activity;
import android.app.Instrumentation;
import androidx.annotation.StringRes;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.arr.angel.pertpratice.R;

import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.arr.angel.pertpratice.ui.view.TopicResultsFragmentTest.withMenuIdOrText;
import static com.arr.angel.pertpratice.ui.view.TopicResultsFragmentTest.withViewAtPosition;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class OverResultsIntentTest {
    @Rule
    public IntentsTestRule<OverallTopicResultsActivity> mOverallTopicResultsActivity = new IntentsTestRule<>(
            OverallTopicResultsActivity.class);

    @Before
    public void stubAllExternalIntents() {
        // By default Espresso Intents does not stub any Intents. Stubbing needs to be setup before
        // every test run. In this case all external Intents will be blocked.
        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    @Test
    public void intentOnRecyclerViewItemHasExtras1(){
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_overall_results));
        //recyclerView.check(matches(withViewAtPosition(0,
        //        hasDescendant(allOf(withText(R.string.practice_test),
        //                isDisplayed()))))).perform(click());
        //
        //questionClicked(recyclerView, R.string.practice_test, 0);
        //
        //
        //intended(AllOf.allOf(hasExtra(MainFragment.EXTRA_TOPIC_ID, 0)));

        //        only pass if question is not already answered
//        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question01Activity")));

    }

    @Test
    public void intentOnRecyclerViewItemHasExtras2(){
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_overall_results));
//        recyclerView.check(matches(withViewAtPosition(0,
////                hasDescendant(allOf(withText(R.string.practice_test),
////                        isDisplayed()))))).perform(click());

        questionClicked(recyclerView, R.string.basic, 1);


        intended(AllOf.allOf(hasExtra(MainFragment.EXTRA_TOPIC_ID,1)));

//        only pass if question is not already answered
//        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question01Activity")));

    }

    @Test
    public void intentOnRecyclerViewItemHasExtras3(){
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_overall_results));
//        recyclerView.check(matches(withViewAtPosition(0,
////                hasDescendant(allOf(withText(R.string.practice_test),
////                        isDisplayed()))))).perform(click());

        questionClicked(recyclerView, R.string.intermediate, 2);

        intended(AllOf.allOf(hasExtra(MainFragment.EXTRA_TOPIC_ID, 2)));

        //        only pass if question is not already answered
//        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question01Activity")));
    }

    @Test
    public void intentOnRecyclerViewItemHasExtras4(){
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_overall_results));
//        recyclerView.check(matches(withViewAtPosition(0,
////                hasDescendant(allOf(withText(R.string.practice_test),
////                        isDisplayed()))))).perform(click());

        questionClicked(recyclerView, R.string.advance, 3);


        intended(AllOf.allOf(hasExtra(MainFragment.EXTRA_TOPIC_ID, 3)));

        //        only pass if question is not already answered
//        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question01Activity")));
    }

    @Test
    public void intentOnRecyclerViewItemHasExtras5(){
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_overall_results));
//        recyclerView.check(matches(withViewAtPosition(0,
////                hasDescendant(allOf(withText(R.string.practice_test),
////                        isDisplayed()))))).perform(click());

        questionClicked(recyclerView, R.string.application, 4);


        intended(AllOf.allOf(hasExtra(MainFragment.EXTRA_TOPIC_ID, 4)));

        //        only pass if question is not already answered
//        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question01Activity")));

    }

    @Test
    public void toolbarMenuIsDisplayed(){
        onView(withMenuIdOrText(R.id.main_settings, R.string.main_page)).perform(click());

        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.MainActivity")));
    }


    public static void questionClicked(ViewInteraction viewInteraction, @StringRes int topic, int position){

            viewInteraction.check(matches(withViewAtPosition(position,
                    hasDescendant(allOf(withText(topic),
                            isDisplayed()))))).perform(RecyclerViewActions.actionOnItemAtPosition(position, click()));

    }
}
