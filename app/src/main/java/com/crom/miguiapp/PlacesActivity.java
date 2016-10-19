package com.crom.miguiapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.crom.miguiapp.pojo.Place;
import com.crom.miguiapp.place.PlaceListRecyclerAdapter;
import com.crom.miguiapp.place.PlacesDataProvider;
import com.crom.miguiapp.service.ControllerMediaPlayerService;

import java.util.List;

public class PlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        RecyclerView placesListView = (RecyclerView) findViewById(R.id.placesListRecyclerView);

        List<Place> placesList = PlacesDataProvider.getPlaces();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        placesListView.setLayoutManager(layoutManager);
        PlaceListRecyclerAdapter adapter = new PlaceListRecyclerAdapter(placesList);
        placesListView.setAdapter(adapter);

    }



    public void notificationMediaPlayer(String title, String text){

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_play_dark)
                .setContentTitle(title)
                .setContentText(text);

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
}
