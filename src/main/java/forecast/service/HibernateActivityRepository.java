package forecast.service;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import forecast.domain.Activity;

@Repository("hibernateActivityRepository")
@Transactional
public class HibernateActivityRepository implements ActivityRepository{
	
	 private HibernateTemplate hibernateTemplate;
	 	 
	 @Autowired
	 public void setSessionFactory(SessionFactory sessionFactory) {
	       hibernateTemplate = new HibernateTemplate(sessionFactory);
	 }

	public void saveActivity(Activity activity) {
		hibernateTemplate.saveOrUpdate(activity);
		
	}

	public Activity getActivity(long id) {
		return hibernateTemplate.get(Activity.class, id);
	}

	public Set<Activity> listActivities() {
		return new HashSet<Activity> (hibernateTemplate.find("from Activity"));
	}

}
