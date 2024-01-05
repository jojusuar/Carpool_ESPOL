/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.carpool_espol;

/**
 *
 * @author seoklie
 */
public class InfoAuto {
    private int id1;
    private String placa;
    private String modelo;
    private String nroChasis;

    public InfoAuto(int id1, String placa, String modelo, String nroChasis) {
        this.id1 = id1;
        this.placa = placa;
        this.modelo = modelo;
        this.nroChasis = nroChasis;
    }
    public InfoAuto(){
        this.id1 = 0;
        this.placa = "";
        this.modelo = "";
        this.nroChasis = "";
    }

    public int getId1() {
        return id1;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNroChasis() {
        return nroChasis;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNroChasis(String nroChasis) {
        this.nroChasis = nroChasis;
    }
    
}
