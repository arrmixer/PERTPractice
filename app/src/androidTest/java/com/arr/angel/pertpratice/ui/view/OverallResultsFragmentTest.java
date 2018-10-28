package com.arr.angel.pertpratice.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.arr.angel.pertpratice.ui.view.TopicResultsFragmentTest.withMenuIdOrText;
import static com.arr.angel.pertpratice.ui.view.TopicResultsFragmentTest.withViewAtPosition;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class OverallResultsFragmentTest {

    @Rule
    public ActivityTestRule<OverallTopicResultsActivity> mOverallResultsActivityTestRule = new ActivityTestRule<>(OverallTopicResultsActivity.class);

    @Before
    public void init() {
        mOverallResultsActivityTestRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void recyclerViewIsPresent() {

        ViewInteraction recyclerView = onView(
                withId(R.id.recycler_view_overall_results));

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


        recyclerView.check(matches(withViewAtPosition(3,
                hasDescendant(allOf(withText(R.string.advance),
                        isDisplayed())))));


        recyclerView.check(matches(withViewAtPosition(4,
                hasDescendant(allOf(withText(R.string.application),
                        isDisplayed())))));


    }

    @Test
    public void resultsTextViewsPresent(){
        onView(withId(R.id.textView_overall_results_description)).check(matches(isDisplayed()));
    }

    @Test public void toolbarTitle() {
        CharSequence title = InstrumentationRegistry
                .getTargetContext().getString(R.string.overall_results);
        matchToolbarTitle(title);
    }

    @Test
    public void toolbarMenuIsDisplayed(){
        onView(withMenuIdOrText(R.id.main_settings, R.string.main_page)).check(matches(isDisplayed()));
    }

    @Test
    public void fab(){
        onView(withId(R.id.floatingActionButton)).check(matches(isDisplayed()));
    }

    private static ViewInteraction matchToolbarTitle(
            CharSequence title) {
        return onView(isAssignableFrom(Toolbar.class))
                .check(matches(withToolbarTitle(is(title))));
    }

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
