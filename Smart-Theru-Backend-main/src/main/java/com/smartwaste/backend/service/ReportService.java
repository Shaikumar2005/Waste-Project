package com.smartwaste.backend.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.smartwaste.backend.dto.AdminReportDTO;
import com.smartwaste.backend.repository.AssignmentRepository;
import com.smartwaste.backend.repository.CollectorRepository;
import com.smartwaste.backend.repository.RouteRepository;

@Service
public class ReportService {

    private final RouteRepository routeRepo;
    private final CollectorRepository collectorRepo;
    private final AssignmentRepository assignmentRepo;

    public ReportService(
            RouteRepository routeRepo,
            CollectorRepository collectorRepo,
            AssignmentRepository assignmentRepo) {

        this.routeRepo = routeRepo;
        this.collectorRepo = collectorRepo;
        this.assignmentRepo = assignmentRepo;
    }

    public AdminReportDTO getAdminReport() {

        AdminReportDTO dto = new AdminReportDTO();

        dto.setTotalRoutes(routeRepo.count());
        dto.setTotalCollectors(collectorRepo.count());
        dto.setTotalAssignments(assignmentRepo.count());
        dto.setActiveAssignments(
            assignmentRepo.countByCompletedFalse()
        );
        dto.setCompletedAssignments(
            assignmentRepo.countByCompletedTrue()
        );

        return dto;
    }
    public AdminReportDTO getReportByDate(LocalDate from, LocalDate to) {

        AdminReportDTO dto = new AdminReportDTO();

        dto.setTotalAssignments(
            assignmentRepo.countByAssignedDateBetween(from, to)
        );

        dto.setCompletedAssignments(
            assignmentRepo.countByCompletedTrueAndAssignedDateBetween(from, to)
        );

        dto.setActiveAssignments(
            assignmentRepo.countByCompletedFalseAndAssignedDateBetween(from, to)
        );

        return dto;
    }
}