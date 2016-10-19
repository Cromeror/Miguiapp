package com.crom.miguiapp.pojo;

/**
 * Created by Jota on 24/09/2016.
 */

public class Place {
    private int id;
    private int imageResourse;
    private String nombre;
    private String descripcion;
    private Landmark landmark;


    public Place(int id, String nombre, String descripcion, int imageResourse){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imageResourse = imageResourse;
    }

    public Place(int id, String nombre, String descripcion, int imageResourse, Landmark landmark) {
        this.id = id;
        this.imageResourse = imageResourse;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.landmark = landmark;
    }

    public int getImageResourse() {
        return imageResourse;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Landmark getLandmark() {
        return landmark;
    }

    public void setLandmark(Landmark landmark) {
        this.landmark = landmark;
    }

    @Override
    public String toString() {
        return "PlacesActivity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
