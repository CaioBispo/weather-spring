package br.com.cast.weather.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.weather.business.WeatherBusiness;
import br.com.cast.weather.dto.ResultWeatherDTO;

@RestController
@RequestMapping("/")
public class WeatherAPI {

	@Autowired
	private WeatherBusiness weatherBusiness;
	
	@RequestMapping(path = "{city}", method = RequestMethod.GET)
	public List<ResultWeatherDTO> getWeatherForecast(@PathVariable("city") String city) {
		List<ResultWeatherDTO> previsoes = weatherBusiness.buscarPrevisoesPorCidade(city);
		return previsoes;
	}
}