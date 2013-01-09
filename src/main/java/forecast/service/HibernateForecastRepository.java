package forecast.service;

import java.util.Date;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import forecast.domain.Forecast;

@Repository
@Transactional
public class HibernateForecastRepository implements ForecastRepository {
	
	

	public void saveForecast(Forecast forecast) {
		// TODO Auto-generated method stub
		
	}

	public Forecast getForecast(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Forecast> listForecasts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Forecast> listForecasts(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	

}
