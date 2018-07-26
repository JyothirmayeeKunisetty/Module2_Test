package com.cg.scheduleManagementApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.scheduleManagementApp.beans.ScheduledSessions;
import com.cg.scheduleManagementApp.exceptions.ScheduledSessionNotFound;
import com.cg.scheduleManagementApp.repo.ITrainingDAO;
@Component(value = "TrainingServices")
public class ITrainingServiceImpl implements ITrainingService{
	
	@Autowired(required=true)
	ITrainingDAO repo;
	
	@Override
	public List<ScheduledSessions> getAllSessions() throws ScheduledSessionNotFound{
		//List<SessionManagement> list = new ArrayList<>();
		return repo.findAll();
	}
	
}
