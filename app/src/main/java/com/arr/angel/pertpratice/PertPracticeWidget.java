package com.arr.angel.pertpratice;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

import com.arr.angel.pertpratice.ui.view.MainActivity;

/**
 * Implementation of App Widget functionality.
 */
public class PertPracticeWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        Bundle options = appWidgetManager.getAppWidgetOptions(appWidgetId);
        int width = options.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);
        RemoteViews remoteView;
        if (width < 100) {
            remoteView = getViewForSmallerWidget(context);
        } else {
            remoteView = getViewForBiggerWidget(context);
        }
        appWidgetManager.updateAppWidget(appWidgetId, remoteView);

    }

    private static RemoteViews getViewForBiggerWidget(Context context) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_result_percentage);

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.textView_widget_result, pendingIntent);

        return views;
    }

    private static RemoteViews getViewForSmallerWidget(Context context) {

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_simple);

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.widgetImageView, pendingIntent);

        return views;

    }




    public static void updateAllAppWidget(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        WidgetUpdateService.startActionUpdateAppWidgets(context);

    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager,
                                          int appWidgetId, Bundle newOptions) {
        WidgetUpdateService.startActionUpdateAppWidgets(context);
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

