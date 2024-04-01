package org.indra.claseOcho.persistence;

import org.indra.claseOcho.models.Car;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class CarSqliteRepository implements Repository<Car> {
    private String CONNECTION_STRING = "jdbc:sqlite:demo.db";

    public CarSqliteRepository(String fileName) throws PersistenceException {
        this.CONNECTION_STRING = "jdbc:sqlite:" + fileName;
        this.crearBaseDeDatos();
    }

    public CarSqliteRepository() throws PersistenceException {
        crearBaseDeDatos();
    }

    private void crearBaseDeDatos() throws PersistenceException {
        //Crear la tabla si no existe
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:demo.db")) {
            System.out.println("Conexion con la base de datos exitosa");
            System.out.println(conn.getClass());

            Statement crearTabla = conn.createStatement();
            int result = crearTabla.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS Cars (
                        Id INTEGER PRIMARY KEY AUTOINCREMENT,
                        Model TEXT NOT NULL,
                        Year INTEGER NOT NULL,
                        Color TEXT NOT NULL)
                    """);
            System.out.println("Tabla cars (creada si no existe)");
            System.out.println(result); //0 es que ya estaba creada
        } catch (SQLException e) {
            throw new PersistenceException("No se pudo crear la tabla Cars", e);
        }
    }

    @Override
    public void save(Car model) throws PersistenceException {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:demo.db")) {
            PreparedStatement insertarCar = conn.prepareStatement("INSERT INTO Car");

            insertarCar.setString(1, model.getModel());
            insertarCar.setInt(2, model.getYear());
            insertarCar.setString(3, model.getColor());
            insertarCar.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException(MessageFormat.format("No se pudo insertar el car {0}", model.getModel()), e);
        }
    }


    @Override
    public void update(Car model) throws PersistenceException {

    }

    @Override
    public void delete(Car model) throws PersistenceException {
        this.delete(model.getId());
    }

    @Override
    public void delete(int id) throws PersistenceException {

    }

    @Override
    public Car findById(int id) throws PersistenceException {
        Car car = new Car();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:demo.db")) {
            PreparedStatement selectCar = conn.prepareStatement("SELECT * FROM Cars WHERE id = ?");
            selectCar.setInt(1, id);
            ResultSet resultSet = selectCar.executeQuery();

            if (resultSet.next()) {
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setColor(resultSet.getString("color"));
            }

            System.out.println(car);
        } catch (SQLException e) {
            throw new PersistenceException(MessageFormat.format("No existe el car {0}", car.getModel()), e);
        }

        return car;
    }

    @Override
    public List<Car> findAll() throws PersistenceException {
        List<Car> cars = new ArrayList<Car>();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:demo.db")) {
            PreparedStatement selectCars = conn.prepareStatement("SELECT * FROM Cars");
            ResultSet resultSet = selectCars.executeQuery();

            if (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setColor(resultSet.getString("color"));
                cars.add(car);
            }
        } catch (SQLException e) {
            throw new PersistenceException("No se pudo conectar con la base de datos", e);
        }

        return cars;
    }
}

