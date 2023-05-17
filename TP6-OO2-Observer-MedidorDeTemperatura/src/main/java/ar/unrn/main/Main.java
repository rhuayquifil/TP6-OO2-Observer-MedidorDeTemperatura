package ar.unrn.main;

import ar.unrn.domain.model.ConsolaObserver;
import ar.unrn.domain.model.DefaultObserver;
import ar.unrn.domain.model.GuardarDatoTemperaturaObserver;
import ar.unrn.domain.model.MedidorObservable;
import ar.unrn.domain.model.Observer;
import ar.unrn.domain.model.WeatherChannelService;

public class Main {

	public static void main(String[] args) {

//		List<Observer> subscriptores = new ArrayList<>();
//		subscriptores.add(new GuardarDatoTemperaturaObserver(
//				"C:\\Users\\ezehu\\git\\TP6-OO2-Observer-MedidorDeTemperatura\\RegistroTemperatura.txt", ", "));
//		subscriptores.add(new GuardarDatoTemperatura(""));

//		MedidorObservable medidor = new MedidorObservable(new WeatherChannelService(
//				"https://api.openweathermap.org/data/2.5/weather?q=viedma&appid=a11fc6589d9bf8f5453f8e4442c4efe0"),
//				subscriptores);

		try {
			Observer subs = new ConsolaObserver(new GuardarDatoTemperaturaObserver(
					"C:\\Users\\ezehu\\git\\TP6-OO2-Observer-MedidorDeTemperatura\\RegistroTemperatura.txt", ", ",
					new DefaultObserver()));

			MedidorObservable medidor = new MedidorObservable(new WeatherChannelService(
					"https://api.openweathermap.org/data/2.5/weather?q=viedma&appid=a11fc6589d9bf8f5453f8e4442c4efe0"),
					subs);

			System.out.println(medidor.leerTemperatura());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

//		System.out.println(medidor.leerTemperatura());
//		System.out.println(medidor.leerTemperatura());
//		System.out.println(medidor.leerTemperatura());
	}

}
