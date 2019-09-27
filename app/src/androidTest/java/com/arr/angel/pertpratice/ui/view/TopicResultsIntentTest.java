package com.arr.angel.pertpratice.ui.view;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import androidx.annotation.StringRes;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.arr.angel.pertpratice.R;
import com.arr.angel.pertpratice.util.ResultsSharedPreferences;

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
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasType;
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
public class TopicResultsIntentTest {

    @Rule
    public IntentsTestRule<TopicResultsActivity> mTopicResultsActivity = new IntentsTestRule<>(
            TopicResultsActivity.class);

//    @Before
//    public void init() {
//        mTopicResultsActivity.getActivity().getSupportFragmentManager().beginTransaction();
//    }

    @Before
    public void stubAllExternalIntents() {
        // By default Espresso Intents does not stub any Intents. Stubbing needs to be setup before
        // every test run. In this case all external Intents will be blocked.
        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    @Test
    public void toolbarMenuIsDisplayedMainMenu() {
        onView(withMenuIdOrText(R.id.main_settings, R.string.main_page)).perform(click());

        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.MainActivity")));
    }

    @Test
    public void toolbarMenuIsDisplayedRetake() {
        onView(withMenuIdOrText(R.id.retake_settings, R.string.retake)).perform(click());

        intended(AllOf.allOf(
                hasExtraWithKey(MainFragment.EXTRA_TOPIC_ID))
        );

        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question01Activity")));

    }

    //all intent tests will only pass if user has
    //not taken/answered the question
    //if the question is already answered then the tests will fail
    //this is because the click listener is active if and only if
    //the question is not answered

    @Test
    public void intentOnRecyclerViewItemHasExtras1() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        questionAnsweredOrNot(recyclerView, R.string.not_taken,
                0, R.string.question1, MainFragment.EXTRA_TOPIC_ID,
                "com.arr.angel.pertpratice.ui.view.Question01Activity");


    }

    @Test
    public void intentOnRecyclerViewItemHasExtras2() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        questionAnsweredOrNot(recyclerView, R.string.not_taken,
                1, R.string.question2, MainFragment.EXTRA_TOPIC_ID,
                "com.arr.angel.pertpratice.ui.view.Question02Activity");


    }

    @Test
    public void intentOnRecyclerViewItemHasExtras3() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        questionAnsweredOrNot(recyclerView, R.string.not_taken, 2,
                R.string.question3, MainFragment.EXTRA_TOPIC_ID,
                "com.arr.angel.pertpratice.ui.view.Question03Activity");


    }

    @Test
    public void intentOnRecyclerViewItemHasExtras4() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        questionAnsweredOrNot(recyclerView, R.string.not_taken, 3,
                R.string.question4, MainFragment.EXTRA_TOPIC_ID,
                "com.arr.angel.pertpratice.ui.view.Question04Activity");


    }

    @Test
    public void intentOnRecyclerViewItemHasExtras5() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        questionAnsweredOrNot(recyclerView, R.string.not_taken, 4,
                R.string.question5, MainFragment.EXTRA_TOPIC_ID,
                "com.arr.angel.pertpratice.ui.view.Question05Activity");


    }

    @Test
    public void intentOnRecyclerViewItemHasExtras6() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        questionAnsweredOrNot(recyclerView, R.string.not_taken, 5,
                R.string.question6, MainFragment.EXTRA_TOPIC_ID,
                "com.arr.angel.pertpratice.ui.view.Question06Activity"
        );


    }

    //test on twitter icon
    //make sure correct action is sent
    @Test
    public void intentOnTwitterShare() {
        ViewInteraction fab = onView(withId(R.id.floatingActionButton));
        fab.check(matches(isDisplayed()));
        fab.perform(click());

        onView(withId(R.id.img_twitter)).perform(click());

        intended(AllOf.allOf(hasAction(Intent.ACTION_VIEW)));


    }

    //test on message icon
    //make sure correct message, type, and action is sent
    @Test
    public void intentOnGeneralShare() {
        ViewInteraction fab = onView(withId(R.id.floatingActionButton));
        fab.check(matches(isDisplayed()));
        fab.perform(click());

        //make message that would be sent
        //results are saved in saved preferences
        String message = "Hey I'm building my confidence with PERTPractice! I got a "
                + ResultsSharedPreferences.getPrefTopicPercentage(mTopicResultsActivity.getActivity().getApplicationContext());

        onView(withId(R.id.img_message)).perform(click());
        intended(AllOf.allOf(hasAction(Intent.ACTION_SEND)));
        intended(AllOf.allOf(hasType("text/plain")));
        intended(AllOf.allOf(hasExtra(Intent.EXTRA_TEXT, message)));

    }


    //verify "n/a" is displayed if question is not answer
    //then check the correct intent with class is sent
    public static void questionAnsweredOrNot(ViewInteraction viewInteraction, @StringRes int notTake, int position, @StringRes int question, String intentKey, String className) {

        viewInteraction.check(matches(withViewAtPosition(position,
                hasDescendant(allOf(withText(notTake),
                        isDisplayed()))))).perform(RecyclerViewActions.actionOnItemAtPosition(position, click()));

        intended(AllOf.allOf(
                hasExtraWithKey(intentKey))
        );

        intended(AllOf.allOf(hasComponent(className)));

    }


}
