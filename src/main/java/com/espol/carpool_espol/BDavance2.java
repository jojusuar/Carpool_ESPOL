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
            switch (opcionMenuP) {
                case 1:
                    int opcionMenuA = 0;
                    while (opcionMenuA != 13) {
                        System.out.println("Escoja la tabla donde añadirá datos:");
                        Menu.mostrarMenu();
                        opcionMenuA = s1.nextInt();
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
                        switch (opCons) {
                            case 1: {
                                System.out.println("Soporte al Cliente");
                                System.out.println("Este elemento no tiene campos editables.");
                            }
                            break;
                            case 2:
                                System.out.println("Usuarios");
                                DB.editUser(s1);
                                break;
                            case 3:
                                System.out.println("Resena");
                                DB.editReview(s1);
                                break;
                            case 4:
                                System.out.println("Información de Autos");
                                DB.editCarInfo(s1);
                                break;

                            case 5:
                                System.out.println("Tickets de soporte");
                                DB.editSupportTicket(s1);
                                break;
                            case 6:
                                System.out.println("Modelos de Autos");
                                DB.editCarModel(s1);
                                break;
                            case 7:
                                System.out.println("Viajes");
                                int cont = 0;
                                for (Viaje viaje : viajes) {
                                    cont++;
                                    System.out.println("#############\n" + "Viaje #" + cont);
                                    System.out.println("1. Conductor: " + viaje.getConductor());
                                    System.out.println("2. ID Viaje: " + viaje.getIdViaje());
                                    System.out.println("3. ID Ruta: " + viaje.getIdRuta());
                                    System.out.println("4. Precio: " + viaje.getPrecio());
                                    System.out.println("5. Tarifa: " + viaje.getTarifa());
                                    System.out.println("6. Hora: " + viaje.getHora());
                                    System.out.println("7. Estado: " + viaje.getEstado());
                                    System.out.println("8. Asientos Disponibles: " + viaje.getAsientoDisponible());
                                    System.out.println("9. Novedad: " + viaje.getNovedad());
                                    System.out.println("10. Fecha: " + viaje.getFecha());
                                    System.out.println("11. Preferencias: " + viaje.getPreferencias());
                                }

                                System.out.println("¿Qué viaje desea modificar?");
                                int opV = s1.nextInt();
                                Viaje viajeSeleccionado = viajes.get(opV);
                                System.out.println("Seleccionado. ¿Qué dato del viaje desea cambiar?");
                                int vRes = s1.nextInt();
                                System.out.println("Ingrese el nuevo dato:");

                                switch (vRes) {
                                    case 1:
                                        int nuevoConductor = s1.nextInt();
                                        viajeSeleccionado.setConductor(nuevoConductor);
                                        break;
                                    case 2:
                                        int nuevoIdViaje = s1.nextInt();
                                        viajeSeleccionado.setIdViaje(nuevoIdViaje);
                                        break;
                                    case 3:
                                        int nuevoIdRuta = s1.nextInt();
                                        viajeSeleccionado.setIdRuta(nuevoIdRuta);
                                        break;
                                    case 4:
                                        double nuevoPrecio = s1.nextDouble();
                                        viajeSeleccionado.setPrecio(nuevoPrecio);
                                        break;
                                    case 5:
                                        double nuevaTarifa = s1.nextDouble();
                                        viajeSeleccionado.setTarifa(nuevaTarifa);
                                        break;
                                    case 6:
                                        String nuevaHora = s1.next();
                                        viajeSeleccionado.setHora(nuevaHora);
                                        break;
                                    case 7:
                                        Estado nuevoEstado = Estado.valueOf(s1.next());
                                        viajeSeleccionado.setEstado(nuevoEstado);
                                        break;
                                    case 8:
                                        int nuevosAsientos = s1.nextInt();
                                        viajeSeleccionado.setAsientoDisponible(nuevosAsientos);
                                        break;
                                    case 9:
                                        String nuevaNovedad = s1.next();
                                        viajeSeleccionado.setNovedad(nuevaNovedad);
                                        break;
                                    case 10:
                                        String nuevaFecha = s1.next();
                                        viajeSeleccionado.setFecha(nuevaFecha);
                                        break;
                                    case 11:
                                        String nuevasPreferencias = s1.next();
                                        viajeSeleccionado.setPreferencias(nuevasPreferencias);

                                }
                            case 8:
                                System.out.println("Paradas");
                                cont = 0;
                                for (Parada parada : paradas) {
                                    cont++;
                                    System.out.println("#############\n" + "Parada #" + cont);
                                    System.out.println("1. ID Ruta: " + parada.getIdRuta());
                                    System.out.println("2. Ubicaciones de Parada:");
                                    for (String ubicacion : parada.getUbicacionParada()) {
                                        System.out.println("   - " + ubicacion);
                                    }
                                }

                                System.out.println("¿Qué parada desea modificar?");
                                int opParada = s1.nextInt();
                                Parada paradaSeleccionada = paradas.get(opParada);
                                System.out.println("Seleccionada. ¿Qué dato de la parada desea cambiar?");
                                int paradaRes = s1.nextInt();
                                System.out.println("Ingrese el nuevo dato:");

                                switch (paradaRes) {
                                    case 1:
                                        int nuevoIdRuta = s1.nextInt();
                                        paradaSeleccionada.setIdRuta(nuevoIdRuta);
                                        break;
                                    case 2:
                                        System.out.println("Ingrese las nuevas ubicaciones de parada (separadas por comas):");
                                        s1.nextLine(); // Limpiar el buffer
                                        String nuevasUbicaciones = s1.nextLine();
                                        ArrayList<String> nuevasParadas = new ArrayList<>(Arrays.asList(nuevasUbicaciones.split(",")));
                                        paradaSeleccionada.setUbicacionParada(nuevasParadas);
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }

                            case 9:
                                System.out.println("Reservaciones");
                                cont = 0;
                                for (Reservacion reservacion : reser) {
                                    cont++;
                                    System.out.println("#############\n" + "Reservación #" + cont);
                                    System.out.println("1. Email: " + reservacion.getEmail());
                                    System.out.println("2. ID Viaje: " + reservacion.getIdViaje());
                                    System.out.println("3. ID Reserva: " + reservacion.getIdReserva());
                                    System.out.println("4. Detalle: " + reservacion.getDetalle());
                                    System.out.println("5. Fecha: " + reservacion.getFecha());
                                }

                                System.out.println("¿Qué reservación desea modificar?");
                                int opReserva = s1.nextInt();
                                Reservacion reservacionSeleccionada = reser.get(opReserva);
                                System.out.println("Seleccionado. ¿Qué dato de la reservación desea cambiar?");
                                int reservaRes = s1.nextInt();
                                System.out.println("Ingrese el nuevo dato:");

                                switch (reservaRes) {
                                    case 1:
                                        String nuevoEmail = s1.next();
                                        reservacionSeleccionada.setEmail(nuevoEmail);
                                        break;
                                    case 2:
                                        int nuevoIdViaje = s1.nextInt();
                                        reservacionSeleccionada.setIdViaje(nuevoIdViaje);
                                        break;
                                    case 3:
                                        int nuevoIdReserva = s1.nextInt();
                                        reservacionSeleccionada.setIdReserva(nuevoIdReserva);
                                        break;
                                    case 4:
                                        String nuevoDetalle = s1.next();
                                        reservacionSeleccionada.setDetalle(nuevoDetalle);
                                        break;
                                    case 5:
                                        String nuevaFecha = s1.next();
                                        reservacionSeleccionada.setFecha(nuevaFecha);
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            case 10:
                                System.out.println("Rutas");
                                cont = 0;
                                for (Ruta ruta : rutas) {
                                    cont++;
                                    System.out.println("#############\n" + "Ruta #" + cont);
                                    System.out.println("1. ID Ruta: " + ruta.getIdRuta());
                                    System.out.println("2. Origen: " + ruta.getOrigen());
                                    System.out.println("3. Destino: " + ruta.getDestino());
                                }

                                System.out.println("¿Qué ruta desea modificar?");
                                int opRuta = s1.nextInt();
                                Ruta rutaSeleccionada = rutas.get(opRuta);
                                System.out.println("Seleccionado. ¿Qué dato de la ruta desea cambiar?");
                                int rutaRes = s1.nextInt();
                                System.out.println("Ingrese el nuevo dato:");

                                switch (rutaRes) {
                                    case 1:
                                        int nuevoIdRuta = s1.nextInt();
                                        rutaSeleccionada.setIdRuta(nuevoIdRuta);
                                        break;
                                    case 2:
                                        String nuevoOrigen = s1.next();
                                        rutaSeleccionada.setOrigen(nuevoOrigen);
                                        break;
                                    case 3:
                                        String nuevoDestino = s1.next();
                                        rutaSeleccionada.setDestino(nuevoDestino);
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                        }
                    }
                    break;
                case 3: {
                    System.out.println("Ingrese tabla a consultar:");
                    Menu.mostrarMenu();
                    int opConsultar = s1.nextInt();
                    Menu.consultarDatos(opConsultar);
                    break;
                }
                case 4: {
                    int opcionMenuD = 0;
                    while (opcionMenuD != 13) {
                        System.out.println("Escoja la tabla donde eliminará entradas:");
                        Menu.mostrarMenu();
                        opcionMenuD = s1.nextInt();
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
