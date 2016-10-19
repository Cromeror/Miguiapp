package com.crom.miguiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crom.miguiapp.place.PlacesDataProvider;
import com.crom.miguiapp.pojo.Place;
import com.crom.miguiapp.service.ControllerMediaPlayerService;

public class PlaceDetailActivity extends AppCompatActivity {
    public final static String ARG_INDEX = "com.crom.miguiapp.PlaceDetailActivity.index";
    private Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);
        /*if (getIntent().getIntExtra(ARG_INDEX, 0) > 0) {
            loadDetail(getIntent().getIntExtra(ARG_INDEX, 0));
        }*/
    }

    private void loadDetail(int intExtra) {
        this.place = PlacesDataProvider.getPlaces().get(intExtra);
        TextView title = (TextView) findViewById(R.id.title_detail);
        TextView description = (TextView) findViewById(R.id.description_detail);
        ImageView imagen = (ImageView) findViewById(R.id.image_detail);

        title.setText(place.getNombre());
        description.setText(place.getDescripcion());
        imagen.setImageResource(place.getImageResourse());
    }

    public void playAction(View view) {
        if (place.getAudioResource() != null) {
            ControllerMediaPlayerService.getInstance().initService(this, place.getAudioResource());
        }
    }

    public void goMapAction(View view) {
        Intent intent = new Intent(PlaceDetailActivity.this, MapsActivity.class);
        intent.putExtra(MapsActivity.POSITION_LAT, place.getLandmark().getLatLng().latitude);
        intent.putExtra(MapsActivity.POSITION_LON, place.getLandmark().getLatLng().longitude);
        startActivity(intent);
    }
}
