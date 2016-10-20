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

}
