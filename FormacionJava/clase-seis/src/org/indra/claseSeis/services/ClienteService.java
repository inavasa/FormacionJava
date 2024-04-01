package org.indra.claseSeis.services;

import java.io.IOException;
import java.time.LocalDate;

import org.indra.claseSeis.models.*;
import org.indra.claseSeis.persistence.*;

public class ClienteService {
	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public void registrarCliente(Cliente c) throws Exception {
		if (c.getFechaNacimiento().isAfter(LocalDate.now())) {
			throw new Exception("Fecha errónea");
		}

		if (c.getNombre() == null) {
			throw new Exception("Nombre erróneo");
		}

		clienteRepository.save(c);
	}

	// public void ActualizarCliente
	// public voidDarDeBajaCliente

	public Cliente recuperarCliente(int c) throws IOException {
		return clienteRepository.findById(c);
	}
}
