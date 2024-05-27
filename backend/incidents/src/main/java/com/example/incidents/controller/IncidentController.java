package com.example.incidents.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.incidents.model.Incident;
import com.example.incidents.service.IncidentService;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {
	
	private final IncidentService incidentService;
	
	@Autowired
	public IncidentController(IncidentService incidentService) {
		this.incidentService = incidentService;
	}
	
	@PostMapping
	public ResponseEntity<Incident> createIncident(@RequestBody Incident incident) {
		Incident createdIncident = incidentService.createIncident(incident);
		return ResponseEntity.ok(createdIncident);
	}
	
	@GetMapping
	 public ResponseEntity<List<Incident>> getIncidents(
	            @RequestParam("startDate") LocalDateTime startDate,
	            @RequestParam("endDate") LocalDateTime endDate) {
	        List<Incident> incidents = incidentService.getIncidents(startDate, endDate);
	        return ResponseEntity.ok(incidents);
	    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Incident> updateIncident(
            @PathVariable int id,
            @RequestBody String observation) {
        Incident updatedIncident = incidentService.updateIncident(id, observation);
        return ResponseEntity.ok(updatedIncident);
    }
	
	@GetMapping("/pending")
	 public ResponseEntity<List<Incident>> getPendingIncidents() {
        List<Incident> pendingIncidents = incidentService.getPendingIncidents();
        return ResponseEntity.ok(pendingIncidents);
    }
	
	@GetMapping("/attended")
	public ResponseEntity<List<Incident>> getAttendedIncidents() {
	    List<Incident> attendedIncidents = incidentService.getAttendedIncidents();
	    return ResponseEntity.ok(attendedIncidents);
	}

}
