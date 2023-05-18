package ar.unrn.domain.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class GuardarDatoTemperaturaObserver implements Observer {

	private String url;
	private String separador;

	public GuardarDatoTemperaturaObserver(String url, String separador) {
		this.url = url;
		this.separador = separador;
	}

	@Override
	public void actualizar(String valor) {
		try {
			FileWriter fileWriter = new FileWriter(url, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(LocalDateTime.now() + separador + valor);
			bufferedWriter.newLine();

			bufferedWriter.close();
		} catch (IOException e) {
			throw new RuntimeException("en disco guardarDatos");
		}
	}

}
