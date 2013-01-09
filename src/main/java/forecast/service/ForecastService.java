package forecast.service;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import forecast.domain.Forecast;

/**
 * Characteristics of a good service class: 
 * -The operation should be something that relates to a concept that does not naturally fit on an Entity or VO 
 * -The interface is defined in terms of the elements of the Domain Model 
 * -The operation is stateless
 * 
 * @author pjohanss
 * 
 * This service is Facade to functionalities around Forecasts.
 * 
 */
@Service
public class ForecastService implements ForecastRepository{
	
	@Autowired(required=false)
	ForecastRepository forecastRepository;	
	
	public void saveForecast(Forecast forecast) {
		forecastRepository.saveForecast(forecast);		
	}

	public Forecast getForecast(long id) {
		return forecastRepository.getForecast(id);
	}

	public Set<Forecast> listForecasts() {
		return forecastRepository.listForecasts();
	}

	public Set<Forecast> listForecasts(Date start, Date end) {
		return forecastRepository.listForecasts(start, end);
	}
	
	//Housekeeping
	public ForecastRepository getForecastRepository() {
		return forecastRepository;
	}

	public void setForecastRepository(ForecastRepository forecastRepository) {
		this.forecastRepository = forecastRepository;
	}
	
}
