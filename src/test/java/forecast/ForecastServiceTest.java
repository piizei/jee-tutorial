package forecast;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.AssertTrue;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import forecast.domain.Forecast;
import forecast.service.ForecastRepository;
import forecast.service.ForecastService;

import static org.junit.Assert.*;

public class ForecastServiceTest {
	
	ForecastService fs = new ForecastService();
	ForecastRepository mock;
	
	@Before
	public void setup() {
		mock = EasyMock.createMock(ForecastRepository.class);
		fs.setForecastRepository(mock);
	}
	
	@Test 
	public void saveForecast() {		
		Forecast f = new Forecast();		
		mock.saveForecast(f);
		EasyMock.replay(mock);
		fs.saveForecast(f);		
		EasyMock.verify(mock);
	}
	
	@Test 
	public void listForecast() {
		Forecast f1 = new Forecast();
		Forecast f2 = new Forecast();
		mock.saveForecast(f1);
		mock.saveForecast(f2);
		Set forecasts = new HashSet();
		
		EasyMock.expect(mock.listForecasts()).andReturn(forecasts);
		
		EasyMock.replay(mock);
		
		fs.saveForecast(f1);
		fs.saveForecast(f2);
		Set <Forecast> fsList = fs.listForecasts();
		for(Forecast f:fsList) {
			if (f1!=f || f2!=f) fail();
		}	
		EasyMock.verify(mock);
		
	}

}
