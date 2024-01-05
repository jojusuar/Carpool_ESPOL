/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.bdavance2;

import java.time.LocalDate;

/**
 *
 * @author seoklie
 */
public class Reservacion {
    private String email;
    private int idViaje;
    private int idReserva;
    private String detalle;
    private String fecha;

    public Reservacion(String email, int idViaje, int idReserva, String detalle, String fecha) {
        this.email = email;
        this.idViaje = idViaje;
        this.idReserva = idReserva;
        this.detalle = detalle;
        this.fecha = fecha;
    }

    public String getEmail() {
        return email;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
