/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.bdavance2;

/**
 *
 * @author seoklie
 */
public class ModeloAuto {
    private String modelo;
    private String colorVehiculo;

    public ModeloAuto(String modelo, String colorVehiculo) {
        this.modelo = modelo;
        this.colorVehiculo = colorVehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColorVehiculo() {
        return colorVehiculo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColorVehiculo(String colorVehiculo) {
        this.colorVehiculo = colorVehiculo;
    }
    
}
