package ar.unrn.main;

import java.util.ArrayList;
import java.util.List;

import ar.unrn.domain.model.ConsolaObserver;
import ar.unrn.domain.model.DefaultMedidorTemperaturaObservable;
import ar.unrn.domain.model.GuardarDatoTemperaturaObserver;
import ar.unrn.domain.model.MedidorTemperatura;
import ar.unrn.domain.model.NotificarMedidorTemperatura;
import ar.unrn.domain.model.Observer;
import ar.unrn.domain.model.WeatherChannelService;

public class Main {

	public static void main(String[] args) {

		List<Observer> subscriptores = new ArrayList<>();

		subscriptores.add(new GuardarDatoTemperaturaObserver(
				"C:\\Users\\ezehu\\git\\TP6-OO2-Observer-MedidorDeTemperatura\\RegistroTemperatura.txt", ", "));

		subscriptores.add(new ConsolaObserver());

		try {

			MedidorTemperatura medidorDefaultYNotificar = new NotificarMedidorTemperatura(subscriptores,
					new DefaultMedidorTemperaturaObservable(new WeatherChannelService(
							"https://api.openweathermap.org/data/2.5/weather?q=viedma&appid=a11fc6589d9bf8f5453f8e4442c4efe0")));

			System.out.println(medidorDefaultYNotificar.leerTemperatura());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
