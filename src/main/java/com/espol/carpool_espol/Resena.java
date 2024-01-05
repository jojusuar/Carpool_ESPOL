/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.bdavance2;

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

    public String getCorreoeviewer() {
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

    public void setCorreoeviewer(String id2) {
        this.correoReviewer = correoReviewer;
    }

    public void setIdResena(int idResena) {
        this.idResena = idResena;
    }

    public void setResena(String Resena) {
        this.Resena = Resena;
    }
    
    
}
