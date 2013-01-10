package forecast.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import forecast.domain.Activity;
import forecast.service.ActivityService;

/**
 * Controller to create, list and update Activities
 * 
 * @author pjohanss
 * 
 */
@Controller
@SessionAttributes("activity")
public class ActivityController {

	@Autowired
	ActivityService activityService;

	/**
	 * Return index page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/activity", method = RequestMethod.GET)
	public String index(Model model) {
		Set activities = activityService.listActivities();
		model.addAttribute("activities", activities);
		return "activity/index";
	}

	/**
	 * Return edit page with empty Activity object (to create a new)
	 * 	 
	 * 
	 * @return
	 */
	@RequestMapping(value = "/activity/create", method = RequestMethod.GET)
	public String create() {
		return "activity/create";
	}

	@ModelAttribute("activity")
	public Activity createActivity() {
		return new Activity();
	}

	/**
	 * Handles form submit of an Activity object. Validates and creates a new
	 * object
	 * 
	 * @param activity
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/activity/create", method = RequestMethod.POST)
	public String submit(@Valid Activity activity, BindingResult result, Model m,SessionStatus sessionStatus) {
		if (result.hasErrors()) {
			return "activity/create";
		} else {
			activityService.saveActivity(activity);
			//Remove activity object from session
			sessionStatus.setComplete();
			// use our index-method to return a list model and go to index page
			return index(m);
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

}
