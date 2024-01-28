package com.espol.carpool_espol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "CALL insertarUsuario(?, ?, ?, ?, ?)";
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

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCreditCard(Scanner scanner) {
        try {
            System.out.println("Ingrese el email del usuario: ");
            String email = scanner.nextLine();
            System.out.println("Ingrese el número de tarjeta de crédito: ");
            String card = scanner.nextLine();
            String insertQuery = "CALL hacerPasajero(?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, card);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addBankAccount(Scanner scanner) {
        try {
            System.out.println("Ingrese el email del usuario: ");
            String email = scanner.nextLine();
            System.out.println("Ingrese el número de su cuenta bancaria: ");
            String bank = scanner.nextLine();

            System.out.println("Ingrese la fecha de caducidad de su licencia de conducir (yyyy-mm-dd):");
            String caducidad = scanner.nextLine();

            String insertQuery = "CALL hacerConductor(?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, bank);
                preparedStatement.setString(3, caducidad);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newClientSupport(Scanner scanner) {
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "CALL insertarEmpleadoSoporte(?)";
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
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "CALL insertarModeloAuto(?, ?)";
            System.out.println("Ingrese el modelo del auto: ");
            String model = scanner.nextLine();
            System.out.println("Ingrese el color del auto: ");
            String color = scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, model);
                preparedStatement.setString(2, color);
                // Ejecuta la inserción
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newRoute(Scanner scanner) {
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "CALL insertarRuta(?, ?, ?)";
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
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newStop(Scanner scanner) {
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "CALL insertarParada(?, ?)";
            System.out.println("Ingrese el ID de la ruta: ");
            int routeid = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el lugar de la parada: ");
            String location = scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, routeid);
                preparedStatement.setString(2, location);
                // Ejecuta la inserción
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newReview(Scanner scanner) {
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "CALL insertarResena(?, ?, ?, ?)";
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
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newCarInfo(Scanner scanner) {
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "CALL insertarInfoAuto(?, ?, ?, ?)";
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
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newSupportTicket(Scanner scanner) {
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "CALL insertarTicketSoporte(?, ?, ?)";
            System.out.println("Ingrese el ID del empleado: ");
            int idemployee = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el email del usuario: ");
            String email = scanner.nextLine();
            System.out.println("Ingrese la descripcion: ");
            String description = scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, idemployee);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, description);
                // Ejecuta la inserción
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newTrip(Scanner scanner) {
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "CALL insertarViaje(?, ?, ?, ?, ?, ?, ?)";
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
            System.out.println("Ingrese el estado del viaje: ");
            String status = scanner.nextLine();
            System.out.println("Ingrese los asientos disponibles: ");
            int seats = scanner.nextInt();
            scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setInt(2, id);
                preparedStatement.setInt(3, routeid);
                preparedStatement.setDouble(4, price);
                preparedStatement.setDouble(5, tax);
                preparedStatement.setString(6, status);
                preparedStatement.setInt(7, seats);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newReservation(Scanner scanner) {
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "CALL insertarReservacion(?, ?, ?, ?)";
            System.out.println("Ingrese email: ");
            String email = scanner.next();
            System.out.println("Ingrese ID viaje: ");
            int idViaje = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese ID reserva: ");
            int idRes = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese fecha de la reserva (yyyy-mm-dd): ");
            String fecha = scanner.nextLine();

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, email);
                preparedStatement.setInt(2, idViaje);
                preparedStatement.setInt(3, idRes);
                preparedStatement.setString(4, fecha);
                preparedStatement.executeUpdate();
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
        String table = "usuario";
        String[] PKs = {"email"};
        System.out.println("Ingrese el correo del usuario: ");
        String email = scanner.nextLine();
        Object[] IDs = {email};
        deleteRow(table, PKs, IDs);
    }

    public static void deleteClientSupport(Scanner scanner) {
        String table = "soportealcliente";
        String[] PKs = {"idempleado"};
        System.out.println("Ingrese el ID del empleado: ");
        Integer ID = scanner.nextInt();
        scanner.nextLine();
        Object[] IDs = {ID};
        deleteRow(table, PKs, IDs);
    }

    public static void deleteReview(Scanner scanner) {
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
        String table = "modeloauto";
        String[] PKs = {"modelo"};
        System.out.println("Ingrese el modelo del auto: ");
        String model = scanner.nextLine();
        Object[] IDs = {model};
        deleteRow(table, PKs, IDs);
    }

    public static void deleteTrip(Scanner scanner) {
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
        String table = "ruta";
        String[] PKs = {"idruta"};
        System.out.println("Ingrese el ID de la ruta: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Object[] IDs = {id};
        deleteRow(table, PKs, IDs);
    }

    public static void deletePassenger(Scanner scanner) {
        String table = "pasajero";
        String[] PKs = {"email"};
        System.out.println("Ingrese el correo del usuario: ");
        String email = scanner.nextLine();
        Object[] IDs = {email};
        deleteRow(table, PKs, IDs);
    }

    public static void deleteDriver(Scanner scanner) {
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
                    insertQuery += " and " + PKs[i] + " = ?";
                }
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                for (int i = 0; i < PKs.length; i++) {
                    preparedStatement.setObject(i + 1, IDs[i]);
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

    public static void editUser(Scanner scanner) {
        String table = "usuario";
        String[] PKs = {"email"};
        System.out.println("Ingrese el correo del usuario: ");
        String correo = scanner.nextLine();
        Object[] IDs = {correo};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlQuery = "SELECT * FROM " + table + " where " + PKs[0] + " = ?";
            if (PKs.length > 1) {
                for (int i = 1; i < PKs.length; i++) {
                    sqlQuery += " and " + PKs[i] + " = ?";
                }
            }
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                for (int i = 0; i < PKs.length; i++) {
                    statement.setObject(i + 1, IDs[i]);
                }
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("email");
                        String contrasena = resultSet.getString("contrasena");
                        String name = resultSet.getString("nombre");
                        String lastname = resultSet.getString("apellido");
                        String phone = resultSet.getString("telefono");
                        int ispassenger = resultSet.getInt("espasajero");
                        int isdriver = resultSet.getInt("esconductor");
                        int score = resultSet.getInt("puntuacion");
                        System.out.println("Correo: " + email + "\n"
                                + "Seleccione el campo a editar" + "\n" + "1. Contraseña: " + contrasena + "\n" + "2. Nombres: " + name + "\n" + "3. Apellidos: " + lastname + "\n" + "4. Teléfono: " + phone + "\n" + "5. Es pasajero: " + ispassenger + "\n" + "6. Es conductor: " + isdriver + "\n" + "7. Puntuación: " + score + "\n" + "8. CANCELAR" + "\n");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1: {
                                System.out.println("Ingrese la nueva contraseña: ");
                                String contrasena2 = scanner.nextLine();
                                String field = "contrasena";
                                updateField(scanner, table, field, contrasena2, PKs, IDs);
                                break;
                            }

                            case 2: {
                                System.out.println("Ingrese los nuevos nombres: ");
                                String name2 = scanner.nextLine();
                                String field = "nombre";
                                updateField(scanner, table, field, name2, PKs, IDs);
                                break;
                            }
                            case 3: {
                                System.out.println("Ingrese los nuevos apellidos: ");
                                String surname2 = scanner.nextLine();
                                String field = "apellido";
                                updateField(scanner, table, field, surname2, PKs, IDs);
                                break;
                            }
                            case 4: {
                                System.out.println("Ingrese el nuevo telefono: ");
                                String phone2 = scanner.nextLine();
                                String field = "telefono";
                                updateField(scanner, table, field, phone2, PKs, IDs);
                                break;
                            }
                            case 5: {
                                System.out.println("es conductor? 0/1: ");
                                Integer bool = scanner.nextInt();
                                scanner.nextLine();
                                String field = "esconductor";
                                updateField(scanner, table, field, bool, PKs, IDs);
                                break;
                            }
                            case 6: {
                                System.out.println("es pasajero? 0/1: ");
                                Integer bool = scanner.nextInt();
                                scanner.nextLine();
                                String field = "espasajero";
                                updateField(scanner, table, field, bool, PKs, IDs);
                                break;
                            }
                            case 7: {
                                System.out.println("Ingresar puntuacion: ");
                                Integer rating = scanner.nextInt();
                                scanner.nextLine();
                                String field = "puntuacion";
                                updateField(scanner, table, field, rating, PKs, IDs);
                                break;
                            }
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Usuario no encontrado");
        }

    }

    public static void editSupportTicket(Scanner scanner) {
        String table = "ticketsoporte";
        String[] PKs = {"idEmpleado", "email"};
        System.out.println("Ingrese el ID del empleado de soporte: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el correo del usuario: ");
        String correo = scanner.nextLine();
        Object[] IDs = {id, correo};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlQuery = "SELECT * FROM " + table + " where " + PKs[0] + " = ?";
            if (PKs.length > 1) {
                for (int i = 1; i < PKs.length; i++) {
                    sqlQuery += " and " + PKs[i] + " = ?";
                }
            }
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                for (int i = 0; i < PKs.length; i++) {
                    statement.setObject(i + 1, IDs[i]);
                }
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Integer idempleado = resultSet.getInt("idempleado");
                        String email = resultSet.getString("email");
                        String descripcion = resultSet.getString("descripcion");
                        System.out.println("ID del empleado de soporte: " + idempleado + "\n"
                                + "Correo del usuario: " + email + "\n"
                                + "Seleccione el campo a editar" + "\n" + "1. Descripción: " + descripcion + "2. CANCELAR" + "\n");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1: {
                                System.out.println("Ingrese la nueva descripción: ");
                                String descripcion2 = scanner.nextLine();
                                String field = "descripcion";
                                updateField(scanner, table, field, descripcion2, PKs, IDs);
                                break;
                            }

                            default:
                                break;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ticket de Soporte no encontrado");
        }

    }

    private static void updateField(Scanner scanner, String table, String field, Object change, String[] PKs, Object[] IDs) {
        try {
            // Query parametrizado para evitar ataques de SQL injection
            String insertQuery = "update " + table + " set " + field + " = ? where " + PKs[0] + "= '" + IDs[0] + "'";
            if (PKs.length > 1) {
                for (int i = 1; i < PKs.length; i++) {
                    insertQuery += " and " + PKs[i] + " = '" + IDs[i] + "'";
                }
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setObject(1, change);

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

    public static void getmodeloauto() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM modeloauto";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        String modelo = resultSet.getString("modelo");
                        String colorvehiculo = resultSet.getString("colorvehiculo");
                        System.out.println("Modelo del carro: " + modelo + "Color: " + (colorvehiculo != null ? colorvehiculo : "N/A"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getTicketSoporte() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM ticketsoporte";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        int idEmpleado = resultSet.getInt("idEmpleado");
                        String email = resultSet.getString("email");
                        String descripcion = resultSet.getString("descripcion");
                        System.out.println("ID Empleado Encargado: " + idEmpleado + " Email: " + email + " Descripción:" + (descripcion != null ? descripcion : "N/A"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getParadas() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM paradas";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        int idruta = resultSet.getInt("idruta");
                        String ubicacionparada = resultSet.getString("ubicacionparada");
                        System.out.println("ID Ruta Asignada: " + idruta + " Parada: " + ubicacionparada);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getReservacion() {
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
                        System.out.println("Email del Pasajero: " + email + " ID viaje: " + idviaje + " ID reserva: " + idreserva + " Detalles: " + (detalle != null ? detalle : "N/A") + " Fecha: " + fecha);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getRuta() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM ruta";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        int idruta = resultSet.getInt("idruta");
                        String origen = resultSet.getString("origen");
                        String destino = resultSet.getString("destino");
                        System.out.println("ID de la ruta: " + idruta + " ID viaje: " + (origen != null ? origen : "N/A") + " ID reserva: " + (destino != null ? destino : "N/A"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getPasajero() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM pasajero";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("email");
                        String tarjetapago = resultSet.getString("tarjetapago");
                        System.out.println("Email del pasajero: " + email + " Tarjeta asociada: " + tarjetapago);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getConductor() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM conductor";
                try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("email");
                        String cuentabancaria = resultSet.getString("cuentabancaria");
                        String caducidadlicencia = resultSet.getString("caducidadlicencia");
                        System.out.println("Email del conductor: " + email + " Cuenta asociada: " + (cuentabancaria != null ? cuentabancaria : "N/A") + " Caducidad de la Licencia: " + (caducidadlicencia != null ? caducidadlicencia : "N/A"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getInfoAuto() {
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
                        System.out.println("Email del conductor: " + email + " Placa: " + placa + " Modelo: " + modelo + " NRO de Chasis: " + nrochasis);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editReview(Scanner scanner) {
        String table = "resena";
        String[] PKs = {"correoReviewed", "correoReviewer", "idResena"};
        System.out.println("Ingrese el ID de la reseña: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el correo del usuario que envió la reseña: ");
        String correoReviewed = scanner.nextLine();
        System.out.println("Ingrese el correo del usuario que recibió la reseña: ");
        String correoReviewer = scanner.nextLine();
        Object[] IDs = {id, correoReviewer, correoReviewed};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlQuery = "SELECT * FROM " + table + " where " + PKs[0] + " = ?";
            if (PKs.length > 1) {
                for (int i = 1; i < PKs.length; i++) {
                    sqlQuery += " and " + PKs[i] + " = ?";
                }
            }
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                for (int i = 0; i < PKs.length; i++) {
                    statement.setObject(i + 1, IDs[i]);
                }
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String correoReseniado = resultSet.getString("correoReviewed");
                        String correoReseniador = resultSet.getString("correoReviewer");
                        int idReview = resultSet.getInt("idResena");
                        String review = resultSet.getString("resena");
                        System.out.println("ID de la reseña: " + idReview + "\n"
                                + "Correo del usuario reseñado: " + correoReseniado + "\n"
                                + "Correo del usuario reseñador: " + correoReseniador + "\n"
                                + "Seleccione el campo a editar" + "\n" + "1. Reseña: " + review + "\n" + "2. CANCELAR" + "\n");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1: {
                                System.out.println("Ingrese la nueva reseña: ");
                                String review2 = scanner.nextLine();
                                String field = "resena";
                                updateField(scanner, table, field, review2, PKs, IDs);
                                break;
                            }

                            default:
                                break;
                        }

                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Reseña no encontrada");
        }

    }

    public static void editConductor(Scanner scanner) {
        String table = "conductor";
        String[] PKs = {"email"};
        System.out.println("Ingrese el correo del conductor: ");
        String correo = scanner.nextLine();
        Object[] IDs = {correo};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlQuery = "SELECT * FROM " + table + " where " + PKs[0] + " = ?";
            if (PKs.length > 1) {
                for (int i = 1; i < PKs.length; i++) {
                    sqlQuery += " and " + PKs[i] + " = ?";
                }
            }
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                for (int i = 0; i < PKs.length; i++) {
                    statement.setObject(i + 1, IDs[i]);
                }
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("email");
                        String cuentaBancaria = resultSet.getString("cuentabancaria");
                        Timestamp caducidadLicencia = resultSet.getTimestamp("caducidadLicencia");
                        String caducidad = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(caducidadLicencia);
                        System.out.println("Correo del conductor: " + email + "\n"
                                + "Seleccione el campo a editar" + "\n" + "1. Cuenta bancaria: " + cuentaBancaria + "\n" + "2. Caducidad licencia" + caducidad + "\n" + "3. CANCELAR" + "\n");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1: {
                                System.out.println("Ingrese la nueva cuenta bancaria: ");
                                String cuentaBancaria2 = scanner.nextLine();
                                String field = "cuentabancaria";
                                updateField(scanner, table, field, cuentaBancaria2, PKs, IDs);
                                break;
                            }
                            case 2:
                                System.out.println("Ingrese la nueva caducidad de licencia (formato: yyyy-MM-dd HH:mm:ss): ");
                                String caducidadInput = scanner.nextLine();
                                String field = "caducidadLicencia";

                                try {
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    Date caducidadDate = dateFormat.parse(caducidadInput);

                                    updateField(scanner, table, field, caducidadDate, PKs, IDs);

                                } catch (ParseException e) {
                                    System.out.println("Formato de fecha y hora incorrecto. Por favor, use yyyy-MM-dd HH:mm:ss");
                                }

                                break;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conductor no encontrado");
        }

    }

    public static void editPasajero(Scanner scanner) {
        String table = "pasajero";
        String[] PKs = {"email"};
        System.out.println("Ingrese el correo del pasajero: ");
        String correo = scanner.nextLine();
        Object[] IDs = {correo};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlQuery = "SELECT * FROM " + table + " where " + PKs[0] + " = ?";
            if (PKs.length > 1) {
                for (int i = 1; i < PKs.length; i++) {
                    sqlQuery += " and " + PKs[i] + " = ?";
                }
            }
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                for (int i = 0; i < PKs.length; i++) {
                    statement.setObject(i + 1, IDs[i]);
                }
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("email");
                        String tarjetaPago = resultSet.getString("tarjetapago");
                        System.out.println("Correo del conductor: " + email + "\n"
                                + "Seleccione el campo a editar" + "\n" + "1. Tarjeta de pago: " + tarjetaPago + "\n" + "2. CANCELAR" + "\n");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1: {
                                System.out.println("Ingrese la nueva tarjeta de pago: ");
                                String tarjeta2 = scanner.nextLine();
                                String field = "tarjetapago";
                                updateField(scanner, table, field, tarjeta2, PKs, IDs);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Pasajero no encontrado");
        }

    }

    public static void editInfoAuto(Scanner scanner) {
        String table = "infoauto";
        String[] PKs = {"email", "placa"};
        System.out.println("Ingrese el correo del dueño: ");
        String correo = scanner.nextLine();
        System.out.println("Ingrese la placa del auto: ");
        String placa = scanner.nextLine();
        Object[] IDs = {correo, placa};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlQuery = "SELECT * FROM " + table + " where " + PKs[0] + " = ?";
            if (PKs.length > 1) {
                for (int i = 1; i < PKs.length; i++) {
                    sqlQuery += " and " + PKs[i] + " = ?";
                }
            }
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                for (int i = 0; i < PKs.length; i++) {
                    statement.setObject(i + 1, IDs[i]);
                }
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("email");
                        String placaAuto = resultSet.getString("placa");
                        String modeloAuto = resultSet.getString("modelo");
                        String nroChasis = resultSet.getString("nrochasis");
                        System.out.println("Correo del dueño: " + email + "\n"
                                + "Placa del auto: " + placaAuto
                                + "Seleccione el campo a editar" + "\n" + "1. Modelo: " + modeloAuto + "\n" + "2. Número de chasis" + nroChasis + "\n" + "3. CANCELAR" + "\n");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1: {
                                System.out.println("Ingrese el nuevo modelo del auto: ");
                                String modelo2 = scanner.nextLine();
                                String field = "modelo";
                                updateField(scanner, table, field, modelo2, PKs, IDs);
                                break;
                            }
                            case 2:
                                System.out.println("Ingrese el nuevo número de chasis: ");
                                String chasis2 = scanner.nextLine();
                                String field = "nrochasis";
                                updateField(scanner, table, field, chasis2, PKs, IDs);

                                break;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Información del auto no encontrada");
        }

    }

    public static void editModeloAuto(Scanner scanner) {
        String table = "modeloauto";
        String[] PKs = {"modelo"};
        System.out.println("Ingrese el modelo de auto: ");
        String modelo = scanner.nextLine();
        Object[] IDs = {modelo};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlQuery = "SELECT * FROM " + table + " where " + PKs[0] + " = ?";
            if (PKs.length > 1) {
                for (int i = 1; i < PKs.length; i++) {
                    sqlQuery += " and " + PKs[i] + " = ?";
                }
            }
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                for (int i = 0; i < PKs.length; i++) {
                    statement.setObject(i + 1, IDs[i]);
                }
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String model = resultSet.getString("modelo");
                        String color = resultSet.getString("colorvehiculo");
                        System.out.println("Modelo de auto: " + model + "\n"
                                + "Seleccione el campo a editar" + "\n" + "1. Color de vehículo: " + color + "\n" + "2. CANCELAR" + "\n");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1: {
                                System.out.println("Ingrese el nuevo color de auto: ");
                                String color2 = scanner.nextLine();
                                String field = "colorvehiculo";
                                updateField(scanner, table, field, color2, PKs, IDs);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Modelo de auto no encontrado");
        }

    }

    public static void editRuta(Scanner scanner) {
        String table = "ruta";
        String[] PKs = {"idruta"};
        System.out.println("Ingrese el ID de la ruta: ");
        int idRuta = scanner.nextInt();
        scanner.nextLine();
        Object[] IDs = {idRuta};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlQuery = "SELECT * FROM " + table + " where " + PKs[0] + " = ?";
            if (PKs.length > 1) {
                for (int i = 1; i < PKs.length; i++) {
                    sqlQuery += " and " + PKs[i] + " = ?";
                }
            }
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                for (int i = 0; i < PKs.length; i++) {
                    statement.setObject(i + 1, IDs[i]);
                }
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("idruta");
                        String origen = resultSet.getString("origen");
                        String destino = resultSet.getString("destino");
                        System.out.println("Id de la ruta: " + id + "\n"
                                + "Seleccione el campo a editar" + "\n" + "1. Origen de ruta: " + origen + "\n" + "2. Destino de ruta: " + destino + "\n" + "3. CANCELAR" + "\n");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1: {
                                System.out.println("Ingrese el nuevo origen de ruta: ");
                                String origen2 = scanner.nextLine();
                                String field = "origen";
                                updateField(scanner, table, field, origen2, PKs, IDs);
                                break;
                            }
                            case 2:
                                System.out.println("Ingrese el nuevo destino de ruta: ");
                                String destino2 = scanner.nextLine();
                                String field = "destino";
                                updateField(scanner, table, field, destino2, PKs, IDs);
                                break;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ruta no encontrada");
        }

    }

    public static void editReservacion(Scanner scanner) {
        String table = "reservacion";
        String[] PKs = {"email", "idviaje", "idreserva"};
        System.out.println("Ingrese el correo del usuario que hizo reservación: ");
        String correo = scanner.nextLine();
        System.out.println("Ingrese el ID del viaje: ");
        Integer idViaje = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el ID de la reserva: ");
        Integer idReserva = scanner.nextInt();
        scanner.nextLine();
        Object[] IDs = {correo, idViaje, idReserva};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlQuery = "SELECT * FROM " + table + " where " + PKs[0] + " = ?";
            if (PKs.length > 1) {
                for (int i = 1; i < PKs.length; i++) {
                    sqlQuery += " and " + PKs[i] + " = ?";
                }
            }
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                for (int i = 0; i < PKs.length; i++) {
                    statement.setObject(i + 1, IDs[i]);
                }
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("email");
                        int idViaj = resultSet.getInt("idviaje");
                        int idReser = resultSet.getInt("idreserva");
                        String detalle = resultSet.getString("detalle");
                        Timestamp fechaT = resultSet.getTimestamp("fecha");
                        String fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(fechaT);
                        System.out.println("Correo del usuario que reserva: " + email + "\n"
                                + "ID del viaje: " + idViaj
                                + "ID de la reserva: " + idReser
                                + "Seleccione el campo a editar" + "\n" + "1. Detalle de la reservación: " + detalle + "\n" + "2. Fecha de la reservación" + fecha + "\n" + "3. CANCELAR" + "\n");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1: {
                                System.out.println("Ingrese los nuevos detalles de la reservación: ");
                                String detalle2 = scanner.nextLine();
                                String field = "detalle";
                                updateField(scanner, table, field, detalle2, PKs, IDs);
                                break;
                            }
                            case 2:
                                System.out.println("Ingrese la nueva fecha de reservación (formato: yyyy-MM-dd HH:mm:ss): ");
                                String fecha2 = scanner.nextLine();
                                String field = "fecha";

                                try {
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    Date fechaDate = dateFormat.parse(fecha2);

                                    updateField(scanner, table, field, fechaDate, PKs, IDs);

                                } catch (ParseException e) {
                                    System.out.println("Formato de fecha y hora incorrecto. Por favor, use yyyy-MM-dd HH:mm:ss");
                                }

                                break;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Reservación no encontrada");
        }

    }

    public static void editViaje(Scanner scanner) {
        String table = "viaje";
        String[] PKs = {"conductor", "idviaje"};
        System.out.println("Ingrese el correo del conductor del viaje: ");
        String correo = scanner.nextLine();
        System.out.println("Ingrese el ID del viaje: ");
        Integer idViaje = scanner.nextInt();
        scanner.nextLine();
        Object[] IDs = {correo, idViaje};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlQuery = "SELECT * FROM " + table + " where " + PKs[0] + " = ?";
            if (PKs.length > 1) {
                for (int i = 1; i < PKs.length; i++) {
                    sqlQuery += " and " + PKs[i] + " = ?";
                }
            }
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                for (int i = 0; i < PKs.length; i++) {
                    statement.setObject(i + 1, IDs[i]);
                }
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String email = resultSet.getString("conductor");
                        int id = resultSet.getInt("idviaje");
                        int id2 = resultSet.getInt("idruta");
                        double precio = resultSet.getDouble("precio");
                        double tarifa = resultSet.getDouble("tarifa");
                        String estado = resultSet.getString("estado");
                        int asientos = resultSet.getInt("asientosdisponibles");
                        Time hora = resultSet.getTime("hora");
                        Date fecha = resultSet.getDate("fecha");
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                        String horaString = timeFormat.format(hora);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String fechaString = dateFormat.format(fecha);
                        String novedad = resultSet.getString("novedad");
                        String preferencias = resultSet.getString("preferencias");
                        System.out.println("Correo del conductor: " + email + "\n"
                                + "ID del viaje: " + id
                                + "ID de la ruta: " + id2
                                + "Seleccione el campo a editar" + "\n"
                                + "1. Precio: " + precio + "\n"
                                + "2. Tarifa: " + tarifa + "\n"
                                + "3. Hora: " + horaString + "\n"
                                + "4. Estado: " + estado + "\n"
                                + "5. Asientos disponibles: " + asientos + "\n"
                                + "6. Novedad: " + novedad + "\n"
                                + "7. Fecha: " + fechaString + "\n"
                                + "8. Preferencias: " + preferencias + "\n"
                                + "9. CANCELAR" + "\n");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1: {
                                System.out.println("Ingrese el nuevo precio: ");
                                double precio2 = scanner.nextDouble();
                                scanner.nextLine();
                                String field = "precio";
                                updateField(scanner, table, field, precio2, PKs, IDs);
                                break;
                            }

                            case 2: {
                                System.out.println("Ingrese la nueva tarifa: ");
                                double tarifa2 = scanner.nextDouble();
                                scanner.nextLine();
                                String field = "tarifa";
                                updateField(scanner, table, field, tarifa2, PKs, IDs);
                                break;
                            }
                            case 3: {
                                System.out.println("Ingresar la nueva hora (formato: HH:mm:ss): ");
                                String horaInput = scanner.nextLine();

                                try {
                                    SimpleDateFormat timeFormat2 = new SimpleDateFormat("HH:mm:ss");
                                    Time hora2 = new Time(timeFormat2.parse(horaInput).getTime());

                                    String field = "hora";
                                    updateField(scanner, table, field, hora2, PKs, IDs);

                                } catch (ParseException e) {
                                    System.out.println("Formato de hora incorrecto. Por favor, use HH:mm:ss");
                                }
                                break;
                            }
                            case 4: {
                                System.out.println("Ingrese el nuevo estado: ");
                                String estado2 = scanner.nextLine();
                                String field = "estado";
                                updateField(scanner, table, field, estado2, PKs, IDs);
                                break;
                            }
                            case 5: {
                                System.out.println("Ingrese los nuevos asientos disponibles: ");
                                Integer asientos2 = scanner.nextInt();
                                scanner.nextLine();
                                String field = "asientosdisponibles";
                                updateField(scanner, table, field, asientos2, PKs, IDs);
                                break;
                            }
                            case 6: {
                                System.out.println("Ingrese la nueva novedad: ");
                                String novedad2 = scanner.nextLine();
                                String field = "novedad";
                                updateField(scanner, table, field, novedad2, PKs, IDs);
                                break;
                            }
                            case 7: {
                                System.out.println("Ingresar la nueva fecha (formato: yyyy-MM-dd): ");
                                String fechaInput = scanner.nextLine();

                                try {
                                    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                                    Date fecha2 = dateFormat2.parse(fechaInput);

                                    String field = "fecha";
                                    updateField(scanner, table, field, fecha2, PKs, IDs);

                                } catch (ParseException e) {
                                    System.out.println("Formato de fecha incorrecto. Por favor, use yyyy-MM-dd");
                                }
                                break;
                            }
                            case 8: {
                                System.out.println("Ingrese las nuevas preferencias: ");
                                String preferencias2 = scanner.nextLine();
                                String field = "preferencias";
                                updateField(scanner, table, field, preferencias2, PKs, IDs);
                                break;
                            }
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Viaje no encontrado");
        }

    }
}
