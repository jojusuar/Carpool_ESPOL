/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.bdavance2;

/**
 *
 * @author seoklie
 */
public class InfoAuto {
    private String id1;
    private String placa;
    private String modelo;
    private String nroChasis;

    public InfoAuto(String id1, String placa, String modelo, String nroChasis) {
        this.id1 = id1;
        this.placa = placa;
        this.modelo = modelo;
        this.nroChasis = nroChasis;
    }

    public String getEmail() {
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

    public void setEmail(String email) {
        this.id1 = email;
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
