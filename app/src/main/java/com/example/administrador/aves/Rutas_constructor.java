package com.example.administrador.aves;

/**
 * Created by sennova on 14/06/2017.
 */

public class Rutas_constructor {


    private String nombre;
    private String ruta;
    private String foto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    private String longitud;

    public Rutas_constructor(String nombre, String ruta, String foto, String longitud) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.foto = foto;
        this.longitud = longitud;
    }




}
