package com.crom.miguiapp.pojo;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Cristóbal Romero
 * <https://github.com/Cromeror>
 * on 15/10/2016.
 */

public class Landmark {
    private String name;
    private LatLng latLng;

    public Landmark(String name, LatLng latLng) {
        this.name = name;
        this.latLng = latLng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }
}
