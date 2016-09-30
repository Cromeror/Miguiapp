package com.crom.miguiapp.place;

/**
 * Created by Jota on 24/09/2016.
 */

public class Place {
    private int id;
    private int imageResourse;
    private String nombre;
    private String descripcion;

    public Place(int id, String nombre, String descripcion, int imageResourse){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imageResourse = imageResourse;
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

    @Override
    public String toString() {
        return "PlacesActivity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
