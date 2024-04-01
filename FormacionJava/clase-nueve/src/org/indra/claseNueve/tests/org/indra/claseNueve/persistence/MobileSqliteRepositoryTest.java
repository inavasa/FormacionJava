package org.indra.claseNueve.persistence;

import org.indra.claseNueve.models.Mobile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MobileSqliteRepositoryTest {

    private Repository<Mobile> repo = null;
    private final String TEST_DB_NAME = "test.db";

    @BeforeEach
    void setUp() throws PersistenceException {
        // Quiero crear el repositorio y borrar el archivo si existe
        this.repo = new MobileSqliteRepository(TEST_DB_NAME);
    }

    @AfterEach
    void tearDown() {
        // Quiero borrar el archivo de la base de datos
        new File(TEST_DB_NAME).delete();
    }

    @Test
    public void save() throws PersistenceException {
        Mobile mobile = new Mobile();
        mobile.setMarca("OnePlus Nord 2");
        mobile.setTamanio(12);
        repo.save(mobile);

        Mobile recuperado = repo.findById(1);

        assertEquals(1, recuperado.getId());
        assertEquals("OnePlus Nord 2", recuperado.getMarca());
        assertEquals(12, recuperado.getTamanio());
    }

    @Test
    public void dataBaseExists() {
        assertTrue(new File(TEST_DB_NAME).exists());
    }
}