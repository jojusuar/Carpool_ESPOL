/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.carpool_espol;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author seoklie
 */
public class Menu {

    public static void mostrarMenu() {
        System.out.println("1.Soporte Al Cliente.\n"
                + "2. Usuario\n"
                + "3.Reseña\n"
                + "4.InfoAuto\n"
                + "5.TicketSoporte\n"
                + "6.Modelo Auto.\n"
                + "7.Viaje\n"
                + "8.Paradas\n"
                + "9.Reservacion\n"
                + "10.Ruta\n"
                + "11.Pasajero\n"
                + "12.Conductor\n"
                + "13. VOLVER");
    }

    public static void consultarDatos(int opcion) {
        Scanner s2 = new Scanner(System.in);

        switch (opcion) {
            case 1:
                DB.getSoporteCliente();
                break;
            case 2:
                DB.getUsers();
                break;
            case 3:
                DB.getResenia();
                break;
            case 4:
                DB.getInfoAuto();
                break;
            case 5:
                DB.getTicketSoporte();
                break;
            case 6:
                DB.getmodeloauto();
                break;
            case 7:
                DB.getTrips();
                break;
            case 8:
                DB.getParadas();
                break;
            case 9:
                DB.getReservacion();
                break;
            case 10:
                DB.getRuta();
                break;
            case 11:
                DB.getPasajero();
                break;
            case 12:
                DB.getConductor();
                break;
            default:
                System.out.println("Opción no válida");

        }
    }
}
