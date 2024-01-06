package com.espol.carpool_espol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author euclasio
 */
public class DB {

    private static Connection connection;
    private static String url = "jdbc:mysql://proyecto-bd.mysql.database.azure.com:3306/carpool";
    private static String username = "carpoolAdmin";
    private static String password = "ProyectoParcial2";
    private static String usuarioactual = null;

    public static String getUsuarioactual() {
        return usuarioactual;
    }

    public static void setUsuarioactual(String usuarioactual) {
        DB.usuarioactual = usuarioactual;
    }

    public static void startConnection() {
        System.out.println("Conectando con la base de datos, espere un momento...");
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión establecida correctamente!");
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la base de datos. Reintentando...");
            startConnection();
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void newUser(Scanner scanner) {
        scanner.nextLine();
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "insert into usuario (email,contrasena,nombre,apellido,telefono) VALUES (?, ?, ?, ?, ?)";
            System.out.println("Ingrese un correo electrónico: ");
            String email = scanner.nextLine();
            System.out.println("Ingrese una contraseña: ");
            String contrasena = scanner.nextLine();
            System.out.println("Ingrese sus nombres: ");
            String name = scanner.nextLine();
            System.out.println("Ingrese sus apellidos: ");
            String lastname = scanner.nextLine();
            System.out.println("Ingrese un número telefónico: ");
            String phone = scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, contrasena);
                preparedStatement.setString(3, name);
                preparedStatement.setString(4, lastname);
                preparedStatement.setString(5, phone);

                // Ejecuta la inserción
                int rowsAffected = preparedStatement.executeUpdate();

                // devuelve el número de entradas añadidas
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCreditCard(Scanner scanner) {
        scanner.nextLine();
        try {
            System.out.println("Ingrese el email del usuario: ");
            String email = scanner.nextLine();
            System.out.println("Ingrese el número de tarjeta de crédito: ");
            String card = scanner.nextLine();
            String editQuery = "update usuario set espasajero=1 where email=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(editQuery)) {
                preparedStatement.setString(1, email);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Edit successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }

            String insertQuery = "insert into pasajero VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, card);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addBankAccount(Scanner scanner) {
        scanner.nextLine();
        try {
            System.out.println("Ingrese el email del usuario: ");
            String email = scanner.nextLine();
            System.out.println("Ingrese el número de su cuenta bancaria: ");
            String bank = scanner.nextLine();

            System.out.println("Ingrese la fecha de caducidad de su licencia de conducir (yyyy-mm-dd):");
            String caducidad = scanner.nextLine();

            String editQuery = "update usuario set esconductor=1 where email=?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(editQuery)) {
                preparedStatement.setString(1, email);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Edit successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }

            String insertQuery = "insert into conductor VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, bank);
                preparedStatement.setString(3, caducidad);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newClientSupport(Scanner scanner) {
        scanner.nextLine();
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "insert into soportealcliente (idempleado) VALUES (?)";
            System.out.println("Ingrese el ID del empleado: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, id);
                // Ejecuta la inserción
                int rowsAffected = preparedStatement.executeUpdate();

                // devuelve el número de entradas añadidas
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newCarModel(Scanner scanner) {
        scanner.nextLine();
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "insert into modeloauto VALUES (?, ?)";
            System.out.println("Ingrese el modelo del auto: ");
            String model = scanner.nextLine();
            System.out.println("Ingrese el color del auto: ");
            String color = scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, model);
                preparedStatement.setString(2, color);
                // Ejecuta la inserción
                int rowsAffected = preparedStatement.executeUpdate();

                // devuelve el número de entradas añadidas
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newRoute(Scanner scanner) {
        scanner.nextLine();
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "insert into ruta VALUES (?, ?, ?)";
            System.out.println("Ingrese el ID de la ruta: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el lugar de origen: ");
            String source = scanner.nextLine();
            System.out.println("Ingrese el lugar de destino: ");
            String target = scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, source);
                preparedStatement.setString(3, target);
                // Ejecuta la inserción
                int rowsAffected = preparedStatement.executeUpdate();

                // devuelve el número de entradas añadidas
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newStop(Scanner scanner) {
        scanner.nextLine();
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "insert into paradas(ubicacionparada, idruta) VALUES (?, ?)";
            System.out.println("Ingrese el ID de la ruta: ");
            int routeid = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el lugar de la parada: ");
            String location = scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, location);
                preparedStatement.setInt(2, routeid);
                // Ejecuta la inserción
                int rowsAffected = preparedStatement.executeUpdate();

                // devuelve el número de entradas añadidas
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newReview(Scanner scanner) {
        scanner.nextLine();
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "insert into resena VALUES (?, ?, ?, ?)";
            System.out.println("Ingrese el correo del usuario a reseñar: ");
            String reviewed = scanner.nextLine();
            System.out.println("Ingrese el correo de quien escribe la reseña: ");
            String reviewer = scanner.nextLine();
            System.out.println("Ingrese el ID de la reseña: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese la reseña: ");
            String review = scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, reviewed);
                preparedStatement.setString(2, reviewer);
                preparedStatement.setInt(3, id);
                preparedStatement.setString(4, review);
                // Ejecuta la inserción
                int rowsAffected = preparedStatement.executeUpdate();

                // devuelve el número de entradas añadidas
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newCarInfo(Scanner scanner) {
        scanner.nextLine();
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "insert into infoauto VALUES (?, ?, ?, ?)";
            System.out.println("InfoAuto");
            System.out.println("Ingrese el correo del conductor: ");
            String email = scanner.nextLine();
            System.out.println("Ingrese la placa del auto: ");
            String placa = scanner.next();
            System.out.println("Ingrese el modelo: ");
            String modelo = scanner.next();
            System.out.println("Ingrese Nro. Chasis: ");
            String nroChasis = scanner.next();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, placa);
                preparedStatement.setString(3, modelo);
                preparedStatement.setString(4, nroChasis);
                // Ejecuta la inserción
                int rowsAffected = preparedStatement.executeUpdate();

                // devuelve el número de entradas añadidas
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newSupportTicket(Scanner scanner) {
        scanner.nextLine();
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "insert into ticketsoporte VALUES (?, ?, ?)";
            System.out.println("Ingrese el ID del empleado: ");
            int idemployee = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el email del usuario: ");
            String email = scanner.nextLine();
            System.out.println("Ingrese el lugar de destino: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, idemployee);
                preparedStatement.setString(2, email);
                preparedStatement.setInt(3, id);
                // Ejecuta la inserción
                int rowsAffected = preparedStatement.executeUpdate();

                // devuelve el número de entradas añadidas
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newTrip(Scanner scanner) {
        scanner.nextLine();
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "insert into viaje VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            System.out.println("Ingrese el correo del conductor: ");
            String email = scanner.nextLine();
            System.out.println("Ingrese el ID del viaje: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el ID de la ruta: ");
            int routeid = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el precio: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Ingrese la tarifa: ");
            double tax = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Ingrese la hora de partida (hh:mm:ss): ");
            String hour = scanner.nextLine();
            System.out.println("Ingrese el estado del viaje: ");
            String status = scanner.nextLine();
            System.out.println("Ingrese los asientos disponibles: ");
            int seats = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese la novedad: ");
            String hiccups = scanner.nextLine();
            System.out.println("Ingrese la fecha del viaje (yyyy-mm-dd): ");
            String date = scanner.nextLine();
            System.out.println("Ingrese preferencias del viaje: ");
            String preferences = scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setInt(2, id);
                preparedStatement.setInt(3, routeid);
                preparedStatement.setDouble(4, price);
                preparedStatement.setDouble(5, tax);
                preparedStatement.setString(6, hour);
                preparedStatement.setString(7, status);
                preparedStatement.setInt(8, seats);
                preparedStatement.setString(9, hiccups);
                preparedStatement.setString(10, date);
                preparedStatement.setString(11, preferences);

                // Ejecuta la inserción
                int rowsAffected = preparedStatement.executeUpdate();

                // devuelve el número de entradas añadidas
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newReservation(Scanner scanner) {
        scanner.nextLine();
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "insert into reservacion VALUES (?, ?, ?, ?, ?)";
            System.out.println("Ingrese email: ");
            String email = scanner.next();
            System.out.println("Ingrese ID viaje: ");
            int idViaje = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese ID reserva: ");
            int idRes = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el detalle de la reserva: ");
            String detalle = scanner.next();
            System.out.println("Ingrese fecha de la reserva (yyyy-mm-dd): ");
            String fecha = scanner.next();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setInt(2, idViaje);
                preparedStatement.setInt(3, idRes);
                preparedStatement.setString(4, detalle);
                preparedStatement.setString(5, fecha);

                // Ejecuta la inserción
                int rowsAffected = preparedStatement.executeUpdate();

                // devuelve el número de entradas añadidas
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Insert failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean isWhitelisted(String s) {
        String[] whitelist = {"usuario", "viaje", "ticketsoporte", "resena", "soportealcliente", "pasajero", "conductor", "reservacion", "paradas", "ruta", "infoauto", "modeloauto"};
        for (String table : whitelist) {
            if (s.equals(table)) {
                return true;
            }
        }
        return false;
    }

    public static void deleteUser(Scanner scanner) {
        scanner.nextLine();
        String table = "usuario";
        String[] PKs = {"email"};
        System.out.println("Ingrese el correo del usuario: ");
        String email = scanner.nextLine();
        Object[] IDs = {email};
        deleteRow(table, PKs, IDs);
    }

    public static void deleteClientSupport(Scanner scanner) {
        scanner.nextLine();
        String table = "soportealcliente";
        String[] PKs = {"idempleado"};
        System.out.println("Ingrese el ID del empleado: ");
        Integer ID = scanner.nextInt();
        scanner.nextLine();
        Object[] IDs = {ID};
        deleteRow(table, PKs, IDs);
    }

    public static void deleteReview(Scanner scanner) {
        scanner.nextLine();
        String table = "resena";
        String[] PKs = {"correoReviewed", "correoReviewer", "idResena"};
        System.out.println("Ingrese el correo del usuario reseñado: ");
        String emailReviewed = scanner.nextLine();
        System.out.println("Ingrese el correo del usuario que escribió la reseña: ");
        String emailReviewer = scanner.nextLine();
        System.out.println("Ingrese el ID de la reseña: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Object[] IDs = {emailReviewed, emailReviewer, id};
        deleteRow(table, PKs, IDs);
    }
    
    public static void deleteCarInfo(Scanner scanner) {
        scanner.nextLine();
        String table = "infoauto";
        String[] PKs = {"email", "placa"};
        System.out.println("Ingrese el correo del conductor: ");
        String email = scanner.nextLine();
        System.out.println("Ingrese la placa del auto: ");
        String plate = scanner.nextLine();
        Object[] IDs = {email, plate};
        deleteRow(table, PKs, IDs);
    }
    
    public static void deleteSupportTicket(Scanner scanner) {
        scanner.nextLine();
        String table = "ticketsoporte";
        String[] PKs = {"idEmpleado", "email"};
        System.out.println("Ingrese el ID del asesor de soporte: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el correo del usuario: ");
        String email = scanner.nextLine();
        Object[] IDs = {id, email};
        deleteRow(table, PKs, IDs);
    }
    
    public static void deleteCarModel(Scanner scanner) {
        scanner.nextLine();
        String table = "modeloauto";
        String[] PKs = {"modelo"};
        System.out.println("Ingrese el modelo del auto: ");
        String model = scanner.nextLine();
        Object[] IDs = {model};
        deleteRow(table, PKs, IDs);
    }
    
    public static void deleteTrip(Scanner scanner) {
        scanner.nextLine();
        String table = "viaje";
        String[] PKs = {"conductor", "idviaje"};
        System.out.println("Ingrese el correo del conductor del viaje: ");
        String email = scanner.nextLine();
        System.out.println("Ingrese el ID del viaje: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Object[] IDs = {email, id};
        deleteRow(table, PKs, IDs);
    }
    
    public static void deleteStop(Scanner scanner) {
        scanner.nextLine();
        String table = "paradas";
        String[] PKs = {"idruta", "ubicacionparada"};
        System.out.println("Ingrese el ID de la ruta: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el lugar de la parada: ");
        String location = scanner.nextLine();
        Object[] IDs = {id, location};
        deleteRow(table, PKs, IDs);
    }
    
    public static void deleteReservation(Scanner scanner) {
        scanner.nextLine();
        String table = "reservacion";
        String[] PKs = {"email", "idviaje", "idreserva"};
        System.out.println("Ingrese el correo del pasajero: ");
        String email = scanner.nextLine();
        System.out.println("Ingrese el ID del viaje: ");
        Integer idviaje = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el ID de la reserva: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Object[] IDs = {email, idviaje, id};
        deleteRow(table, PKs, IDs);
    }
    
    public static void deleteRoute(Scanner scanner) {
        scanner.nextLine();
        String table = "ruta";
        String[] PKs = {"idruta"};
        System.out.println("Ingrese el ID de la ruta: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Object[] IDs = {id};
        deleteRow(table, PKs, IDs);
    }
    
    public static void deletePassenger(Scanner scanner) {
        scanner.nextLine();
        String table = "pasajero";
        String[] PKs = {"email"};
        System.out.println("Ingrese el correo del usuario: ");
        String email = scanner.nextLine();
        Object[] IDs = {email};
        deleteRow(table, PKs, IDs);
    }
    
    public static void deleteDriver(Scanner scanner) {
        scanner.nextLine();
        String table = "conductor";
        String[] PKs = {"email"};
        System.out.println("Ingrese el correo del usuario: ");
        String email = scanner.nextLine();
        Object[] IDs = {email};
        deleteRow(table, PKs, IDs);
    }
    
    

    private static void deleteRow(String table, String[] PKs, Object[] IDs) {
        if (!isWhitelisted(table)) {
            return;
        }
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "delete from " + table + " where " + PKs[0] + " = ?";
            if (PKs.length > 1) {
                for (int i = 1; i < PKs.length; i++) {
                    insertQuery += " and "+PKs[i]+" = ?";
                }
            }
            System.out.println(insertQuery);

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                for(int i=0; i < PKs.length; i++){
                  preparedStatement.setObject(i+1, IDs[i]);  
                }
                // Ejecuta la inserción
                int rowsAffected = preparedStatement.executeUpdate();

                // devuelve el número de entradas añadidas
                if (rowsAffected > 0) {
                    System.out.println("Delete successful. Rows affected: " + rowsAffected);
                } else {
                    System.out.println("Delete failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getUsers() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM usuario";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("email");
                        String contrasena = resultSet.getString("contrasena");
                        String name = resultSet.getString("nombre");
                        String lastname = resultSet.getString("apellido");
                        String phone = resultSet.getString("telefono");
                        int ispassenger = resultSet.getInt("espasajero");
                        int isdriver = resultSet.getInt("esconductor");
                        int score = resultSet.getInt("puntuacion");
                        System.out.println("Correo: " + email + " - Contraseña: " + contrasena + " - Nombres: " + name + " - Apellidos: " + lastname + " - Teléfono: " + phone + " - Es pasajero: " + ispassenger + " - Es conductor: " + isdriver + " - Puntuación: " + score);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getTrips() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM viaje";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        String driverid = resultSet.getString("conductor");
                        String id = resultSet.getString("idviaje");
                        String routeid = resultSet.getString("idruta");
                        Double price = resultSet.getDouble("precio");
                        Double tax = resultSet.getDouble("tarifa");
                        String time = resultSet.getString("hora");
                        String state = resultSet.getString("estado");
                        int seats = resultSet.getInt("asientosdisponibles");
                        String issues = resultSet.getString("novedad");
                        String date = resultSet.getString("fecha");
                        String preferences = resultSet.getString("preferencias");
                        System.out.println("Fecha del viaje: " + date + "ID Conductor: " + driverid + " - ID Viaje: " + id + " - ID Ruta: " + routeid + " - Precio: " + price + " - Tarifa: " + tax + " - Hora de salida: " + time + " - Estado del viaje: " + state + " - Asientos disponibles: " + seats + " - Novedades: " + issues + " - Preferencias: " + preferences);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getmodeloauto(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM modeloauto";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        String modelo = resultSet.getString("modelo");
                        String colorvehiculo = resultSet.getString("colorvehiculo");
                        System.out.println("Modelo del carro: "+modelo+"Color: "+(colorvehiculo != null ? colorvehiculo : "N/A"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getTicketSoporte(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM ticketsoporte";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        int idEmpleado = resultSet.getInt("idEmpleado");
                        String email = resultSet.getString("email");
                        String descripcion = resultSet.getString("descripcion");
                        System.out.println("ID Empleado Encargado: "+idEmpleado+" Email: "+email+" Descripción:"+ (descripcion != null ? descripcion : "N/A"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getParadas(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM paradas";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        int idruta = resultSet.getInt("idruta");
                        String ubicacionparada = resultSet.getString("ubicacionparada");
                        System.out.println("ID Ruta Asignada: "+idruta+" Parada: "+ubicacionparada);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getReservacion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM reservacion";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("email");
                        int idviaje = resultSet.getInt("idviaje");
                        int idreserva = resultSet.getInt("idreserva");
                        String detalle = resultSet.getString("detalle");
                        Timestamp timestamp = resultSet.getTimestamp("fecha");
                        String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
                        System.out.println("Email del Pasajero: "+email+" ID viaje: "+idviaje+" ID reserva: "+idreserva+" Detalles: "+(detalle != null ? detalle : "N/A")+" Fecha: "+fecha);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getRuta(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM ruta";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        int idruta = resultSet.getInt("idruta");
                        String origen = resultSet.getString("origen");
                        String destino = resultSet.getString("destino");
                        System.out.println("ID de la ruta: "+idruta+" ID viaje: "+(origen != null ? origen : "N/A")+" ID reserva: "+(destino != null ? destino : "N/A"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getPasajero(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM pasajero";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("email");
                        String tarjetapago = resultSet.getString("tarjetapago");
                        System.out.println("Email del pasajero: "+email+" Tarjeta asociada: "+tarjetapago);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getConductor(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM conductor";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("email");
                        String cuentabancaria = resultSet.getString("cuentabancaria");
                        String caducidadlicencia = resultSet.getString("caducidadlicencia");
                        System.out.println("Email del conductor: "+email+" Cuenta asociada: "+(cuentabancaria != null ? cuentabancaria : "N/A")+" Caducidad de la Licencia: "+(caducidadlicencia != null ? caducidadlicencia : "N/A"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getInfoAuto(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM infoauto";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("email");
                        String placa = resultSet.getString("placa");
                        String modelo = resultSet.getString("modelo");
                        String nrochasis = resultSet.getString("nrochasis");
                        System.out.println("Email del conductor: "+email+" Placa: "+placa+" Modelo: "+modelo+" NRO de Chasis: "+nrochasis);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}