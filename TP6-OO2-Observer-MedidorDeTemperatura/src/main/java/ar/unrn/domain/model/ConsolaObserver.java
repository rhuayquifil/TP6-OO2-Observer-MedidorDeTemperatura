package ar.unrn.domain.model;

public class ConsolaObserver implements Observer {

	private static final int TEMPERATURA_MINIMA = 12;
	private static final int TEMPERATURA_MAXIMA = 17;
	private Observer observer;

	public ConsolaObserver(Observer observer) {
		this.observer = observer;
	}

	// IMPLEMENTACION CON DECORATOR

	@Override
	public void actualizar(String valor) {

		int temperatura = Integer.parseInt(valor.replaceAll("[^0-9]", ""));

		if (Integer.valueOf(temperatura) < TEMPERATURA_MINIMA) {
			System.out.println("Hace frio, se encendera la caldera");
		}

		if (Integer.valueOf(temperatura) > TEMPERATURA_MAXIMA) {
			System.out.println("Hace calor, se encendera el aire acondicionado");
		}

		this.observer.actualizar(valor);
	}

}
