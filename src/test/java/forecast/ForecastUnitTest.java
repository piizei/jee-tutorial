package forecast;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import forecast.domain.Activity;
import forecast.domain.Forecast;

public class ForecastUnitTest {
	
	@Test
	public void testTotalPercentage() {
		
		Activity a1 = new Activity();
		Activity a2 = new Activity();
		
		a1.setDefaultPercentage(30);
		a2.setDefaultPercentage(20);
		
		Forecast f = new Forecast();
		f.setActivities(new HashSet<Activity>());
		f.getActivities().add(a1);
		f.getActivities().add(a2);
		
		assertEquals( 50, f.getTotalPercentage());
	}

}
