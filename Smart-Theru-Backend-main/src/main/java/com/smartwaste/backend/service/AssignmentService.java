package com.smartwaste.backend.service;

import java.time.LocalDate;

import java.util.List;


import org.springframework.stereotype.Service;

import com.smartwaste.backend.entity.Assignment;
import com.smartwaste.backend.repository.AssignmentRepository;
import com.smartwaste.backend.repository.CollectorRepository;
import com.smartwaste.backend.repository.RouteRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepo;
    private final RouteRepository routeRepo;
    private final CollectorRepository collectorRepo;

    public AssignmentService(
        AssignmentRepository assignmentRepo,
        RouteRepository routeRepo,
        CollectorRepository collectorRepo) {

        this.assignmentRepo = assignmentRepo;
        this.routeRepo = routeRepo;
        this.collectorRepo = collectorRepo;
    }

    public Assignment assignRoute(Long routeId, Long collectorId) {
        Assignment a = new Assignment();
        a.setRoute(routeRepo.findById(routeId).orElseThrow());
        a.setCollector(collectorRepo.findById(collectorId).orElseThrow());
        a.setAssignedDate(LocalDate.now());
        return assignmentRepo.save(a);
    }

    public List<Assignment> getAssignmentsForCollector(Long collectorId) {
        return assignmentRepo.findByCollectorId(collectorId);
    }
    @Transactional
    public void deAssignRoute(Long assignmentId) {
        assignmentRepo.deleteById(assignmentId);
    }
    
    public List<Assignment> getAllAssignments() {
        return assignmentRepo.findAll();
    }
}
