package org.indra.claseOnce.persistence;

import org.indra.claseOnce.models.Personaje;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonajeRepository extends SqliteRepository<Personaje> {
    @Override
    protected String getQueryCrearTabla() {
        return """
                CREATE TABLE IF NOT EXISTS Personaje (
                                        Id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        Nombre TEXT NOT NULL)""";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Personaje(Nombre) VALUES (?)";
    }

    @Override
    protected void setInsertParameter(PreparedStatement insertarT, Personaje personaje) throws SQLException {
        insertarT.setString(1, personaje.getNombre());
    }

    @Override
    protected Personaje createModel() {
        return new Personaje();
    }

    @Override
    protected String getSelect() {
        return "SELECT * FROM Personaje";
    }

    @Override
    protected void fillModelFromResultSet(Personaje personaje, ResultSet resultSet) throws SQLException {
        personaje.setId(resultSet.getInt("id"));
        personaje.setNombre(resultSet.getString("nombre"));
    }
}
