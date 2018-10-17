package br.com.cast.weather.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.cast.weather.dto.ResultWeatherDTO;

@Entity
@Table(name = "weather", schema = "weather")
public class Weather {

	@Id
	@Column(name = "id", length = 36)
	private String id;

	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "temp_max", length = 5, precision = 2, nullable = false)
	private double tempMax;

	@Column(name = "temp_min", length = 5, precision = 2, nullable = false)
	private double tempMin;

	@Column(name = "pressure", length = 5, precision = 2, nullable = false)
	private double pressure;

	@Column(name = "humidity", length = 5, precision = 2, nullable = false)
	private double humidity;

	@Column(name = "condition", length = 100, nullable = false)
	private String condition;

	@Column(name = "icon", length = 100, nullable = false)
	private String icon;

	@Column(name = "wind_speed", length = 5, precision = 2, nullable = false)
	private double windSpeed;

	@Column(name = "city", length = 200, nullable = false)
	private String city;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
	
	public static Weather fromResultWeatherDTO(ResultWeatherDTO dto) {
		Weather weather = new Weather();
		
		weather.setCondition(dto.getCondition());
		weather.setDate(dto.getDate());
		weather.setHumidity(dto.getHumidity());
		weather.setIcon(dto.getIcon());
		weather.setPressure(dto.getPressure());
		weather.setTempMax(dto.getTempMax());
		weather.setTempMin(dto.getTempMin());
		weather.setCity(dto.getCidade());
		weather.setWindSpeed(dto.getWindSpeed());
		return weather;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
