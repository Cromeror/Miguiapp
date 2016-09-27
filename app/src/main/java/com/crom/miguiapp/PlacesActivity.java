package com.crom.miguiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.crom.miguiapp.place.Place;
import com.crom.miguiapp.place.PlaceListRecyclerAdapter;
import com.crom.miguiapp.place.PlacesDataProvider;

import java.util.List;

public class PlacesActivity extends AppCompatActivity {

    private RecyclerView placesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        placesListView = (RecyclerView) findViewById(R.id.placesListRecyclerView);
        List<Place> placesList = PlacesDataProvider.getPlaces();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        placesListView.setLayoutManager(layoutManager);

        PlaceListRecyclerAdapter adapter = new PlaceListRecyclerAdapter(placesList);
        placesListView.setAdapter(adapter);
    }
}
