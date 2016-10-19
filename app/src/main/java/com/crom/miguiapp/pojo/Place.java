package com.crom.miguiapp.pojo;

/**
 * Created by Jota on 24/09/2016.
 */

public class Place {
    private int id;
    private Integer imageResourse;
    private String nombre;
    private String descripcion;
    private Landmark landmark;
    private Integer audioResource;


    public Place(int id, String name, String description, int imageResourse) {
        this.id = id;
        this.nombre = name;
        this.descripcion = description;
        this.imageResourse = imageResourse;
    }

    public Place(int id, String name, String description, int imageResourse, Landmark landmark) {
        this.id = id;
        this.imageResourse = imageResourse;
        this.nombre = name;
        this.descripcion = description;
        this.landmark = landmark;
    }

    public Place(int id, String name, String description, Integer imageResource, Landmark landmark, Integer audioResource) {
        this.id = id;
        this.imageResourse = imageResource;
        this.nombre = name;
        this.descripcion = description;
        this.landmark = landmark;
        this.audioResource = audioResource;
    }

    public void setImageResourse(Integer imageResourse) {
        this.imageResourse = imageResourse;
    }

    public Integer getAudioResource() {
        return audioResource;
    }

    public void setAudioResource(Integer audioResource) {
        this.audioResource = audioResource;
    }

    public Integer getImageResourse() {
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
