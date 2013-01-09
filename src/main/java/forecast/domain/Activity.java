package forecast.domain;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Max;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Activities")
public class Activity {
	
	Long id;
	
	Date startDate;
	Date endDate;
	@Max(100)
	int defaultPercentage;
	String assigmentName;
	String type; //Fixed or TM
	
	
	
	@Id
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	public String getAssigmentName() {
		return assigmentName;
	}

	public void setAssigmentName(String assigmentName) {
		this.assigmentName = assigmentName;
	}

	public int getDefaultPercentage() {
		return defaultPercentage;
	}

	public void setDefaultPercentage(int defaultPercentage) {
		this.defaultPercentage = defaultPercentage;
	}
	

}
