package ar.unrn.main;

import ar.unrn.domain.model.Medidor;
import ar.unrn.domain.model.WeatherChannelService;

public class Main {

	public static void main(String[] args) {

		Medidor medidor = new Medidor(new WeatherChannelService(
				"https://api.openweathermap.org/data/2.5/weather?q=viedma&appid=a11fc6589d9bf8f5453f8e4442c4efe0"));
		System.out.println(medidor.leerTemperatura());
//		System.out.println(medidor.leerTemperatura());
//		System.out.println(medidor.leerTemperatura());
//		System.out.println(medidor.leerTemperatura());
	}

}
