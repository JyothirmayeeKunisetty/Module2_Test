package com.cg.scheduleManagementApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.scheduleManagementApp.beans.ScheduledSessions;
import com.cg.scheduleManagementApp.exceptions.ScheduledSessionNotFound;
import com.cg.scheduleManagementApp.services.ITrainingService;

@Controller
public class TrainingController {
	
	@Autowired
	ITrainingService TrainingServices;
	
	@RequestMapping(value="/")
	public ModelAndView getAllSessions() {
		List<ScheduledSessions> sessions;
		try {
			sessions = TrainingServices.getAllSessions();
		} catch (ScheduledSessionNotFound e) {
			return new ModelAndView("getAllSessions","errorPage",e.getMessage());
		}
		return new ModelAndView("getAllSessions","sessionManagement",sessions);	
	}
	
	@RequestMapping(value="enroll")
	public ModelAndView getEnrolledPage() {
		String message = "Successfully enrolled";
		return new ModelAndView("success","enroll",message);
	}
	
	@RequestMapping(value="/getDetails/{name}",method=RequestMethod.GET)  
    public ModelAndView edit(@PathVariable String name){
		System.out.println("\n\n\n\n" + name + "\n\n\n\n");
		String message = "You are enrolled to: " + name;
		return new ModelAndView("success","enroll",message);
	}
//	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)  
//    public ModelAndView edit(@PathVariable int id){  
//		try {
//			Faculty faculty = facultyServices.getFacultyDetails(id);
//			return new ModelAndView("update","command",faculty);
//		} catch (FacultyDetailsNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ServicesDownException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//        return new ModelAndView("errorPage");
//    } 
	
	
}
