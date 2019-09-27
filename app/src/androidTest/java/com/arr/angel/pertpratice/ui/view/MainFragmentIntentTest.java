package com.arr.angel.pertpratice.ui.view;

import android.app.Activity;
import android.app.Instrumentation;
import androidx.annotation.IdRes;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import android.view.View;

import com.arr.angel.pertpratice.R;

import org.hamcrest.Matcher;
import org.hamcrest.core.AllOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
import static androidx.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.arr.angel.pertpratice.ui.view.MainFragment.EXTRA_CURRENT_QUESTION_ID;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNot.not;

public class MainFragmentIntentTest {

    private IdlingResource mIdlingResource;

    private String classNameQuestion01 = "com.arr.angel.pertpratice.ui.view.Question01Activity";

    private String classNameTopicResults = "com.arr.angel.pertpratice.ui.view.TopicResultsActivity";

    @Rule
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<>(
            MainActivity.class);

    @Before
    public void init() {
        mActivityRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Before
    public void stubAllExternalIntents() {
        // By default Espresso Intents does not stub any Intents. Stubbing needs to be setup before
        // every test run. In this case all external Intents will be blocked.
        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    //the following tests check the intents sent on
    //all the buttons in each recycler view item
    //the two buttons are practice and results

    @Test
    public void recyclerViewItemPracticeButtonIntentHasExtras() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        // checks intent sent to QuestionActivity
        checkIntentSentInButton(
                recyclerView,
                R.id.buttonPractice,
                0, 0,
                MainFragment.EXTRA_TOPIC_ID,
                classNameQuestion01);

        //checks intent sent from Dialog of first question only
        checkIntentSentFromNextButtonInDialog(1);


    }

    @Test
    public void recyclerViewItemPracticeButtonIntentHasExtras1() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        // checks intent sent to QuestionActivity
        checkIntentSentInButton(
                recyclerView,
                R.id.buttonPractice,
                1, 1,
                MainFragment.EXTRA_TOPIC_ID,
                classNameQuestion01);

        //checks intent sent from Dialog of first question only
        checkIntentSentFromNextButtonInDialog(1);

    }

    @Test
    public void recyclerViewItemPracticeButtonIntentHasExtras2() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        // checks intent sent to QuestionActivity
        checkIntentSentInButton(
                recyclerView,
                R.id.buttonPractice,
                2, 2,
                MainFragment.EXTRA_TOPIC_ID,
                classNameQuestion01);

        //checks intent sent from Dialog of first question only
        checkIntentSentFromNextButtonInDialog(1);

    }

    @Test
    public void recyclerViewItemPracticeButtonIntentHasExtras3() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        // checks intent sent to QuestionActivity
        checkIntentSentInButton(
                recyclerView,
                R.id.buttonPractice,
                3, 3,
                MainFragment.EXTRA_TOPIC_ID,
                classNameQuestion01);

    }

    @Test
    public void recyclerViewItemPracticeButtonIntentHasExtras4() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        // checks intent sent to QuestionActivity
        checkIntentSentInButton(
                recyclerView,
                R.id.buttonPractice,
                4, 4,
                MainFragment.EXTRA_TOPIC_ID,
                classNameQuestion01);

        //checks intent sent from Dialog of first question only
        checkIntentSentFromNextButtonInDialog(1);

    }

    @Test
    public void recyclerViewItemResultsButtonIntentHasExtras() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        checkIntentSentInButton(
                recyclerView,
                R.id.buttonResults,
                0, 0,
                MainFragment.EXTRA_TOPIC_ID,
                classNameTopicResults);


    }

    @Test
    public void recyclerViewItemResultsButtonIntentHasExtras1() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        checkIntentSentInButton(
                recyclerView,
                R.id.buttonResults,
                1, 1,
                MainFragment.EXTRA_TOPIC_ID,
                classNameTopicResults);


    }

    @Test
    public void recyclerViewItemResultsButtonIntentHasExtras2() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        checkIntentSentInButton(
                recyclerView,
                R.id.buttonResults,
                2, 2,
                MainFragment.EXTRA_TOPIC_ID,
                classNameTopicResults);

    }

    @Test
    public void recyclerViewItemResultsButtonIntentHasExtras3() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        checkIntentSentInButton(
                recyclerView,
                R.id.buttonResults,
                3, 3,
                MainFragment.EXTRA_TOPIC_ID,
                classNameTopicResults);

    }

    @Test
    public void recyclerViewItemResultsButtonIntentHasExtras4() {
        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topics));

        checkIntentSentInButton(
                recyclerView,
                R.id.buttonResults,
                4, 4,
                MainFragment.EXTRA_TOPIC_ID,
                classNameTopicResults);

    }


    // Remember to unregister resources when not needed to avoid malfunction.
    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(mIdlingResource);
        }
    }


    //helper method to check the practice buttons
    //in each topic card. verify correct key,
    // , topicId, and correct class was sent
    public void checkIntentSentInButton(ViewInteraction view, @IdRes int id, int position, int topicId, String key, String className) {

        //get position, correct button, and click on it
        view.perform(RecyclerViewActions.actionOnItemAtPosition(position, clickChildViewWithId(id)));

        //check intent key  and day was sent
        intended(AllOf.allOf(
                hasExtra(key, topicId))
        );

        intended(AllOf.allOf(hasComponent(className)));

    }


    //helper method to check if the dialog next
    //button sends the correct intent keys and data
    public static void checkIntentSentFromNextButtonInDialog(@IdRes int id) {

        //get radio button and click on it
        onView(withId(R.id.radioButton)).perform(click());

        onView(withText(R.string.dialog_next)).perform(click());

        //check intent data and keys
        intended(allOf(
                hasExtra(CorrectAnswerDialogFragment.EXTRA_IS_ANSWERED, true))
        );

        intended(allOf(
                hasExtraWithKey(CorrectAnswerDialogFragment.EXTRA_IS_CORRECT))
        );

        intended(allOf(
                hasExtra(EXTRA_CURRENT_QUESTION_ID, id))
        );


    }

    // great helper method used to click on child in
    // recycler View item credit: https://stackoverflow.com/a/30338665/5104935
    public static ViewAction clickChildViewWithId(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(id);
                v.performClick();
            }
        };
    }


}
