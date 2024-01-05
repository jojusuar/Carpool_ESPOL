/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.carpool_espol;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author seoklie
 */
public class Usuario {
    private int id;
    private tipoUsuario tipo;
    private String email;
    private String password;
    private String nombre;
    private String apellido;
    private String telefono;
    private double puntuacion;

    public Usuario(int id, tipoUsuario tipo, String email, String password, String nombre, String apellido, String telefono, double puntuacion) {
        this.id = id;
        this.tipo = tipo;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.puntuacion = puntuacion;
    }
    
    
    public int getId() {
        return id;
    }

    public tipoUsuario getTipo() {
        return tipo;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(tipoUsuario tipo) {
        this.tipo = tipo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }
    public static String[] desglosarAtributos(Usuario usuario) {
        Field[] fields = usuario.getClass().getDeclaredFields();
        String[] atributos = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                atributos[i] = fields[i].get(usuario).toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return atributos;
    }

    public static boolean obtenerAtributo(Usuario usuario, int opcion, String igualA) {
        String[] atributos = desglosarAtributos(usuario);
        for (int i = 0; i < atributos.length; i++) {
            if (i == opcion && atributos[i].equals(igualA)) {
                return true;
            }
        }
        return false;
    }
    public static boolean obtenerAtributo(Usuario usuario, int opcion, int igualB) {
        String[] atributos = desglosarAtributos(usuario);
        for (int i = 0; i < atributos.length; i++) {
            if (i == opcion && atributos[i].equals(igualB)) {
                return true;
            }
        }
        return false;
    }
    public static boolean compararAtributo(Usuario usuario, int opcion, int valor) {
        String[] atributos = desglosarAtributos(usuario);
        for (Usuario u: BDavance2.usuarios){
            switch(opcion){
                case 1:
                    if(usuario.getPuntuacion()>valor)
                        return true;
                case 2:
                    if(usuario.getPuntuacion()<valor)
                        return true;
                case 3:
                    if(usuario.getPuntuacion()==(double)valor)
                        return true;
            }
        }
        return false;
    }
}

