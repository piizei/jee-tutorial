package forecast.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import forecast.domain.Activity;
import forecast.domain.Group;

/**
 * Characteristics of a good service class: 
 * -The operation should be something that relates to a concept that does not naturally fit on an Entity or VO 
 * -The interface is defined in terms of the elements of the Domain Model 
 * -The operation is stateless
 * 
 * @author pjohanss
 * 
 * This service is Facade to functionalities around Activities.
 * 
 */

@Service
public class ActivityService implements ActivityRepository {
	
	@Autowired
	@Qualifier("hibernateActivityRepository")
	ActivityRepository activityRepository;

	Set<Activity> collectTeamsActivities(Group team) {
		// TODO: Unimplemented
		return null;
	}

	/*
	 * Delegate to repository
	 */
	public Activity getActivity(long id) {
		return activityRepository.getActivity(id);
	}

	public Set<Activity> listActivities() {
		return activityRepository.listActivities();
	}

	public void saveActivity(Activity activity) {
		activityRepository.saveActivity(activity);
	}

	// Housekeeping methods

	public ActivityRepository getActivityRepository() {
		return activityRepository;
	}

	public void setActivityRepository(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

}
