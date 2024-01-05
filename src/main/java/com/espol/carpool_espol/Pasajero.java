/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.bdavance2;

/**
 *
 * @author seoklie
 */
public class Pasajero extends Usuario{
    private String tarjetaPago;
    public Pasajero(int id, tipoUsuario tipo, String email, String password, String nombre, String apellido, String telefono, double puntuacion,String tarjetaPago){
        super(id, tipo, email, password, nombre, apellido, telefono, puntuacion);
        this.tarjetaPago = tarjetaPago;
    }
}
