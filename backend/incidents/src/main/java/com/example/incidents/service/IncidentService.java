package com.example.incidents.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.incidents.model.Incident;

public interface IncidentService {
	Incident createIncident(Incident incident);
	List<Incident> getIncidents(LocalDateTime startDate, LocalDateTime endDate);
	Incident updateIncident(int id, String observation);
	List<Incident> getPendingIncidents();
	List<Incident> getAttendedIncidents();

}
