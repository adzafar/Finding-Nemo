package com.flipkart.adeelzafar.finding_nemo;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

/**
 * Created by saurabh.agrawal on 08/08/14.
 */
public class ProximityNotification {

    private static final int NOTIFY_ID = 1;

    public static void show(Context context, CharSequence notifyText) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(android.R.drawable.stat_sys_warning)
                        .setContentTitle(context.getResources().getString(R.string.app_name))
                        .setContentText(notifyText);


        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        mNotificationManager.notify(NOTIFY_ID, mBuilder.build());
    }
}
