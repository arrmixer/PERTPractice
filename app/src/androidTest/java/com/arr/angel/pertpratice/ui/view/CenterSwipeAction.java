package com.arr.angel.pertpratice.ui.view;

import android.support.test.espresso.PerformException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.CoordinatesProvider;
import android.support.test.espresso.action.PrecisionDescriber;
import android.support.test.espresso.action.Swiper;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.espresso.util.HumanReadables;
import android.view.View;
import android.view.ViewConfiguration;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;

/*helper class to mimic swiping on screen had to use because
* recycler view actions didn't work properly in a coordinator layout
* credit https://stackoverflow.com/a/43724594/5104935*/


public class CenterSwipeAction implements ViewAction {

    private final Swiper swiper;
    private final CoordinatesProvider startCoordProvide;
    private final CoordinatesProvider endCoordProvide;
    private final PrecisionDescriber precDesc;

    public CenterSwipeAction(Swiper swiper, CoordinatesProvider startCoordProvide,
                             CoordinatesProvider endCoordProvide, PrecisionDescriber precDesc) {
        this.swiper = swiper;
        this.startCoordProvide = startCoordProvide;
        this.endCoordProvide = endCoordProvide;
        this.precDesc = precDesc;
    }

    @Override public Matcher<View> getConstraints() {
        return withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE);
    }

    @Override public String getDescription() {
        return "swipe from middle of screen";
    }

    @Override
    public void perform(UiController uiController, View view) {
        float[] startCoord = startCoordProvide.calculateCoordinates(view);
        float[] finalCoord = endCoordProvide.calculateCoordinates(view);
        float[] precision =  precDesc.describePrecision();

        // you could try this for several times until Swiper.Status is achieved or try count is reached
        try {
            swiper.sendSwipe(uiController, startCoord, finalCoord, precision);
        } catch (RuntimeException re) {
            throw new PerformException.Builder()
                    .withActionDescription(this.getDescription())
                    .withViewDescription(HumanReadables.describe(view))
                    .withCause(re)
                    .build();
        }

        // ensures that the swipe has been run.
        uiController.loopMainThreadForAtLeast(ViewConfiguration.getPressedStateDuration());
    }


}
