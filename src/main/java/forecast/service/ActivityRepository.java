package forecast.service;

import java.util.Set;

import forecast.domain.Activity;

public interface ActivityRepository {
	void saveActivity(Activity activity);
	Activity getActivity(long id);
	Set<Activity> listActivities();
}
