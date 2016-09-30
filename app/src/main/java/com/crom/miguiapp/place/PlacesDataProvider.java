package com.crom.miguiapp.place;

import com.crom.miguiapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jota on 24/09/2016.
 */

public class PlacesDataProvider {

    private static final Place[] places = new Place[]{
            new Place(1,"Muelle de los Pegasos","El Muelle de los Pegasos es hoy un centro de actividades culturales y un embarcadero turístico. Su decoración muestra dos esculturas de pegasos...",R.mipmap.muelle_de_los_pegasos),
            new Place(2,"Torre del Reloj","El reloj además de ser el símbolo representativo de Cartagena es la entrada a la ciudad. Esta torre fue instaurada en el siglo XIX...",R.mipmap.torre_del_reloj),
            new Place(3,"Palacio de la Inquisicion","Este edificio es considerado una de las casas típicas de la arquitectura civil de la Cartagena de Indias del siglo XVIII.",R.mipmap.palacio_de_la_inquisicion)
    };

    public static List<Place> getPlaces(){
        List<Place> placesList = new ArrayList();
        for(int i = 0; i < places.length; i++){
            placesList.add(places[i]);
        }
        return placesList;
    }

}
