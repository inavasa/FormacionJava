package org.indra.claseDoce.persistence;

import lombok.SneakyThrows;
import org.indra.claseDoce.models.ObjetoDeNegocio;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class SqliteRepository<T extends ObjetoDeNegocio> implements Repository<T> {

    private String CONNECTION_STRING = "jdbc:sqlite:demo.db";

    public SqliteRepository(String fileName) {
        this.CONNECTION_STRING = "jdbc:sqlite:" + fileName;
        this.crearTabla();
    }

    public SqliteRepository() {
        crearTabla();
    }

    protected abstract String getQueryCrearTabla();

    protected abstract String getInsertQuery();

    protected abstract void setInsertParameter(PreparedStatement insertarT, T t) throws SQLException;

    protected abstract T createModel();

    protected abstract String getSelect();

    protected abstract void fillModelFromResultSet(T t, ResultSet resultSet) throws SQLException;

    @SneakyThrows
    private void crearTabla() {
        //Crear la tabla si no existe
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {
            System.out.println("Conexion con la base de datos exitosa");
            System.out.println(conn.getClass());

            Statement crearTabla = conn.createStatement();
            crearTabla.executeUpdate(getQueryCrearTabla());
        } catch (SQLException e) {
            throw new Exception(this.getClass().getName() + ": no se pudo crear la tabla", e);
        }
    }

    @Override
    @SneakyThrows
    public void save(T t) {
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {
            PreparedStatement insertarT = conn.prepareStatement(getInsertQuery());
            setInsertParameter(insertarT, t);
            insertarT.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(MessageFormat.format("No se pudo insertar el registro de {0}", t.getClass().getName()), e);
        }
    }


    @Override
    public void update(T t) {
        throw new UnsupportedOperationException("No implementado");
    }

    @Override
    public void delete(T t) {
        this.delete(t.getId());
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("No implementado");
    }

    @Override
    @SneakyThrows
    public T findById(int id) {
        T t = createModel();
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {
            PreparedStatement selectT = conn.prepareStatement(getSelect() + " WHERE id = ?");
            selectT.setInt(1, id);
            ResultSet resultSet = selectT.executeQuery();

            if (resultSet.next()) {
                fillModelFromResultSet(t, resultSet);
            }

            System.out.println(t);
        } catch (SQLException e) {
            throw new Exception(MessageFormat.format("No existe el registro con id {0}", id), e);
        }

        return t;
    }

    @Override
    @SneakyThrows
    public List<T> findAll() {
        List<T> ts = new ArrayList<T>();

        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {
            PreparedStatement selectTs = conn.prepareStatement(getSelect());
            ResultSet resultSet = selectTs.executeQuery();

            if (resultSet.next()) {
                T t = createModel();
                fillModelFromResultSet(t, resultSet);
                ts.add(t);
            }
        } catch (SQLException e) {
            throw new Exception("No se pudo conectar con la base de datos", e);
        }

        return ts;
    }
}
