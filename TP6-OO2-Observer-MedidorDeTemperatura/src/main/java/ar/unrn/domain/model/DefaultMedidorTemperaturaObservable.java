package ar.unrn.domain.model;

public class DefaultMedidorTemperaturaObservable implements MedidorTemperatura {

	private String temperatura;
	private ClimaOnline clima;

	public DefaultMedidorTemperaturaObservable(ClimaOnline clima) {
		super();
		this.temperatura = "";
		this.clima = clima;
	}

	public String leerTemperatura() {
		// leo la temperatura del servicio web
		try {
			this.temperatura = this.clima.temperatura();
		} catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		return this.temperatura;
	}
}
