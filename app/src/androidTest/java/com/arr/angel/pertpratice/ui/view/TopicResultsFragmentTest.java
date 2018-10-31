package com.arr.angel.pertpratice.ui.view;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.constraint.ConstraintLayout;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arr.angel.pertpratice.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class TopicResultsFragmentTest {

    @Rule
    public ActivityTestRule<TopicResultsActivity> mTopicResultsActivityActivityTestRule = new ActivityTestRule<>(TopicResultsActivity.class);

    @Before
    public void init() {
        mTopicResultsActivityActivityTestRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void resultsTextViewsPresent() {
        onView(withId(R.id.textView_topic_total_results_title)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_topic_total_results_percentage)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_topic_total_results_description)).check(matches(isDisplayed()));
    }


    @Test
    public void recyclerViewIsPresent() {

        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_topic_results));

        recyclerView.check(matches(isDisplayed()));


        recyclerView.check(matches(withViewAtPosition(0,
                hasDescendant(allOf(withText(R.string.question1),
                        isDisplayed())))));

        recyclerView.check(matches(withViewAtPosition(1,
                hasDescendant(allOf(withText(R.string.question2),
                        isDisplayed())))));

        recyclerView.check(matches(withViewAtPosition(2,
                hasDescendant(allOf(withText(R.string.question3),
                        isDisplayed())))));


        recyclerView.check(matches(withViewAtPosition(3,
                hasDescendant(allOf(withText(R.string.question4),
                        isDisplayed())))));


        recyclerView.check(matches(withViewAtPosition(4,
                hasDescendant(allOf(withText(R.string.question5),
                        isDisplayed())))));

        recyclerView.check(matches(withViewAtPosition(5,
                hasDescendant(allOf(withText(R.string.question6),
                        isDisplayed())))));


    }


    @Test
    public void toolbarMenuIsDisplayedItem() {
        onView(withMenuIdOrText(R.id.main_settings, R.string.main_page)).check(matches(isDisplayed()));
//        onView(withMenuIdOrText(R.id.retake_settings, R.string.retake)).check(matches(isDisplayed()));
    }

    @Test
    public void toolbarMenuIsDisplayedItem2() {
//        onView(withMenuIdOrText(R.id.main_settings, R.string.main_page)).check(matches(isDisplayed()));
        onView(withMenuIdOrText(R.id.retake_settings, R.string.retake)).check(matches(isDisplayed()));
    }

    @Test
    public void fab(){
       ViewInteraction fab = onView(withId(R.id.floatingActionButton));
       fab.check(matches(isDisplayed()));
       fab.perform(click());

       onView(isAssignableFrom(ConstraintLayout.class)).check(matches(isDisplayed()));

       onView(withText(R.string.share_success)).check(matches(isDisplayed()));
       onView(withId(R.id.img_twitter)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.img_message)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_twitter_title)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_message_title)).check(matches(isDisplayed()));

//        onView(withId(R.id.img_twitter)).check(matches(isDisplayed())).perform(click());
    }

    public static Matcher<View> withViewAtPosition(final int position, final Matcher<View> itemMatcher) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) {
                itemMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(RecyclerView recyclerView) {

                final RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(position);
                return viewHolder != null && itemMatcher.matches(viewHolder.itemView);
            }
        };
    }

    public static Matcher<View> withMenuIdOrText(@IdRes int id, @StringRes int menuText) {
        Matcher<View> matcher = withId(id);
        try {
            onView(matcher).check(matches(isDisplayed()));
            return matcher;
        } catch (Exception NoMatchingViewException) {
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext());
            return withText(menuText);
        }
    }


}
