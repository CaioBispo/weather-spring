package br.com.cast.weather.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDataDTO {

	@JsonProperty("main")
	private WeatherMainDTO weatherMain;

	@JsonProperty("weather")
	private List<WeatherDescriptionDTO> weatherDescriptions;

	@JsonProperty("wind")
	private WeatherWindDTO weatherWind;

	@JsonProperty("dt_txt")
	private String dateText;

	public WeatherMainDTO getWeatherMain() {
		return weatherMain;
	}

	public void setWeatherMain(WeatherMainDTO weatherMain) {
		this.weatherMain = weatherMain;
	}

	public List<WeatherDescriptionDTO> getWeatherDescriptions() {
		return weatherDescriptions;
	}

	public void setWeatherDescriptions(List<WeatherDescriptionDTO> weatherDescriptions) {
		this.weatherDescriptions = weatherDescriptions;
	}

	public String getDateText() {
		return dateText;
	}

	public void setDateText(String dateText) {
		this.dateText = dateText;
	}

	public Date getDate() {
		if (dateText != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return sdf.parse(dateText);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public WeatherWindDTO getWeatherWind() {
		return weatherWind;
	}

	public void setWeatherWind(WeatherWindDTO weatherWind) {
		this.weatherWind = weatherWind;
	}

}
