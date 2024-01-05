/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.carpool_espol;

import java.lang.reflect.Field;

/**
 *
 * @author seoklie
 */
public class Resena {
    private String correoReviewed;
    private String correoReviewer;
    private int idResena;
    private String Resena;

    public Resena(String id1, String id2, int idResena, String Resena) {
        this.correoReviewed = id1;
        this.correoReviewer = id2;
        this.idResena = idResena;
        this.Resena = Resena;
    }

    public String getCorreoReviewed() {
        return correoReviewed;
    }

    public String getCorreoReviewer() {
        return correoReviewer;
    }

    public int getIdResena() {
        return idResena;
    }

    public String getResena() {
        return Resena;
    }

    public void setCorreoReviewed(String id1) {
        this.correoReviewed = correoReviewed;
    }

    public void setCorreoReviewer(String id2) {
        this.correoReviewer = correoReviewer;
    }

    public void setIdResena(int idResena) {
        this.idResena = idResena;
    }

    public void setResena(String Resena) {
        this.Resena = Resena;
    }
    public static String[] desglosarAtributos(Resena res) {
        Field[] fields = res.getClass().getDeclaredFields();
        String[] atributos = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                atributos[i] = fields[i].get(res).toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return atributos;
    
    }
    
    
}
