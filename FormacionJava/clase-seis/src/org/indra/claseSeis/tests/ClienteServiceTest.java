package org.indra.claseSeis.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.indra.claseSeis.models.*;
import org.indra.claseSeis.services.*;
import org.junit.jupiter.api.Test;
import org.indra.claseSeis.persistence.*;

class ClienteServiceTest {

	@Test
	void testRegistrarClienteOK() throws Exception {
		Cliente c = Cliente.builder().withDni(13).withNombre("Ivan").withApellido("Navas")
				.withFechaNacimiento(LocalDate.now()).build();
		ClienteService service = new ClienteService(new ClienteMockRepository());
		service.registrarCliente(c);

		Cliente cRecuperado = service.recuperarCliente(c.getId());
		assertEquals(c.getDni(), cRecuperado.getDni());
		assertEquals(c.getNombre(), cRecuperado.getNombre());
		assertEquals(c.getApellido(), cRecuperado.getApellido());
		assertEquals(c.getFechaNacimiento(), cRecuperado.getFechaNacimiento());
	}

	@Test
	void testRegistrarClienteNombreVacio() throws Error {
		assertThrows(Error.class, () -> {
			Cliente c = Cliente.builder().withDni(13).withNombre("").withApellido("Martinez")
					.withFechaNacimiento(LocalDate.now()).build();
			ClienteService service = new ClienteService(new ClienteMockRepository());
			service.registrarCliente(c);
		});
	}

}