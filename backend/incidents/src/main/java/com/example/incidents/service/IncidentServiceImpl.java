package com.example.incidents.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.incidents.model.Incident;
import com.example.incidents.repository.IncidentRepository;

@Service
public class IncidentServiceImpl implements IncidentService {
	
	private final IncidentRepository incidentRepository;
	
	@Autowired
	public IncidentServiceImpl(IncidentRepository incidentRepository) {
		this.incidentRepository = incidentRepository;
	}
	
	@Override
	public Incident createIncident(Incident incident) {
		incident.setCreatedAt(LocalDateTime.now());
		incident.setStatus("Pendiente");
		return incidentRepository.save(incident);
	}
	
	@Override
	public List<Incident> getIncidents(LocalDateTime startDate, LocalDateTime endDate){
		return incidentRepository.findByCreatedAtBetween(startDate, endDate);
	}
	
	@Override
	public Incident updateIncident(int id, String observation) {
		Incident incident = incidentRepository.findById(id).orElseThrow(() -> new RuntimeException("Incident not found"));
		incident.setStatus("Atendida");
		incident.setObservation(observation);
		incident.setUpdateAt(LocalDateTime.now());
		return incidentRepository.save(incident);
	}
	
	@Override
	public List<Incident> getPendingIncidents(){
		return incidentRepository.findByStatus("Pendiente");
	}
	
	@Override
	public List<Incident> getAttendedIncidents(){
		return incidentRepository.findByStatus("Atendida");
	}
	
	

}
