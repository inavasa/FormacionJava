package org.indra.claseNueve.persistence;

import org.indra.claseNueve.models.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarSqliteRepositoryTest {
    private Repository<Car> repo = null;
    private final String TEST_DB_NAME = "test.db";

    @BeforeEach
    void setUp() throws PersistenceException {
        // Quiero crear el repositorio y borrar el archivo si existe
        this.repo = new CarSqliteRepository(TEST_DB_NAME);
    }

    @AfterEach
    void tearDown() {
        // Quiero borrar el archivo de la base de datos
        new File(TEST_DB_NAME).delete();
    }

    @Test
    public void save() throws PersistenceException {
        Car car = new Car();
        car.setModel("Lamborghini Gallardo");
        car.setYear(2008);
        car.setColor("Amarillo");
        repo.save(car);

        Car recuperado = repo.findById(1);

        assertEquals(1, recuperado.getId());
        assertEquals("Lamborghini Gallardo", recuperado.getModel());
        assertEquals(2008, recuperado.getYear());
        assertEquals("Amarillo", recuperado.getColor());
    }

    @Test
    public void dataBaseExists() {
        assertTrue(new File(TEST_DB_NAME).exists());
    }
}