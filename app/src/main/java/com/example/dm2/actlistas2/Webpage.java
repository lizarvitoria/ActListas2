package com.example.dm2.actlistas2;

/**
 * Created by dm2 on 20/10/2017.
 */

public class Webpage {
    private String nombre,link,descripcion;
    private int imagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Webpage(String n, String l, int i, String d){
        nombre=n;
        link=l;
        imagen=i;
        descripcion=d;

    }
}
