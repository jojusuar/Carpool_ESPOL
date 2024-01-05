/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.carpool_espol;

/**
 *
 * @author seoklie
 */
public class Ruta {
    private int idRuta;
    private String origen;
    private String destino;

    public Ruta(int idRuta, String origen, String destino) {
        this.idRuta = idRuta;
        this.origen = origen;
        this.destino = destino;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
}
