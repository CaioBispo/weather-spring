package br.com.cast.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherWindDTO {

	@JsonProperty("speed")
	private double speed;

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

}
