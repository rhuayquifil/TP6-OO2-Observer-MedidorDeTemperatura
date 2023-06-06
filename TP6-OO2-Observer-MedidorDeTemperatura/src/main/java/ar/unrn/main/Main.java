package ar.unrn.main;

import java.util.ArrayList;
import java.util.List;

import ar.unrn.domain.model.CacheWeatherChannelServiceClimaOnline;
import ar.unrn.domain.model.ClimaOnline;
import ar.unrn.domain.model.ConsolaObserver;
import ar.unrn.domain.model.DefaultMedidorTemperaturaObservable;
import ar.unrn.domain.model.DomainExceptions;
import ar.unrn.domain.model.GuardarDatoTemperaturaObserver;
import ar.unrn.domain.model.MedidorTemperatura;
import ar.unrn.domain.model.NotificarMedidorTemperatura;
import ar.unrn.domain.model.Observer;
import ar.unrn.domain.model.WeatherChannelServiceClimaOnline;

public class Main {

	public static void main(String[] args) {

		List<Observer> subscriptores = new ArrayList<>();

		subscriptores.add(new GuardarDatoTemperaturaObserver(
				"C:\\Users\\ezehu\\git\\TP6-OO2-Observer-MedidorDeTemperatura\\RegistroTemperatura.txt", ", "));

		subscriptores.add(new ConsolaObserver());

		try {

			ClimaOnline climaProxy = new CacheWeatherChannelServiceClimaOnline(new WeatherChannelServiceClimaOnline(
					"https://api.openweathermap.org/data/2.5/weather?q=viedma&appid=a11fc6589d9bf8f5453f8e4442c4efe0"));

			MedidorTemperatura medidorDefaultYNotificar = new NotificarMedidorTemperatura(subscriptores,
					new DefaultMedidorTemperaturaObservable(climaProxy));

			System.out.println(medidorDefaultYNotificar.leerTemperatura());
		} catch (NumberFormatException | DomainExceptions e) {
			System.out.println(e.getMessage());
		}
	}
}
