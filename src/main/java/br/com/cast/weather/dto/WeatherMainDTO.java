package br.com.cast.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherMainDTO {

	@JsonProperty("temp_min")
	private double temperatureMin;

	@JsonProperty("temp_max")
	private double temperatureMax;

	@JsonProperty("pressure")
	private double pressure;

	@JsonProperty("humidity")
	private double humidity;

	public double getTemperatureMin() {
		return temperatureMin;
	}

	public void setTemperatureMin(double temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public double getTemperatureMax() {
		return temperatureMax;
	}

	public void setTemperatureMax(double temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

}
