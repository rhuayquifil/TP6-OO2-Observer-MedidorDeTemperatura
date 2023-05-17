package ar.unrn.domain.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class GuardarDatoTemperaturaObserver implements Observer {

	private String url;
	private String separador;
	private Observer observer;

//	public GuardarDatoTemperaturaObserver(String url, String separador) {
//		this.url = url;
//		this.separador = separador;
//	}

	public GuardarDatoTemperaturaObserver(String url, String separador, Observer observer) {
		this.url = url;
		this.separador = separador;
		this.observer = observer;
	}

	// IMPLEMENTACION CON DECORATOR

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

		this.observer.actualizar(valor);
	}

	// IMPLEMENTACION SIN DECORATOR

//	@Override
//	public void actualizar(String valor) {
//		try {
//			FileWriter fileWriter = new FileWriter(url, true);
//			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//			bufferedWriter.write(LocalDateTime.now() + separador + valor);
//			bufferedWriter.newLine();
//
//			bufferedWriter.close();
//		} catch (IOException e) {
//			throw new RuntimeException("en disco guardarDatos");
//		}		
//	}

}
