package com.crom.miguiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.crom.miguiapp.place.Place;
import com.crom.miguiapp.place.PlaceAdapter;
import com.crom.miguiapp.place.PlacesDataProvider;

import java.util.List;

public class PlacesActivity extends AppCompatActivity {

    private ListView placesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        placesListView = (ListView) findViewById(R.id.placesListView);
        List<Place> placesList = PlacesDataProvider.getPlaces();
        PlaceAdapter adapter = new PlaceAdapter(placesList, getApplicationContext());
        placesListView.setAdapter(adapter);
    }
}
