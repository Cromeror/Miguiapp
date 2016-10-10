package com.crom.miguiapp.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.crom.miguiapp.service.MediaPlayerService.MediaPlayerBinder;

/**
 * Created by Cristóbal Romero
 * <https://github.com/Cromeror>
 * on 03/10/2016.
 */
public class ControllerMediaPlayerService {

    private static ServiceConnection serviceConnection;
    private static ControllerMediaPlayerService instance;
    private MediaPlayerBinder mediaPlayerBinder;
    private MediaPlayerService mediaPlayerService;
    private Activity activity;
    private boolean connected = false;

    private ControllerMediaPlayerService(){

        serviceConnection = new ServiceConnection() {

            public void onServiceConnected(ComponentName className, IBinder service) {
                mediaPlayerBinder = (MediaPlayerBinder) service;
                mediaPlayerService = mediaPlayerBinder.getService();
                connected = true;
            }

            public void onServiceDisconnected(ComponentName className) {
                connected = false;
            }
        };
    }

    public static ControllerMediaPlayerService getInstance() {
        if(instance == null)
            instance = new ControllerMediaPlayerService();


        return instance;
    }

    public void playMediaPlayer(){
        mediaPlayerService.audioPlay();
    }

    public void pauseMediaPlayer(){
        mediaPlayerService.audioPause();
    }

    public void initService(Activity activity){
        this.activity = activity;
        Intent intent = new Intent(activity, MediaPlayerService.class);
        activity.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public boolean isConnected() {
        return connected;
    }
}
