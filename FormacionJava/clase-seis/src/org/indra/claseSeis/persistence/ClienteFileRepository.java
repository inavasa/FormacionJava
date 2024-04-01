package org.indra.claseSeis.persistence;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import org.indra.claseSeis.models.*;

public class ClienteFileRepository implements ClienteRepository {
	public ClienteFileRepository() {

	}

	public List<Cliente> findAll() throws NumberFormatException, IOException {
		List<Cliente> result = new ArrayList<>();

		File directorio = new File("clientes/");

		for (File f : directorio.listFiles()) {
			Cliente c = findById(Integer.parseInt(f.getName()));
			result.add(c);
		}

		return result;
	}

	public Cliente findById(int id) throws IOException {
		File file = new File("clientes/" + id);

		if (!file.exists()) {
			throw new Error("El cliente no existe");
		}

		FileReader reader = new FileReader(file);
		BufferedReader reader2 = new BufferedReader(reader);

		Cliente c = new ClienteBuilder().withId(Integer.parseInt(reader2.readLine()))
				.withDni(Integer.parseInt(reader2.readLine())).withNombre(reader2.readLine())
				.withApellido(reader2.readLine()).withFechaNacimiento(LocalDate.parse(reader2.readLine())).build();

		return c;
	}

	public void save(Cliente c) throws IOException {
		if (c.getId() != 0) {
			throw new Error("Este cliente ya tiene ID");
		}

		File directorio = new File("clientes");
		if (!directorio.exists()) {
			directorio.mkdir();
		}

		int cantidadArchivos = directorio.listFiles().length;
		int id = cantidadArchivos + 1;
		c.setId(id);

		FileWriter writer = new FileWriter("clientes/" + id);
		PrintWriter printWriter = new PrintWriter(writer);

		printWriter.println(c.getId());
		printWriter.println(c.getDni());
		printWriter.println(c.getNombre());
		printWriter.println(c.getApellido());
		printWriter.println(c.getFechaNacimiento());

		writer.close();
	}

	public void update(Cliente c) throws IOException {
		if (c.getId() == 0) {
			throw new Error("El cliente es nuevo");
		}

		this.delete(c.getId());
		this.save(c);
	}

	public void delete(int id) {
		File file = new File("clientes/" + id);
		if (file.exists()) {
			file.delete();
		}
	}
}
