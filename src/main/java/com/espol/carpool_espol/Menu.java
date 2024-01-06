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

    public static int mostrarDatosConsulta(Scanner s2, Object o) {
        Class clase = o.getClass();
        System.out.println("Dato a consultar: ");
        Field[] fields = clase.getDeclaredFields();
        int contador = 1;
        for (Field f : fields) {
            System.out.println(contador + ". " + f.getName());
            contador++;
        }
        int op1 = s2.nextInt();
        return op1;
    }

    public static int comparaciones(Scanner s2) {
        System.out.println("Consultar por:\n"
                + "1.Mayor que x valor.\n"
                + "2. Menor que x valor.\n"
                + "3. Igual que x valor.\n"
                + "4. Acabar filtrado.");
        int op2 = s2.nextInt();
        return op2;
    }

    public static void consultarDatos(int opcion) {
        Scanner s2 = new Scanner(System.in);

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el ID a buscar: ");
                int id = s2.nextInt();
                if (BDavance2.soportes.isEmpty()) {
                    System.out.println("No existen valores a mostrar.");
                } else {
                    for (SoporteCliente sc : BDavance2.soportes) {
                        if (sc.getIdEmpleado() == id) {
                            System.out.println("Existe.");
                        } else {
                            System.out.println("No encontrado.");
                        }
                    }
                }
                break;

            case 2:
                DB.getUsers();
                break;
            case 3:
                Resena r = new Resena("", "", 0, "");
                int op1 = Menu.mostrarDatosConsulta(s2, r);
                int op2 = Menu.comparaciones(s2);
                break;
            case 4:
                DB.getInfoAuto();
                break;
            case 5:
                DB.getTicketSoporte();
                break;
            case 6:
                
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
