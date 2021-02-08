package com.example.mascotas;

import java.io.Serializable;

public class Mascota implements Serializable {

    private String nombre;
    private int foto;
    private  int puntos;

    public Mascota(String nombre, int foto, int puntos ) {
        this.nombre = nombre;
        this.foto = foto;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}
