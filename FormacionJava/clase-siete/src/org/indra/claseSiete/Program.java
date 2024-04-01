package org.indra.claseSiete;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.List;

public class Program {
    public static void main(String[] args) throws SQLException {
        // Connection conn = null;

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:demo.db")) {
        /*
            try {
            conn = DriverManager.getConnection("jdbc:sqlite:demo.db");
        */
            System.out.println("Conexión con la base de datos exitosa");
            System.out.println(conn.getClass());

            crearTabla(conn);

            Statement hayClientes = conn.createStatement();
            ResultSet resulTotalClientes = hayClientes.executeQuery("SELECT COUNT (*) FROM Cliente");
            int totalClientes = 0;

            if (resulTotalClientes.next()) {
                totalClientes = resulTotalClientes.getInt(1);
            }

            if (totalClientes == 0) {
                System.out.println("No hay registros");
                System.out.println("Se van a insertar los clientes en la base de datos");

                List<Cliente> clientes = List.of(new Cliente("Jorge", 27), new Cliente("Ivan", 26), new Cliente("Alvaro", 23), new Cliente("Jiten", 24));

                for (Cliente c : clientes) {
                    System.out.println("Insertando cliente " + c.getNombre());

                    PreparedStatement insertarCliente = conn.prepareStatement("INSERT INTO Cliente (Nombre, edad) VALUES (?, ?)");
                    insertarCliente.setString(1, c.getNombre());
                    insertarCliente.setInt(2, c.getEdad());
                    insertarCliente.executeUpdate();
                }
            } else {
                System.out.println("Ya hay registros. No se inserta nada");
            }

            System.out.println("Ahora voy a listar los clientes:");
            Statement selectCliente = conn.createStatement();
            ResultSet resultSet = selectCliente.executeQuery("SELECT * FROM Cliente");
            while (resultSet.next()) {
                String nombre = resultSet.getString("Nombre");
                int edad = resultSet.getInt("edad");
                System.out.println(nombre + " " + edad);
            }
        }
        /*
        catch (SQLException e) {
            System.err.println("Fallo en la conexión con la base de datos");
            throw new RuntimeException(e);
        }
        finally {

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        */
    }

    private static void crearTabla(Connection conn) throws SQLException {
        Statement crearTabla = conn.createStatement();
        int result = crearTabla.executeUpdate("""
                CREATE TABLE IF NOT EXISTS Cliente (
                Id INTEGER PRIMARY KEY AUTOINCREMENT,
                Nombre TEXT NOT NULL,
                Edad INTEGER NOT NULL)
                """);

        System.out.println("Tabla Cliente (Creada si no existe)");
        System.out.println(result); // 0 = ya está creada
    }
}
