/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.carpool_espol;

import java.util.ArrayList;

/**
 *
 * @author seoklie
 */
public class Parada {
    private int idRuta;
    private ArrayList<String> ubicacionParada;

    public Parada(int idRuta, ArrayList<String> ubicacionParada) {
        this.idRuta = idRuta;
        this.ubicacionParada = ubicacionParada;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public ArrayList<String> getUbicacionParada() {
        return ubicacionParada;
    }

    public void setIdRuta(int r) {
        this.idRuta = r;
    }

    public void setUbicacionParada(ArrayList<String> ubicacionParada) {
        this.ubicacionParada = ubicacionParada;
    }
    
}
