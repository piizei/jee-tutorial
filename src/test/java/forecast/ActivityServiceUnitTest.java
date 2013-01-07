package forecast;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import forecast.domain.Activity;
import forecast.service.ActivityRepository;
import forecast.service.ActivityService;

public class ActivityServiceUnitTest {
		
	private ActivityService activityService;
	private ActivityRepository mock;
	
	@Before
	public void setUp() {
		
		mock = EasyMock.createMock(ActivityRepository.class);
		
		activityService = new ActivityService();
		activityService.setActivityRepository(mock);
	}
	
	@Test
	public void testAddActivity() {		
		Activity activity = new Activity();
		//DEFINE Expectations:
		//Expect service to save activity and then 
		mock.saveActivity(activity);
		EasyMock.replay(mock);
		//Run test, and see if mock was used correctly:
		activityService.saveActivity(activity);
		EasyMock.verify(mock);
	}

}
