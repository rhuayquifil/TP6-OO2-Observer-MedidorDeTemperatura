package ar.unrn.main;

import java.time.LocalDateTime;

import ar.unrn.domain.model.ClimaOnline;
import ar.unrn.domain.model.DomainExceptions;
import ar.unrn.domain.model.WeatherChannelServiceClimaOnline;

public class CacheWeatherChannelServiceClimaOnline implements ClimaOnline {

	private WeatherChannelServiceClimaOnline weatherChannelServiceClimaOnline;
	private LocalDateTime cacheTime;
	private String cachetemperatura;

	public CacheWeatherChannelServiceClimaOnline(WeatherChannelServiceClimaOnline weatherChannelServiceClimaOnline)
			throws DomainExceptions {
		this.weatherChannelServiceClimaOnline = weatherChannelServiceClimaOnline;
		this.cacheTime = LocalDateTime.now();
		this.cachetemperatura = weatherChannelServiceClimaOnline.temperatura();
	}

	@Override
	public String temperatura() throws DomainExceptions {

		// PREGUNTA SI ESTA BIEN ESTO

		if ((weatherChannelServiceClimaOnline != null)
				& (LocalDateTime.now().isBefore(this.cacheTime.plusMinutes(30)))) {
			return cachetemperatura;
		}

		this.cachetemperatura = weatherChannelServiceClimaOnline.temperatura();

		return cachetemperatura;
	}

}
