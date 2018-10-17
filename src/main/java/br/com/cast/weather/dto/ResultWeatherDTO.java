package br.com.cast.weather.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.cast.weather.entity.Weather;

public class ResultWeatherDTO {

	private String cidade;
	private Date date;
	private double tempMax;
	private double tempMin;
	private double pressure;
	private double humidity;
	private String condition;
	private String icon;
	private double windSpeed;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTempMax() {
		return tempMax;
	}

	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	public double getTempMin() {
		return tempMin;
	}

	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
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

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getDataFormatada() {
		if (date != null) {
			return new SimpleDateFormat("dd/MM/yyyy").format(date);
		}
		return null;
	}

	public static ResultWeatherDTO fromWeatherDTO(WeatherDataDTO data, String cidade) {
		ResultWeatherDTO dto = new ResultWeatherDTO();
		WeatherDescriptionDTO description = data.getWeatherDescriptions().get(0);
		WeatherMainDTO main = data.getWeatherMain();

		dto.setCondition(description.getMain());
		dto.setIcon(description.getIcon());
		
		dto.setCidade(cidade);

		dto.setDate(data.getDate());
		dto.setHumidity(main.getHumidity());
		dto.setPressure(main.getPressure());
		dto.setTempMax(main.getTemperatureMax());
		dto.setTempMin(main.getTemperatureMin());
		dto.setWindSpeed(data.getWeatherWind().getSpeed());
		return dto;
	}
	
	public static ResultWeatherDTO fromWeather(Weather weather) {
		ResultWeatherDTO dto = new ResultWeatherDTO();
		dto.setCidade(weather.getCity());
		dto.setCondition(weather.getCondition());
		dto.setDate(weather.getDate());
		dto.setHumidity(weather.getHumidity());
		dto.setIcon(weather.getIcon());
		dto.setPressure(weather.getPressure());
		dto.setTempMax(weather.getTempMax());
		dto.setTempMin(weather.getTempMin());
		dto.setWindSpeed(weather.getWindSpeed());
		return dto;
	}

}
