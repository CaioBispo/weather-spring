package br.com.cast.weather.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDTO {

	@JsonProperty("cod")
	private Integer id;

	@JsonProperty("message")
	private double message;

	@JsonProperty("cnt")
	private Integer count;

	@JsonProperty("list")
	private List<WeatherDataDTO> weatherDatas;

	public List<WeatherDataDTO> getWeatherDatas() {
		return weatherDatas;
	}

	public void setWeatherDatas(List<WeatherDataDTO> weatherDatas) {
		this.weatherDatas = weatherDatas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getMessage() {
		return message;
	}

	public void setMessage(double message) {
		this.message = message;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
