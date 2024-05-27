package com.example.incidents.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.incidents.model.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Integer>{
	
	List<Incident> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
	List<Incident> findByStatus(String staus);

}
