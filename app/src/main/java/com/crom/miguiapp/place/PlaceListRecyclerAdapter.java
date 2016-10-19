package com.crom.miguiapp.place;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crom.miguiapp.MapsActivity;
import com.crom.miguiapp.PlacesActivity;
import com.crom.miguiapp.R;
import com.crom.miguiapp.pojo.Place;
import com.crom.miguiapp.service.ControllerMediaPlayerService;

import java.util.List;

/**
 * Created by Jota on 26/09/2016.
 */

public class PlaceListRecyclerAdapter extends RecyclerView.Adapter<PlaceListRecyclerAdapter.PlaceViewHolder> {

    private List<Place> places;


    public PlaceListRecyclerAdapter(List<Place> places) {
        this.places = places;

    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        PlaceViewHolder holder = new PlaceViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        holder.placeImage.setImageResource(this.places.get(position).getImageResourse());
        holder.placeName.setText(this.places.get(position).getNombre());
        holder.placeDescription.setText(this.places.get(position).getDescripcion());
        holder.setPlace(this.places.get(position));
    }

    @Override
    public int getItemCount() {
        return this.places.size();
    }

    public static class PlaceViewHolder extends RecyclerView.ViewHolder {

        ImageView placeImage;
        TextView placeName;
        TextView placeDescription;
        Button mapBtn;
        Button playBtn;
        Place place;
        Context context;

        public PlaceViewHolder(View itemView) {
            super(itemView);
            this.context = itemView.getContext();
            placeImage = (ImageView) itemView.findViewById(R.id.placeImageView);
            placeName = (TextView) itemView.findViewById(R.id.placeName);
            placeDescription = (TextView) itemView.findViewById(R.id.placeDescription);
            mapBtn = (Button) itemView.findViewById(R.id.irBtn);
            playBtn = (Button) itemView.findViewById(R.id.play_btn);
        }

        public void setPlace(final Place place) {
            this.place = place;
            placeImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (PlaceViewHolder.this.place != null) {
                        //Intent intent = new Intent(context, MapsActivity.class);
                        Log.i("######", "Tengo que mostrar el mapa del id: " + PlaceViewHolder.this.place.getId());
                    }
                }
            });
            mapBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, MapsActivity.class);
                    intent.putExtra(MapsActivity.POSITION_LAT, place.getLandmark().getLatLng().latitude);
                    intent.putExtra(MapsActivity.POSITION_LON, place.getLandmark().getLatLng().longitude);
                    context.startActivity(intent);
                }
            });
            playBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ControllerMediaPlayerService.getInstance();
                    ControllerMediaPlayerService.getInstance().initService(context);
                }
            });
        }
    }
}
