/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.bdavance2;
import java.lang.reflect.Field;
import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author seoklie
 */
public class BDavance2 {

    public static void main(String[] args) {
        
        ArrayList<SoporteCliente> soportes = new ArrayList<>();
        ArrayList<Usuario> usuarios= new ArrayList<>();
        ArrayList<Resena> resenas= new ArrayList<>();
        ArrayList<InfoAuto> inf= new ArrayList<>();
        ArrayList<TicketSoporte> tickets= new ArrayList<>();
        ArrayList<ModeloAuto> modelos= new ArrayList<>();
        ArrayList<Viaje> viajes= new ArrayList<>();
        ArrayList<Parada> paradas= new ArrayList<>();
        ArrayList<Reservacion> reser= new ArrayList<>();
        ArrayList<Ruta> rutas= new ArrayList<>();
        
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
                    System.out.println("Escoja la tabla donde añadirá datos:\n"
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
                    String id1 = s1.next();
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
                    System.out.println("Escoja la tabla donde editará datos:\n"
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
                        + "0. VOLVER");
                    opCons = s1.nextInt();
                    if(opCons == 1){
                        System.out.println("Soporte al Cliente");
                            Field[] fields = SoporteCliente.class.getDeclaredFields();
                            int cont = 0;
                            for(SoporteCliente sc : soportes){
                                System.out.println("SoporteCliente #" + (cont+1) + "\n#############");
                                System.out.println("IDSoporteCliente: "+sc.getIdEmpleado());
                            }
                            
                            System.out.println("¿Qué registro desea modificar?");
                            int regNum = s1.nextInt();
                            
                    }
            }
    }
}
}
}
