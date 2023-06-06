package ar.unrn.domain.model;

import java.time.LocalDateTime;

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

		if ((weatherChannelServiceClimaOnline != null)
				& (LocalDateTime.now().isBefore(this.cacheTime.plusMinutes(30)))) {
			return cachetemperatura;
		}

		this.cachetemperatura = weatherChannelServiceClimaOnline.temperatura();

		return cachetemperatura;
	}

}
