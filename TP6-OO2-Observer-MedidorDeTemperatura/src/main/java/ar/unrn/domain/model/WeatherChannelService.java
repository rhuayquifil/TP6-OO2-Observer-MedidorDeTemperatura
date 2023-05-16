package ar.unrn.domain.model;

import java.io.IOException;
import java.util.Random;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class WeatherChannelService implements ClimaOnline {

	private String url;

	public WeatherChannelService(String url) {
		super();
		this.url = url;
	}

//	@Override
	public String temperatura() throws DomainExceptions {
		int temp = new Random().nextInt(100);

		try {

			OkHttpClient client = new OkHttpClient();

			Request request = new Request.Builder().url(this.url).build();

			Response response = client.newCall(request).execute();

			validaciones(response);

			ResponseBody responseBody = response.body();

			String responseData = responseBody.string();

			JSONObject json = new JSONObject(responseData);

			double temperaturaKelvin = json.getJSONObject("main").getDouble("temp");
			double temperaturaCelsius = temperaturaKelvin - 273.15;

			return String.format("%.0f", temperaturaCelsius) + " c";

		} catch (IOException e) {
			throw new DomainExceptions("");
		}

		// TENES QUE CONSUMIR DE LA API https://openweathermap.org/current
	}

	private void validaciones(Response response) throws IOException, DomainExceptions {
		if (!response.isSuccessful()) {
			throw new DomainExceptions("Error: " + response.code() + " " + response.message());
		}

		ResponseBody responseBody = response.body();

		if (responseBody == null) {
			throw new DomainExceptions("no se pudo conectar al servidor");
		}
	}
}
