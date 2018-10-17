package br.com.cast.weather.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.weather.client.WeatherClient;
import br.com.cast.weather.dto.ResultWeatherDTO;
import br.com.cast.weather.dto.WeatherDTO;
import br.com.cast.weather.dto.WeatherDataDTO;
import br.com.cast.weather.entity.Weather;
import br.com.cast.weather.repository.WeatherRepository;
import br.com.cast.weather.util.Util;

@Service
public class WeatherBusiness {

	@Autowired
	private WeatherClient weatherClient;

	@Autowired
	private WeatherRepository weatherRepository;

	@Transactional
	public List<ResultWeatherDTO> buscarPrevisoesPorCidade(String cidade) {
		cidade = Util.primeiraLetraMaiuscula(cidade);
		
		List<ResultWeatherDTO> previsoes = buscarPorCidade(cidade);
		
		if (previsoes.size() < 5) {
			previsoes.clear();
			
			if (!previsoes.isEmpty()) { 
				weatherRepository.excluirPorCidade(cidade);
			}
			
			WeatherDTO weather = weatherClient.getPrevisaoNaNuvem(cidade);
			
			for (WeatherDataDTO weatherData : weather.getWeatherDatas()) {
				
				ResultWeatherDTO dto = ResultWeatherDTO.fromWeatherDTO(weatherData, cidade);
				
				if (!previsoes.stream().anyMatch(previsao -> previsao.getDate().equals(weatherData.getDate()))) {
					previsoes.add(dto);
					weatherRepository.inserir(Weather.fromResultWeatherDTO(dto));
				}
				
			}

		}
		
		return previsoes;
	}

	private List<ResultWeatherDTO> buscarPorCidade(String cidade) {
		List<Weather> weathers = weatherRepository.getPorDataAtualCidade(cidade);
		return weathers.stream().map(weather -> ResultWeatherDTO.fromWeather(weather)).collect(Collectors.toList());
	}

}
