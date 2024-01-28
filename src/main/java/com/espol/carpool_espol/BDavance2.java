/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.espol.carpool_espol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author seoklie
 */
public class BDavance2 {

    static ArrayList<SoporteCliente> soportes = new ArrayList<>();
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Resena> resenas = new ArrayList<>();
    static ArrayList<InfoAuto> inf = new ArrayList<>();
    static ArrayList<TicketSoporte> tickets = new ArrayList<>();
    static ArrayList<ModeloAuto> modelos = new ArrayList<>();
    static ArrayList<Viaje> viajes = new ArrayList<>();
    static ArrayList<Parada> paradas = new ArrayList<>();
    static ArrayList<Reservacion> reser = new ArrayList<>();
    static ArrayList<Ruta> rutas = new ArrayList<>();

    public static void main(String[] args) {
        DB.startConnection();
        System.out.println("---MENU---");
        Scanner s1 = new Scanner(System.in);
        int opcionMenuP = 0;

        //PARA ANADIR
        while (opcionMenuP != 5) {
            System.out.println("ESCOJA UNA OPCIÓN:\n"
                    + "1.Añadir datos.\n"
                    + "2.Editar datos\n"
                    + "3.Consultar datos.\n"
                    + "4.Eliminar datos\n"
                    + "5.SALIR");
            opcionMenuP = s1.nextInt();
            s1.nextLine();
            switch (opcionMenuP) {
                case 1:
                    int opcionMenuA = 0;
                    while (opcionMenuA != 13) {
                        System.out.println("Escoja la tabla donde añadirá datos:");
                        Menu.mostrarMenu();
                        opcionMenuA = s1.nextInt();
                        s1.nextLine();
                        switch (opcionMenuA) {
                            case 1:
                                DB.newClientSupport(s1);
                                break;
                            case 2:
                                DB.newUser(s1);
                                break;
                            case 3:
                                DB.newReview(s1);
                                break;
                            case 4:
                                DB.newCarInfo(s1);
                                break;
                            case 5:
                                DB.newSupportTicket(s1);
                                break;
                            case 6:
                                DB.newCarModel(s1);
                                break;
                            case 7:
                                DB.newTrip(s1);
                                break;
                            case 8:
                                DB.newStop(s1);
                                break;
                            case 9:
                                DB.newReservation(s1);
                                break;
                            case 10:
                                DB.newRoute(s1);
                                break;
                            case 11:
                                DB.addCreditCard(s1);
                                break;
                            case 12:
                                DB.addBankAccount(s1);
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2:
                    int opCons = 0;
                    while (opCons != 13) {
                        System.out.println("Seleccione lo que desee editar");
                        Menu.mostrarMenu();
                        opCons = s1.nextInt();
                        s1.nextLine();
                        switch (opCons) {
                            case 1:
                                System.out.println("No se puede editar, solo claves primarias");
                                break;
                            case 2:
                                DB.editUser(s1);
                                break;
                            case 3:
                                DB.editReview(s1);
                                break;
                            case 4:
                                DB.editInfoAuto(s1);
                                break;
                            case 5:
                                DB.editSupportTicket(s1);
                                break;
                            case 6:
                                DB.editModeloAuto(s1);
                                break;
                            case 7:
                                DB.editViaje(s1);
                                break;
                            case 8:
                                System.out.println("No se puede editar, solo claves primarias");
                                break;
                            case 9:
                                DB.editReservacion(s1);
                                break;
                            case 10:
                                DB.editRuta(s1);
                                break;
                            case 11:
                                DB.editPasajero(s1);
                                break;
                            case 12:
                                DB.editConductor(s1);
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                case 3: {
                    System.out.println("Ingrese tabla a consultar:");
                    Menu.mostrarMenu();
                    int opConsultar = s1.nextInt();
                    s1.nextLine();
                    Menu.consultarDatos(opConsultar);
                    break;
                }
                case 4: {
                    int opcionMenuD = 0;
                    while (opcionMenuD != 13) {
                        System.out.println("Escoja la tabla donde eliminará entradas:");
                        Menu.mostrarMenu();
                        opcionMenuD = s1.nextInt();
                        s1.nextLine();
                        switch (opcionMenuD) {
                            case 1:
                                DB.deleteClientSupport(s1);
                                break;
                            case 2:
                                DB.deleteUser(s1);
                                break;
                            case 3:
                                DB.deleteReview(s1);
                                break;
                            case 4:
                                DB.deleteCarInfo(s1);
                                break;
                            case 5:
                                DB.deleteSupportTicket(s1);
                                break;
                            case 6:
                                DB.deleteCarModel(s1);
                                break;
                            case 7:
                                DB.deleteTrip(s1);
                                break;
                            case 8:
                                DB.deleteStop(s1);
                                break;
                            case 9:
                                DB.deleteReservation(s1);
                                break;
                            case 10:
                                DB.deleteRoute(s1);
                                break;
                            case 11:
                                DB.deletePassenger(s1);
                                break;
                            case 12:
                                DB.deleteDriver(s1);
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }
        DB.closeConnection();
    }
}
