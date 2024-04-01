package org.indra.claseNueve.persistence;

import lombok.SneakyThrows;
import org.indra.claseNueve.models.Mobile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MobileSqliteRepository extends SqliteRepository<Mobile> {

    public MobileSqliteRepository(String fileName) throws PersistenceException {
        super(fileName);
    }

    public MobileSqliteRepository() throws PersistenceException {
    }

    @Override
    protected String getQueryCrearTabla() {
        return """
                CREATE TABLE IF NOT EXISTS Mobiles (
                                        Id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        Marca TEXT NOT NULL,
                                        Tamanio INTEGER NOT NULL)""";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Mobiles(Marca, Tamanio) VALUES (?,?)";
    }

    @Override
    @SneakyThrows
    protected void setInsertParameter(PreparedStatement insertarT, Mobile mobile) {
        insertarT.setString(1, mobile.getMarca());
        insertarT.setInt(2, mobile.getTamanio());
    }

    @Override
    protected Mobile createModel() {
        return new Mobile();
    }

    @Override
    protected String getSelect() {
        return "SELECT * FROM Mobiles";
    }

    @Override
    @SneakyThrows
    protected void fillModelFromResultSet(Mobile mobile, ResultSet resultSet) {
        mobile.setId(resultSet.getInt("id"));
        mobile.setMarca(resultSet.getString("marca"));
        mobile.setTamanio(resultSet.getInt("tamanio"));
    }
}



/*
package org.indra.claseNueve.persistence;

import org.indra.claseNueve.models.Mobile;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class MobileSqliteRepository implements Repository<Mobile> {
    private String CONNECTION_STRING = "jdbc:sqlite:demo.db";

    public MobileSqliteRepository(String fileName) throws PersistenceException {
        this.CONNECTION_STRING = "jdbc:sqlite:" + fileName;
        this.crearBaseDeDatos();
    }

    public MobileSqliteRepository() throws PersistenceException {
        crearBaseDeDatos();
    }

    private void crearBaseDeDatos() throws PersistenceException {
        //Crear la tabla si no existe
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:demo.db")) {
            System.out.println("Conexion con la base de datos exitosa");
            System.out.println(conn.getClass());

            Statement crearTabla = conn.createStatement();
            int result = crearTabla.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS Mobiles (
                        Id INTEGER PRIMARY KEY AUTOINCREMENT,
                        Marca TEXT NOT NULL,
                        Tamanio INTEGER NOT NULL)
                    """);
            System.out.println("Tabla Mobiles (creada si no existe)");
            System.out.println(result); //0 es que ya estaba creada
        } catch (SQLException e) {
            throw new PersistenceException("No se pudo crear la tabla Mobiles", e);
        }
    }

    @Override
    public void save(Mobile mobile) throws PersistenceException {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:demo.db")) {
            PreparedStatement insertaMobile = conn.prepareStatement("INSERT INTO Mobiles");

            insertaMobile.setString(1, mobile.getMarca());
            insertaMobile.setInt(2, mobile.getTamanio());
            insertaMobile.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException(MessageFormat.format("No se pudo insertar el mobile {0}", mobile.getMarca()), e);
        }
    }


    @Override
    public void update(Mobile mobile) throws PersistenceException {

    }

    @Override
    public void delete(Mobile mobile) throws PersistenceException {
        this.delete(mobile.getId());
    }

    @Override
    public void delete(int id) throws PersistenceException {

    }

    @Override
    public Mobile findById(int id) throws PersistenceException {
        Mobile mobile = new Mobile();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:demo.db")) {
            PreparedStatement selectMobile = conn.prepareStatement("SELECT * FROM Mobiles WHERE id = ?");
            selectMobile.setInt(1, id);
            ResultSet resultSet = selectMobile.executeQuery();

            if (resultSet.next()) {
                mobile.setMarca(resultSet.getString("marca"));
                mobile.setTamanio(resultSet.getInt("tamanio"));
            }

            System.out.println(mobile);
        } catch (SQLException e) {
            throw new PersistenceException(MessageFormat.format("No existe el mobile {0}", mobile.getMarca()), e);
        }

        return mobile;
    }

    @Override
    public List<Mobile> findAll() throws PersistenceException {
        List<Mobile> mobiles = new ArrayList<Mobile>();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:demo.db")) {
            PreparedStatement selectMobiles = conn.prepareStatement("SELECT * FROM Mobiles");
            ResultSet resultSet = selectMobiles.executeQuery();

            if (resultSet.next()) {
                Mobile mobile = new Mobile();
                mobile.setMarca(resultSet.getString("marca"));
                mobile.setTamanio(resultSet.getInt("tamanio"));
                mobiles.add(mobile);
            }
        } catch (SQLException e) {
            throw new PersistenceException("No se pudo conectar con la base de datos", e);
        }

        return mobiles;
    }
}
*/