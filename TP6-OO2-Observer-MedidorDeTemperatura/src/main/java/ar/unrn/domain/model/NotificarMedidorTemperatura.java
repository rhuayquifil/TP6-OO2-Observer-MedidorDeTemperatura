package ar.unrn.domain.model;

import java.util.List;

public class NotificarMedidorTemperatura extends Observable implements MedidorTemperatura {

	private MedidorTemperatura medidorTemperatura;

	public NotificarMedidorTemperatura(List<Observer> subscriptores, MedidorTemperatura medidorTemperatura) {
		super();

		this.medidorTemperatura = medidorTemperatura;

		for (Observer observer : subscriptores) {
			this.subscribir(observer);
		}
	}

	@Override
	public String leerTemperatura() {
		String temperatura = this.medidorTemperatura.leerTemperatura();
		this.notificar(temperatura);
		return temperatura;
	}
}
