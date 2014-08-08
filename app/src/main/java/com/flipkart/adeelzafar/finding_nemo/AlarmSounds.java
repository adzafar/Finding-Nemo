package com.flipkart.adeelzafar.finding_nemo;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by saurabh.agrawal on 08/08/14.
 */
public class AlarmSounds {

    public static final int RED_ALERT = 0;
    public static final int YELLOW_ALERT = 1;
    public static final int ORANGE_ALERT = 2;

    public static void play(Context context, int alertType) {
        int resId;
        switch (alertType) {
            case RED_ALERT:
                resId = R.raw.sound_file_1;
                break;
            case YELLOW_ALERT:
                resId = R.raw.sound_file_2;
                break;
            case ORANGE_ALERT:
                resId = R.raw.sound_file_3;
                break;
            default:
                resId = R.raw.sound_file_1;
        }

        MediaPlayer mediaPlayer = MediaPlayer.create(context, resId);
        if (mediaPlayer != null) {
            mediaPlayer.start(); // no need to call prepare(); create() does that for you

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.reset();
                }
            });

        }
    }
}
