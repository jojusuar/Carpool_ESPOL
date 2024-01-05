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
    static ArrayList<Usuario> usuarios= new ArrayList<>();
    static ArrayList<Resena> resenas= new ArrayList<>();
    static ArrayList<InfoAuto> inf= new ArrayList<>();
    static ArrayList<TicketSoporte> tickets= new ArrayList<>();
    static ArrayList<ModeloAuto> modelos= new ArrayList<>();
    static ArrayList<Viaje> viajes= new ArrayList<>();
    static ArrayList<Parada> paradas= new ArrayList<>();
    static ArrayList<Reservacion> reser= new ArrayList<>();
    static ArrayList<Ruta> rutas= new ArrayList<>();
    
    public static void main(String[] args) {
        
        System.out.println("---MENU---");
        Scanner s1 = new Scanner(System.in);
        int opcionMenuP=0;
        
        //PARA ANADIR
        while(opcionMenuP!=4){
            System.out.println("ESCOJA UNA OPCIÓN:\n"
                    + "1.Añadir datos.\n"
                    + "2.Editar datos\n"
                    + "3.Consultar datos.\n"
                    + "3.Eliminar datos\n"
                    + "4.SALIR");
            opcionMenuP = s1.nextInt();
            if(opcionMenuP == 1){
                int opcionMenuA=0;
                while(opcionMenuA!=11){
                    System.out.println("Escoja la tabla donde añadirá datos:"
                        + "1.Soporte Al Cliente.\n"
                        + "2. Usuario\n"
                        + "3.Reseña\n"
                        + "4.InfoAuto\n"
                        + "5.TicketSoporte\n"
                        + "6.Modelo Auto.\n"
                        + "7.Viaje\n"
                        + "8.Paradas\n"
                        + "9.Reservacion\n"
                        + "10.Ruta\n"
                        + "11. VOLVER");
                        opcionMenuA= s1.nextInt();


                //SOPORTE AL CLIENTE
                if(opcionMenuA==1){
                    System.out.println("Soporte al cliente");
                    System.out.println("..................");
                    System.out.println("Ingrese ID empleado: ");
                    int idEmp = s1.nextInt();
                    SoporteCliente sc = new SoporteCliente(idEmp);
                    soportes.add(sc);
                }
                // USUARIO
                else if(opcionMenuA==2){
                    Usuario u= null;
                    System.out.println("Usuario");
                    System.out.println("..................");
                    System.out.println("Ingrese ID: ");
                    int id = s1.nextInt();
                    System.out.println("1. PASAJERO o 2. CONDUCTOR");
                    int op = s1.nextInt();
                    System.out.println("Email: ");
                    String email = s1.next();
                    System.out.println("Password: ");
                    String pword = s1.next();
                    System.out.println("Nombre: ");
                    String nombre = s1.next();
                    System.out.println("Apellido: ");
                    String apellido = s1.next();
                    System.out.println("Telefono: ");
                    String telf = s1.next();
                    System.out.println("Puntuacion: ");
                    double punt = s1.nextDouble();
                    if(op == 1){
                        u = new Usuario(id,tipoUsuario.PASAJERO,email,pword,nombre,apellido,telf,punt);
                        usuarios.add(u);
                    }
                    else if(op==2){
                        u = new Usuario(id,tipoUsuario.CONDUCTOR,email,pword,nombre,apellido,telf,punt);
                        usuarios.add(u);
                    }
                    else{
                        System.out.println("No aplica."); //ingreso otro valor diferente a 1 o 2
                    }
                    
                }
                //RESENA
                else if(opcionMenuA == 3){
                    System.out.println("Reseña");
                    Resena r;
                    System.out.println("Ingrese el usuario de origen: ");
                    String id2 = s1.next();
                    System.out.println("Ingrese el usuario de destinatario: ");
                    String id1 = s1.next();
                    System.out.println("Ingrese ID reseña: ");
                    int idResena = s1.nextInt();
                    System.out.println("Ingrese la reseña: ");
                    String resena = s1.next();
                    r = new Resena(id1,id2,idResena,resena);
                    resenas.add(r);
                }
                else if(opcionMenuA == 4){
                    InfoAuto ia;
                    System.out.println("InfoAuto");
                    System.out.println("Ingrese ID de la cuenta: ");
                    int id1 = s1.nextInt();
                    System.out.println("Ingrese la placa del auto: ");
                    String placa = s1.next();
                    System.out.println("Ingrese el modelo: ");
                    String modelo = s1.next();
                    System.out.println("Ingrese Nro. Chasis: ");
                    String nroChasis = s1.next();
                    ia = new InfoAuto(id1,placa,modelo,nroChasis);
                    inf.add(ia);
                }
                else if (opcionMenuA==5){
                    TicketSoporte ts;
                    System.out.println("Ticket Soporte");
                    System.out.println("Ingrese ID empleado: ");
                    int id1 = s1.nextInt();
                    System.out.println("Ingrese email: ");
                    String email = s1.next();
                    System.out.println("Ingrese la descripción del ticket: ");
                    String desc = s1.next();
                    ts = new TicketSoporte(id1,email,desc);
                    tickets.add(ts);

                }
                else if (opcionMenuA==6){
                    ModeloAuto ma;
                    System.out.println("Modelo Auto");
                    System.out.println("Ingrese el modelo: ");
                    String modelo = s1.next();
                    System.out.println("Ingrese el color del Vehiculo: ");
                    String color = s1.next();

                    ma = new ModeloAuto(modelo,color);
                    modelos.add(ma);
                }
                else if(opcionMenuA==9){
                    Reservacion r;
                    System.out.println("Reservacion");
                    System.out.println("Ingrese email: ");
                    String email = s1.next();
                    System.out.println("Ingrese ID viaje: ");
                    int idViaje = s1.nextInt();
                    System.out.println("Ingrese ID reserva: ");
                    int idRes = s1.nextInt();
                    System.out.println("Ingrese el detalle de la reserva: ");
                    String detalle= s1.next();
                    System.out.println("Ingrese fecha de la reserva: ");
                    String fecha= s1.next();

                    r = new Reservacion(email,idViaje,idRes,detalle,fecha);
                    reser.add(r);
                }
                else if(opcionMenuA==7){
                    Viaje v;

                    System.out.println("Viaje");
                    System.out.println("Ingrese el ID del conductor: ");
                    int idCond = s1.nextInt();
                    System.out.println("Ingrese el ID del viaje: ");
                    int idViaje = s1.nextInt();
                    System.out.println("Ingrese el ID de la ruta: ");
                    int idRuta = s1.nextInt();
                    System.out.println("Ingrese el precio: ");
                    double precio = s1.nextDouble();
                    System.out.println("Ingrese la tarifa: ");
                    double tarifa = s1.nextDouble();
                    System.out.println("Ingrese la hora: ");
                    String hora= s1.next();
                    System.out.println("Ingrese el estado: ");
                    Estado estado = Estado.valueOf(s1.next());
                    System.out.println("Asientos disponibles: ");
                    int asientos = s1.nextInt();
                    System.out.println("Ingrese la novedad: ");
                    String novedad = s1.next();
                    System.out.println("Ingrese la fecha (DD/MM/AA): ");
                    String fecha = s1.next();
                    System.out.println("Ingrese preferencias: ");
                    String preferencias = s1.next();

                    v = new Viaje(idCond,idViaje,idRuta,precio,tarifa,hora,estado,asientos,novedad,fecha,preferencias);
                    viajes.add(v);
                }
                else if(opcionMenuA==10){
                    Ruta r;
                    System.out.println("Ruta");

                    System.out.println("Ingrese ID ruta: ");
                    int idRuta = s1.nextInt();
                    System.out.println("Ingrese el origen de la ruta: ");
                    String origen = s1.next();
                    System.out.println("Ingrese el destino de la ruta: ");
                    String destino = s1.next();

                    r = new Ruta(idRuta,origen,destino);
                    rutas.add(r);
                }
                else if(opcionMenuA == 8){
                    Parada p;
                    System.out.println("Parada");
                    ArrayList<String> paradasArray = new ArrayList<>();

                    System.out.println("Ingrese la ID de la ruta: ");
                    int idRuta = s1.nextInt();
                    System.out.println("Ingrese el # de paradas: ");
                    int b = s1.nextInt();
                    for(int i=1; i<b+1;i++){
                        System.out.println("Ingrese la parada #" + i +": ");
                        String parada1 = s1.next();
                        paradasArray.add(parada1);
                    }
                    p = new Parada(idRuta,paradasArray);     
                    paradas.add(p);
                }
            }
        }
            //opcion CONSULTAR
            else if(opcionMenuP==2){
                int opCons = 0;
                while (opCons!=11){
                    Menu.mostrarMenu();
                    opCons = s1.nextInt();
                    switch(opCons){
                        case 1:
                        System.out.println("Soporte al Cliente");
                            int cont = 0;
                            for(SoporteCliente sc : soportes){
                                cont++;
                                System.out.println("#############\n"+"Soporte al cliente #" + cont);
                                System.out.println("IDSoporteCliente: "+sc.getIdEmpleado());
                            }
                            
                            System.out.println("¿Qué registro desea modificar?");
                            int regNum = s1.nextInt();
                            SoporteCliente sc1 = soportes.get(regNum);
                            System.out.println("Seleccionado. ¿Qué dato quiere cambiar?\n1) ID.");
                            int opsc1 = s1.nextInt();
                            if(opsc1 == 1){
                                System.out.println("Ingrese el nuevo dato: ");
                                int nuevoid = s1.nextInt();
                                sc1.setIdEmpleado(nuevoid);
                            }
                        case 2:
                            System.out.println("Usuarios");
                            cont = 0;
                            for(Usuario u : usuarios){
                                cont++;
                                System.out.println("#############\n"+"Usuario #" + cont);
                                System.out.println("1. IDUsuario: "+u.getId());
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
                            switch(usRes){
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
                                System.out.println("#############\n" + "Auto #" +cont);
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
                                System.out.println("#############\n" + "Parada #" +cont);
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
         }
            else if(opcionMenuP == 3){
                System.out.println("Ingrese tabla a consultar:");
                Menu.mostrarMenu();
                int opConsultar = s1.nextInt();
                Menu.consultarDatos(opConsultar);
            }
    }
}
}
