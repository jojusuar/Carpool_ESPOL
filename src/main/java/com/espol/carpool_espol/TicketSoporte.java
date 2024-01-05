/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.carpool_espol;

/**
 *
 * @author seoklie
 */
public class TicketSoporte {
    private int idEmpleado;
    private String email;
    private String descripcion;
    public TicketSoporte(int id, String email, String desc){
        this.email = email;
        idEmpleado = id;
        descripcion = desc;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getEmail() {
        return email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
