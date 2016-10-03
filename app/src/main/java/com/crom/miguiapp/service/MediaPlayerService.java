package com.crom.miguiapp.service;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.crom.miguiapp.PlacesActivity;
import com.crom.miguiapp.R;


public class MediaPlayerService extends Service implements MediaPlayer.OnPreparedListener{

    private final IBinder mBinder = new MediaPlayerBinder();

    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {

        super.onCreate();

        mediaPlayer = MediaPlayer.create(this, R.raw.aerosmith_crazy);

        mediaPlayer.setOnPreparedListener(this);

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);

    }

    public void audioPlay(){

        mediaPlayer.start();

    }

    public void audioPause(){

        mediaPlayer.pause();

    }

    @Override
    public void onDestroy() {

        mediaPlayer.stop();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return mBinder;

    }
    private void getNotification(){

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_play_dark)
                        .setContentTitle(getString(R.string.notify_title))
                        .setContentText("Hello World!");

        Intent resultIntent = new Intent(this, PlacesActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        stackBuilder.addParentStack(PlacesActivity.class);

        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(0, mBuilder.build());

    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

        mediaPlayer.start();

    }

    public class MediaPlayerBinder extends Binder {

        /**
         * Return this instance of LocalService so clients can call public methods
         * @return
         */
        public MediaPlayerService getService() {
            return MediaPlayerService.this;
        }
    }
}