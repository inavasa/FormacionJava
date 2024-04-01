package org.indra.claseSeis.persistence;

import java.io.IOException;
import java.util.List;

import org.indra.claseSeis.models.Cliente;

public interface ClienteRepository {
	List<Cliente> findAll() throws NumberFormatException, IOException;

	Cliente findById(int id) throws IOException;

	void save(Cliente c) throws IOException;

	void update(Cliente c) throws IOException;

	void delete(int id);
}
