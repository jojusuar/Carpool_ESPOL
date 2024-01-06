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
                        System.out.println("Escoja la tabla donde añadirá datos:"
                                + "1.Soporte Al Cliente.\n"
                                + "2.Usuario\n"
                                + "3.Reseña\n"
                                + "4.InfoAuto\n"
                                + "5.TicketSoporte\n"
                                + "6.Modelo Auto.\n"
                                + "7.Viaje\n"
                                + "8.Paradas\n"
                                + "9.Reservacion\n"
                                + "10.Ruta\n"
                                + "11.Pasajero.\n"
                                + "12.Conductor.\n"
                                + "13. VOLVER");
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
                    while (opCons != 11) {
                        Menu.mostrarMenu();
                        opCons = s1.nextInt();
                        switch (opCons) {
                            case 1:
                                System.out.println("Soporte al Cliente");
                                int cont = 0;
                                for (SoporteCliente sc : soportes) {
                                    cont++;
                                    System.out.println("#############\n" + "Soporte al cliente #" + cont);
                                    System.out.println("IDSoporteCliente: " + sc.getIdEmpleado());
                                }

                                System.out.println("¿Qué registro desea modificar?");
                                int regNum = s1.nextInt();
                                SoporteCliente sc1 = soportes.get(regNum);
                                System.out.println("Seleccionado. ¿Qué dato quiere cambiar?\n1) ID.");
                                int opsc1 = s1.nextInt();
                                if (opsc1 == 1) {
                                    System.out.println("Ingrese el nuevo dato: ");
                                    int nuevoid = s1.nextInt();
                                    sc1.setIdEmpleado(nuevoid);
                                }
                            case 2:
                                System.out.println("Usuarios");
                                cont = 0;
                                for (Usuario u : usuarios) {
                                    cont++;
                                    System.out.println("#############\n" + "Usuario #" + cont);
                                    System.out.println("1. IDUsuario: " + u.getId());
                                    System.out.println("2. Tipo: " + u.getTipo());
                                    System.out.println("3. Email: " + u.getEmail());
                                    System.out.println("4. Password: " + u.getPassword());
                                    System.out.println("5. Nombre: " + u.getNombre());
                                    System.out.println("6. Apellido: " + u.getApellido());
                                    System.out.println("7. Telefono: " + u.getTelefono());
                                    System.out.println("8. Puntuacion: " + u.getPuntuacion());
                                }

                                System.out.println("¿Qué registro desea modificar?");
                                int opU = s1.nextInt();
                                Usuario us = usuarios.get(opU);
                                System.out.println("Seleccionado. Que dato del registro desea cambiar? ");
                                int usRes = s1.nextInt();
                                System.out.println("Ingrese el nuevo dato: ");
                                switch (usRes) {
                                    case 1:
                                        int nuevoID = s1.nextInt();
                                        us.setId(nuevoID);
                                    case 2:
                                        tipoUsuario nuevoTipo = tipoUsuario.valueOf(s1.next());
                                        us.setTipo(nuevoTipo);
                                    case 3:
                                        String nuevoE = s1.next();
                                        us.setEmail(nuevoE);
                                    case 4:
                                        String nuevoP = s1.next();
                                        us.setPassword(nuevoP);
                                    case 5:
                                        String nuevoNombre = s1.next();
                                        us.setNombre(nuevoNombre);
                                    case 6:
                                        String nuevoAp = s1.next();
                                        us.setApellido(nuevoAp);
                                    case 7:
                                        String nuevoTelf = s1.next();
                                        us.setTelefono(nuevoTelf);
                                    case 8:
                                        double nuevaPun = s1.nextDouble();
                                        us.setPuntuacion(nuevaPun);
                                }
                            case 3:
                                System.out.println("Resena");
                                cont = 0;
                                for (Resena r : resenas) {
                                    cont++;
                                    System.out.println("#############\n" + "Reseña #" + cont);
                                    System.out.println("1. Correo Reviewed: " + r.getCorreoReviewed());
                                    System.out.println("2. Correo Reviewer: " + r.getCorreoReviewer());
                                    System.out.println("3. ID Reseña: " + r.getIdResena());
                                    System.out.println("4. Reseña: " + r.getResena());
                                }

                                System.out.println("¿Qué registro desea modificar?");
                                int opR = s1.nextInt();
                                Resena resenaSeleccionada = resenas.get(opR);
                                System.out.println("Seleccionado. ¿Qué dato del registro desea cambiar?");
                                int resenaRes = s1.nextInt();
                                System.out.println("Ingrese el nuevo dato:");

                                switch (resenaRes) {
                                    case 1:
                                        String nuevoCorreoReviewed = s1.next();
                                        resenaSeleccionada.setCorreoReviewed(nuevoCorreoReviewed);
                                        break;
                                    case 2:
                                        String nuevoCorreoReviewer = s1.next();
                                        resenaSeleccionada.setCorreoReviewer(nuevoCorreoReviewer);
                                        break;
                                    case 3:
                                        int nuevoIdResena = s1.nextInt();
                                        resenaSeleccionada.setIdResena(nuevoIdResena);
                                        break;
                                    case 4:
                                        String nuevaResena = s1.next();
                                        resenaSeleccionada.setResena(nuevaResena);
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            case 4:
                                System.out.println("Información de Autos");
                                cont = 0;
                                for (InfoAuto infoAuto : inf) {
                                    cont++;
                                    System.out.println("#############\n" + "Auto #" + cont);
                                    System.out.println("1. ID1: " + infoAuto.getId1());
                                    System.out.println("2. Placa: " + infoAuto.getPlaca());
                                    System.out.println("3. Modelo: " + infoAuto.getModelo());
                                    System.out.println("4. Número de Chasis: " + infoAuto.getNroChasis());
                                }

                                System.out.println("¿Qué registro desea modificar?");
                                int opIA = s1.nextInt();
                                InfoAuto infoAutoSeleccionado = inf.get(opIA);
                                System.out.println("Seleccionado. ¿Qué dato del registro desea cambiar?");
                                int iaRes = s1.nextInt();
                                System.out.println("Ingrese el nuevo dato:");

                                switch (iaRes) {
                                    case 1:
                                        int nuevoId1 = s1.nextInt();
                                        infoAutoSeleccionado.setId1(nuevoId1);
                                        break;
                                    case 2:
                                        String nuevaPlaca = s1.next();
                                        infoAutoSeleccionado.setPlaca(nuevaPlaca);
                                        break;
                                    case 3:
                                        String nuevoModelo = s1.next();
                                        infoAutoSeleccionado.setModelo(nuevoModelo);
                                        break;
                                    case 4:
                                        String nuevoNroChasis = s1.next();
                                        infoAutoSeleccionado.setNroChasis(nuevoNroChasis);
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            case 5:
                                System.out.println("Tickets de Soporte");
                                cont = 0;
                                for (TicketSoporte ticket : tickets) {
                                    cont++;
                                    System.out.println("#############\n" + "Ticket #" + cont);
                                    System.out.println("1. ID Empleado: " + ticket.getIdEmpleado());
                                    System.out.println("2. Email: " + ticket.getEmail());
                                    System.out.println("3. Descripción: " + ticket.getDescripcion());
                                }

                                System.out.println("¿Qué ticket desea modificar?");
                                int opTS = s1.nextInt();
                                TicketSoporte ticketSeleccionado = tickets.get(opTS);
                                System.out.println("Seleccionado. ¿Qué dato del ticket desea cambiar?");
                                int tsRes = s1.nextInt();
                                System.out.println("Ingrese el nuevo dato:");

                                switch (tsRes) {
                                    case 1:
                                        int nuevoIdEmpleado = s1.nextInt();
                                        ticketSeleccionado.setIdEmpleado(nuevoIdEmpleado);
                                        break;
                                    case 2:
                                        String nuevoEmail = s1.next();
                                        ticketSeleccionado.setEmail(nuevoEmail);
                                        break;
                                    case 3:
                                        String nuevaDescripcion = s1.next();
                                        ticketSeleccionado.setDescripcion(nuevaDescripcion);
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            case 6:
                                System.out.println("Modelos de Autos");
                                cont = 0;
                                for (ModeloAuto modeloAuto : modelos) {
                                    System.out.println("#############\n" + "Modelo de Auto #" + cont);
                                    System.out.println("1. Modelo: " + modeloAuto.getModelo());
                                    System.out.println("2. Color del Vehículo: " + modeloAuto.getColorVehiculo());
                                    cont++;
                                }

                                System.out.println("¿Qué modelo de auto desea modificar?");
                                int opMA = s1.nextInt();
                                ModeloAuto modeloAutoSeleccionado = modelos.get(opMA);
                                System.out.println("Seleccionado. ¿Qué dato del modelo de auto desea cambiar?");
                                int maRes = s1.nextInt();
                                System.out.println("Ingrese el nuevo dato:");

                                switch (maRes) {
                                    case 1:
                                        String nuevoModelo = s1.next();
                                        modeloAutoSeleccionado.setModelo(nuevoModelo);
                                        break;
                                    case 2:
                                        String nuevoColorVehiculo = s1.next();
                                        modeloAutoSeleccionado.setColorVehiculo(nuevoColorVehiculo);
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            case 7:
                                System.out.println("Viajes");
                                cont = 0;
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
                        System.out.println("Escoja la tabla donde eliminará entradas:"
                                + "1.Soporte Al Cliente.\n"
                                + "2.Usuario\n"
                                + "3.Reseña\n"
                                + "4.InfoAuto\n"
                                + "5.TicketSoporte\n"
                                + "6.Modelo Auto.\n"
                                + "7.Viaje\n"
                                + "8.Paradas\n"
                                + "9.Reservacion\n"
                                + "10.Ruta\n"
                                + "11.Pasajero.\n"
                                + "12.Conductor.\n"
                                + "13. VOLVER");
                        opcionMenuD = s1.nextInt();
                        switch (opcionMenuD) {
                            case 1:
                               
                                break;
                            case 2:
                                DB.deleteUser(s1);
                                break;
                            case 3:
                                
                                break;
                            case 4:
                                
                                break;
                            case 5:
                                
                                break;
                            case 6:
                                
                                break;
                            case 7:
                                
                                break;
                            case 8:
                                
                                break;
                            case 9:
                               
                                break;
                            case 10:
                                
                                break;
                            case 11:
                                
                                break;
                            case 12:
                                
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
