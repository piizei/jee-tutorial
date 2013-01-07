package forecast.service;

import java.util.Date;
import java.util.Set;

import forecast.domain.Forecast;

public interface ForecastRepository {
	
	void saveForecast(Forecast forecast);
	Forecast getForecast(long id);
	Set<Forecast> listForecasts();
	Set<Forecast> listForecasts(Date start,Date end);

}
