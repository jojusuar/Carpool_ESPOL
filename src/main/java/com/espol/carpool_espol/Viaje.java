/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.bdavance2;

import java.time.*;

/**
 *
 * @author seoklie
 */
public class Viaje {
    private int conductor;
    private int idViaje;
    private int idRuta;
    private double precio;
    private double tarifa;
    private String hora;
    private Estado estado;
    private int asientoDisponible;
    private String novedad;
    private String fecha;
    private String preferencias;

    public Viaje(int c, int idViaje, int idRuta, double precio, double tarifa, String hora, Estado estado, int asientoDisponible, String novedad, String fecha, String preferencias) {
        this.conductor = c;
        this.idViaje = idViaje;
        this.idRuta = idRuta;
        this.precio = precio;
        this.tarifa = tarifa;
        this.hora = hora;
        this.estado = estado;
        this.asientoDisponible = asientoDisponible;
        this.novedad = novedad;
        this.fecha = fecha;
        this.preferencias = preferencias;
    }

    public int getConductor() {
        return conductor;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public double getPrecio() {
        return precio;
    }

    public double getTarifa() {
        return tarifa;
    }

    public String getHora() {
        return hora;
    }

    public Estado getEstado() {
        return estado;
    }

    public int getAsientoDisponible() {
        return asientoDisponible;
    }

    public String getNovedad() {
        return novedad;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setConductor(int c) {
        this.conductor = c;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public void setIdRuta(Ruta r) {
        this.idRuta = r.getIdRuta();
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setAsientoDisponible(int asientoDisponible) {
        this.asientoDisponible = asientoDisponible;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }
    
    
}
