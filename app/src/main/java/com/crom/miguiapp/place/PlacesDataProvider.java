package com.crom.miguiapp.place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jota on 24/09/2016.
 */

public class PlacesDataProvider {

    public static List<Place> getPlaces(){
        List<Place> placeList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Place place = new Place(i, "Nombre De Prueba #"+(i+1), "Esto es una descripcion de ejemplo. Por favor no se la tome en serio. Todo es un simulacro "+(i+1));
            placeList.add(place);
        }

        return placeList;
    }

}
