package com.crom.miguiapp.place;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crom.miguiapp.PlacesActivity;
import com.crom.miguiapp.R;
import com.crom.miguiapp.pojo.Place;
import com.crom.miguiapp.service.ControllerMediaPlayerService;

import java.util.List;

/**
 * Created by Jota on 24/09/2016.
 */

public class PlaceAdapter extends BaseAdapter {

    private List<Place> places;
    private Context context;

    public PlaceAdapter(List<Place> places, Context context) {
        this.places = places;
        this.context = context;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int position) {
        return places.get(position);
    }

    @Override
    public long getItemId(int position) {
        return places.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_place, null);
        }

        Place place = places.get(position);

        TextView placeNameTextView = (TextView) view.findViewById(R.id.placeName);
        TextView descriptionTextView = (TextView) view.findViewById(R.id.placeDescription);
        ImageView placeImageView = (ImageView) view.findViewById(R.id.imageView);

        placeNameTextView.setText(place.getNombre());
        descriptionTextView.setText(place.getDescripcion());
        placeImageView.setBackgroundResource(this.places.get(position).getImageResourse());
        return view;
    }
}
