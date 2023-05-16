package ar.unrn.domain.model;

import java.util.List;

public class MedidorObservable extends Observable {

	private String temperatura;
	private ClimaOnline clima;

	public MedidorObservable(ClimaOnline clima, List<Observer> subscriptores) {
		super();
		this.temperatura = "";
		this.clima = clima;

		for (Observer observer : subscriptores) {
			this.subscribir(observer);
		}
	}

	public String leerTemperatura() {
		// leo la temperatura del servicio web
		try {
			this.temperatura = this.clima.temperatura();
			this.notificar(this.temperatura);

		} catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		return this.temperatura;
	}
}
