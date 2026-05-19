package com.smartwaste.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.smartwaste.backend.entity.Assignment;
import com.smartwaste.backend.service.AssignmentService;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin("*")
public class AssignmentController {

    private final AssignmentService service;

    public AssignmentController(AssignmentService service) {
        this.service = service;
    }

    // ✅ ASSIGN ROUTE
    @PostMapping
    public Assignment assign(
            @RequestParam Long routeId,
            @RequestParam Long collectorId) {
        return service.assignRoute(routeId, collectorId);
    }

    // ✅ GET ASSIGNMENTS FOR ONE COLLECTOR
    @GetMapping("/collector/{collectorId}")
    public List<Assignment> collectorAssignments(
            @PathVariable Long collectorId) {
        return service.getAssignmentsForCollector(collectorId);
    }

    // ✅ DE-ASSIGN ROUTE
    @DeleteMapping("/{assignmentId}")
    public void deAssign(@PathVariable Long assignmentId) {
        service.deAssignRoute(assignmentId);
    }

    // ✅ ✅ ✅ THIS WAS MISSING (VERY IMPORTANT)
    @GetMapping
    public List<Assignment> getAllAssignments() {
        return service.getAllAssignments();
    }
}
