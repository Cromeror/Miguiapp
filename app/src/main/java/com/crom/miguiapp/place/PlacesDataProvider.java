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
            Place place = new Place("nombre de prueba #"+(i+1), "descripcion de prueba #"+(i+1));
        }

        return placeList;
    }

}
