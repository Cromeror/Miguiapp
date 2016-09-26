package com.crom.miguiapp.place;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.crom.miguiapp.R;

import java.util.List;

/**
 * Created by Jota on 26/09/2016.
 */

public class PlaceListRecyclerAdapter extends RecyclerView.Adapter<PlaceListRecyclerAdapter.PlaceViewHolder> {

    private List<Place> places;


    public PlaceListRecyclerAdapter(List<Place> places){
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
        holder.placeImage.setImageResource(R.mipmap.cartagena);
        holder.placeName.setText(this.places.get(position).getNombre());
        holder.placeDescription.setText(this.places.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return this.places.size();
    }

    public static class PlaceViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName;
        TextView placeDescription;

        public PlaceViewHolder(View itemView) {
            super(itemView);
            placeImage = (ImageView) itemView.findViewById(R.id.placeImageView);
            placeName = (TextView) itemView.findViewById(R.id.placeName);
            placeDescription = (TextView) itemView.findViewById(R.id.placeDescription);
        }
    }
}
