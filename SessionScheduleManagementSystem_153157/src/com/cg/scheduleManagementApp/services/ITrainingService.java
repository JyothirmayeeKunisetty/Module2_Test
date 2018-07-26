package com.cg.scheduleManagementApp.services;

import java.util.List;

import com.cg.scheduleManagementApp.beans.ScheduledSessions;
import com.cg.scheduleManagementApp.exceptions.ScheduledSessionNotFound;

public interface ITrainingService {
	public List<ScheduledSessions> getAllSessions() throws ScheduledSessionNotFound;
}