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
    public static void mostrarMenu(){
        Scanner s2 = new Scanner(System.in);
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
                        + "11. VOLVER");
    }
    public static int mostrarDatosConsulta(Scanner s2, Object o){
                    Class clase = o.getClass();
                    System.out.println("Dato a consultar: ");
                    Field[] fields = clase.getDeclaredFields();
                    int contador = 1;
                    for(Field f : fields){
                        System.out.println(contador +". "+ f.getName());
                        contador++;
                    }
                    int op1 = s2.nextInt();                
                    return op1;
    }
    
    public static int comparaciones(Scanner s2){
        System.out.println("Consultar por:\n"
                            + "1.Mayor que x valor.\n"
                            + "2. Menor que x valor.\n"
                            + "3. Igual que x valor.\n"
                            + "4. Acabar filtrado."); 
        int op2 = s2.nextInt();
        return op2;
    }
    
    public static void consultarDatos(int opcion){
        Scanner s2 = new Scanner(System.in);
        
        switch(opcion){
            case 1:
                System.out.println("Ingrese el ID a buscar: ");
                int id = s2.nextInt();
                if(BDavance2.soportes.isEmpty())
                    System.out.println("No existen valores a mostrar.");
                else{
                for(SoporteCliente sc : BDavance2.soportes){
                    if(sc.getIdEmpleado()==id)
                        System.out.println("Existe.");
                    else
                        System.out.println("No encontrado.");
                }
                }
                break;
                
                
            case 2:
                    boolean sigueCorriendo = true;
                    while(sigueCorriendo==true){
                    ArrayList<Usuario> uss = new ArrayList<>();
                    Usuario us= new Usuario(0,tipoUsuario.CONDUCTOR,"","","","","",0.0);
                    int op1 = Menu.mostrarDatosConsulta(s2,us);
                    int op2 = Menu.comparaciones(s2);
                    if(!BDavance2.usuarios.isEmpty()){
                    if(0 < op2 && op2 < 8){
                        System.out.println("Ingrese valor a comparar: ");
                        String igualB = s2.next();
                        if(op1==3){
                            for(Usuario u:BDavance2.usuarios){
                                Usuario.desglosarAtributos(u);
                                if(Usuario.obtenerAtributo(u, op2, igualB)){
                                    uss.add(u);
                                }
                                else{
                                    System.out.println("No se encontraron registros.");
                                }
                            }
                        }
                        else{
                            System.out.println("No es posible realizar la operacion.");
                            break;
                        }
                    }
                    else if(op2==8){
                        System.out.println("Ingrese el valor a comparar: ");
                                int valor = s2.nextInt();
                                for(Usuario u: BDavance2.usuarios){
                                    boolean res = Usuario.compararAtributo(u,op1,valor);
                                    if (res==true)
                                        uss.add(u);
                                }
                        }
                    else
                        sigueCorriendo = false;
                    }
                        else
                            System.out.println("No existen valores a mostrar.");
                    }
                    break;
            case 3:
                    Resena r = new Resena("","",0,"");
                    int op1= Menu.mostrarDatosConsulta(s2,r);
                    int op2 = Menu.comparaciones(s2);

        }
        }
    }
