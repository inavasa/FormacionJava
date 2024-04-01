package org.indra.claseSeis;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import org.indra.claseSeis.models.*;
import org.indra.claseSeis.persistence.*;

public class Program {
	public static void main(String[] args) throws IOException {
		Cliente c = new ClienteBuilder().withDni(12).withNombre("Ivan").withApellido("Navas")
				.withFechaNacimiento(LocalDate.now()).build();
		Cliente c2 = Cliente.builder().withDni(13).withNombre("Juan").withApellido("Martinez")
				.withFechaNacimiento(LocalDate.now()).build();

		ClienteFileRepository clienteRepository = new ClienteFileRepository();
		clienteRepository.save(c);
		clienteRepository.save(c2);

		Cliente resul = clienteRepository.findById(1);
		System.out.println(resul);

		List<Cliente> clientesResul = clienteRepository.findAll();
		System.out.println(clientesResul);
		// clientesResul.forEach(System.out::println);
	}
}
