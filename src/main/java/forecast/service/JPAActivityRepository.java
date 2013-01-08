package forecast.service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import forecast.domain.Activity;

@Repository("jpaActivityRepository")
@Transactional
public class JPAActivityRepository implements ActivityRepository{
	
	@PersistenceContext
	EntityManager entityManager;

	public void saveActivity(Activity activity) {
		entityManager.persist(activity);	
	}

	public Activity getActivity(long id) {
		return entityManager.find(Activity.class, new Long(id));
	}

	public Set<Activity> listActivities() {
		return new HashSet<Activity> (entityManager.createQuery("from Activity").getResultList());
	}

}
