package com.crom.miguiapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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
        MediaPlayerService myService;
        //lol
        ServiceConnection myConnection = new ServiceConnection() {
            public void onServiceConnected(ComponentName className, IBinder binder) {
                Log.d("ServiceConnection","connected");
                //myService = binder;
            }
            //binder comes from server to communicate with method's of

            public void onServiceDisconnected(ComponentName className) {
                Log.d("ServiceConnection","disconnected");
                //myService = null;
            }
        };

        Intent intent = new Intent(PlacesActivity.this, MediaPlayerService.class);
       // bindService(intent, myConnection, Context.BIND_AUTO_CREATE );
        startService(intent);
    }

    /**
     * Go
     * @param view
     */
    public void goMapAction(View view){
        Intent intent = new Intent(PlacesActivity.this, MapsActivity.class);
        startActivity(intent);
    }
}
