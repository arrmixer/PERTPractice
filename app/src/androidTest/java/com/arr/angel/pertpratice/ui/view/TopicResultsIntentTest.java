package com.arr.angel.pertpratice.ui.view;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.annotation.StringRes;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.arr.angel.pertpratice.R;

import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
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
    public void toolbarMenuIsDisplayedMainMenu(){
        onView(withMenuIdOrText(R.id.main_settings, R.string.main_page)).perform(click());

        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.MainActivity")));
    }

    @Test
    public void toolbarMenuIsDisplayedRetake(){
        onView(withMenuIdOrText(R.id.retake_settings, R.string.retake)).perform(click());

        intended(AllOf.allOf(
                hasExtraWithKey(MainFragment.EXTRA_TOPIC_ID))
        );

        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question01Activity")));

    }

    @Test
    public void intentOnRecyclerViewItemHasExtras1(){
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        questionAnsweredOrNot(recyclerView, R.string.not_taken, 0, R.string.question1);


        intended(AllOf.allOf(
                hasExtraWithKey(MainFragment.EXTRA_TOPIC_ID))
        );

        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question01Activity")));


    }
    @Test
    public void intentOnRecyclerViewItemHasExtras2(){
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        questionAnsweredOrNot(recyclerView, R.string.not_taken, 1, R.string.question2);


        intended(AllOf.allOf(
                hasExtraWithKey(MainFragment.EXTRA_TOPIC_ID))
        );

        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question02Activity")));

    }
    @Test
    public void intentOnRecyclerViewItemHasExtras3(){
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        questionAnsweredOrNot(recyclerView, R.string.not_taken, 2, R.string.question3);


        intended(AllOf.allOf(
                hasExtraWithKey(MainFragment.EXTRA_TOPIC_ID))
        );

        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question03Activity")));


    }
    @Test
    public void intentOnRecyclerViewItemHasExtras4(){
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        questionAnsweredOrNot(recyclerView, R.string.not_taken, 3, R.string.question4);


        intended(AllOf.allOf(
                hasExtraWithKey(MainFragment.EXTRA_TOPIC_ID))
        );

        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question04Activity")));


    }
    @Test
    public void intentOnRecyclerViewItemHasExtras5(){
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        questionAnsweredOrNot(recyclerView, R.string.not_taken, 4, R.string.question5);


        intended(AllOf.allOf(
                hasExtraWithKey(MainFragment.EXTRA_TOPIC_ID))
        );

        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question05Activity")));


    }
    @Test
    public void intentOnRecyclerViewItemHasExtras6(){
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        questionAnsweredOrNot(recyclerView, R.string.not_taken, 5, R.string.question6);


        intended(AllOf.allOf(
                hasExtraWithKey(MainFragment.EXTRA_TOPIC_ID))
        );

        intended(AllOf.allOf(hasComponent("com.arr.angel.pertpratice.ui.view.Question06Activity")));


    }



    //just checking is the question is not answered if so then click
    //to check for intent data otherwise just make sure question correct
    //question is displayed
    public static void questionAnsweredOrNot(ViewInteraction viewInteraction, @StringRes int notTake, int position, @StringRes int question){

        try{
            viewInteraction.check(matches(withViewAtPosition(position,
                    hasDescendant(allOf(withText(notTake),
                            isDisplayed()))))).perform(RecyclerViewActions.actionOnItemAtPosition(position, click()));
        }catch (AssertionError e){
            viewInteraction.check(matches(withViewAtPosition(position,
                    hasDescendant(allOf(withText(question),
                            isDisplayed())))));
        }
    }


}
