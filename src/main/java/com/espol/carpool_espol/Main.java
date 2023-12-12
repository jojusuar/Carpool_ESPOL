/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espol.carpool_espol;

import java.util.Scanner;

/**
 *
 * @author euclasio
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("CARPOOL*********************************");
            System.out.println("1. Mostrar usuarios registrados");
            System.out.println("2. Mostrar los viajes publicados");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("USUARIOS*********************************");
                    DB.printUsers();
                    break;
                case 2:
                    System.out.println("VIAJES***********************************");
                    DB.printTrips();
                    break;
                case 3:
                    System.out.println("Hasta la próxima!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
