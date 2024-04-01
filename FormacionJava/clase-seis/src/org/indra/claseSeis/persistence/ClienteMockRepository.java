package org.indra.claseSeis.persistence;

import java.io.IOException;
import java.util.*;

import org.indra.claseSeis.models.Cliente;

public class ClienteMockRepository implements ClienteRepository {
	public ClienteMockRepository() {
		
	}

	private List<Cliente> clientes = new ArrayList<>();

	@Override
	public List<Cliente> findAll() throws NumberFormatException, IOException {
		return this.clientes;
	}

	@Override
	public Cliente findById(int id) throws IOException {
		return this.clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
	}

	@Override
	public void save(Cliente c) throws IOException {
		c.setId(this.clientes.size() + 1);
		this.clientes.add(c);
	}

	@Override
	public void update(Cliente c) throws IOException {

	}

	@Override
	public void delete(int id) {

	}

}
