package com.arr.angel.pertpratice.ui.view;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class Question04DialogIntentTest {


    @Rule
    public IntentsTestRule<Question04Activity> mActivityRule = new IntentsTestRule<>(
            Question04Activity.class);

    @Before
    public void stubAllExternalIntents() {
        // By default Espresso Intents does not stub any Intents. Stubbing needs to be setup before
        // every test run. In this case all external Intents will be blocked.
        intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    //just a general check on the intent
    //keys and data sent from each question
    @Test
    public void checkIntentSentFromDialog() {

        MainFragmentIntentTest.checkIntentSentFromNextButtonInDialog(4);
    }


}
