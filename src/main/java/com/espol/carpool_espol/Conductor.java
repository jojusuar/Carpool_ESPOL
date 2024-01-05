/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.carpool_espol;

import java.time.LocalDate;
import jdk.jfr.Name;

/**
 *
 * @author seoklie
 */public class Conductor extends Usuario{
    private String cuentaBancaria;    
    private LocalDate caducidadLicencia;
    
    public Conductor(int id, tipoUsuario t, String e, String p, String n, String a, String telf,double puntaje, String cuenta, LocalDate caducidad){
        super(id,t,e,p,n,a,telf,puntaje);
        this.caducidadLicencia = caducidad;
        this.cuentaBancaria = cuenta;
    }
    

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public LocalDate getCaducidadLicencia() {
        return caducidadLicencia;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public void setCaducidadLicencia(LocalDate caducidadLicencia) {
        this.caducidadLicencia = caducidadLicencia;
    }
    
}
