package forecast;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import forecast.domain.Activity;
import forecast.service.ActivityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/TestContext.xml")
public class ActivityServiceIntegrationTest {
	@Autowired
	private ActivityService activityService;	
	
	@Before
	public void setUp() {
		Activity activity = new Activity();
		activityService.saveActivity(activity);
	}
	
	
	@Test
	public void testAddActivity() {		
		Activity activity = new Activity();
		activityService.saveActivity(activity);	
		//Check that id was generated in saving
		assertTrue(activity.getId() > 0);	
	}
	
	@Test
	public void testGetActivity() {	
		Activity activity = activityService.getActivity(1);
		assertEquals(new Long(1),activity.getId());
	}
	
	

}
