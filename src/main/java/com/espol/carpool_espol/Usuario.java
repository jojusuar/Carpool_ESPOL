/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.bdavance2;

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
    
}
