package br.com.cast.weather.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.weather.dto.WeatherDTO;

@Component
public class WeatherClient {
	
	@Autowired
	private Environment env;
	
	public WeatherDTO getPrevisaoNaNuvem(String cidade) {
		RestTemplate restTemplate = new RestTemplate();
		
		String appId = env.getProperty("openweather.app_id");
		String weatherApiUrl = env.getProperty("openweather.api_url");
		
		ResponseEntity<WeatherDTO> response = restTemplate.getForEntity(weatherApiUrl, WeatherDTO.class, cidade, appId);
		return response.getBody();
	}
	
}
