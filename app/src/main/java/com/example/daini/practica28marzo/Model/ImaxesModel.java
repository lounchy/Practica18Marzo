package com.example.daini.practica28marzo.Model;

/**
 * Created by Daini on 13/03/2017.
 */

public class ImaxesModel {
    private int imaxe;
    private String nombre;

    public ImaxesModel(int imaxe, String nombre) {
        this.imaxe = imaxe;

        this.nombre = nombre;
    }

    public ImaxesModel(int imaxe) {
        this.imaxe = imaxe;
    }


    public String getNombre() {
        return nombre;
    }

    public int getImaxe() {
        return imaxe;
    }


}
