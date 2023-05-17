package ar.unrn.domain.model;

public class MedidorObservable extends Observable {

	private String temperatura;
	private ClimaOnline clima;
	private Observer subs;

//	public MedidorObservable(ClimaOnline clima, List<Observer> subscriptores) {
//		super();
//		this.temperatura = "";
//		this.clima = clima;
//
//		for (Observer observer : subscriptores) {
//			this.subscribir(observer);
//		}
//	}

	public MedidorObservable(ClimaOnline clima, Observer subs) {
		super();
		this.temperatura = "";
		this.clima = clima;
		this.subs = subs;
	}

	public String leerTemperatura() {
		// leo la temperatura del servicio web
		try {
			this.temperatura = this.clima.temperatura();

			// IMPLEMENTACION PRIMER FORMA, RECORRIENDO LOS SUBSCRIPTORES DE OBSERVABLE
//			this.notificar(this.temperatura);

			// SEGUNDA FORMA, PATRON DECORATOR
			subs.actualizar(this.temperatura);

		} catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		return this.temperatura;
	}
}
