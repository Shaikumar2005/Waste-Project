package com.smartwaste.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartwaste.backend.entity.Collector;
import com.smartwaste.backend.repository.CollectorRepository;
import com.smartwaste.backend.repository.AssignmentRepository;

@Service
public class CollectorService {

    private final CollectorRepository repository;
    private final AssignmentRepository assignmentRepository;

    public CollectorService(
            CollectorRepository repository,
            AssignmentRepository assignmentRepository) {
        this.repository = repository;
        this.assignmentRepository = assignmentRepository;
    }

    /**
     * CREATE COLLECTOR (ADMIN ONLY)
     */
    public Collector createCollector(Collector collector) {

        // 🔒 SAFETY: prevent ID injection
        collector.setId(null);

        // Optional check: one vehicle = one collector
        if (repository.existsByVehicleId(collector.getVehicleId())) {
            throw new RuntimeException("Vehicle already assigned to another collector");
        }

        return repository.save(collector);
    }

    /**
     * GET ALL COLLECTORS
     */
    public List<Collector> getAllCollectors() {
        return repository.findAll();
    }

    /**
     * UPDATE COLLECTOR
     */
    public Collector updateCollector(Long id, Collector updated) {

        Collector collector = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Collector not found"));

        collector.setName(updated.getName());
        collector.setVehicleId(updated.getVehicleId());

        return repository.save(collector);
    }

    /**
     * DELETE COLLECTOR
     * IMPORTANT:
     * First delete dependent assignments to avoid FK constraint error
     */
    public void deleteCollector(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Collector not found");
        }

        // ✅ CRITICAL FIX: remove dependent rows first
        assignmentRepository.deleteByCollectorId(id);

        // ✅ Now safe to delete collector
        repository.deleteById(id);
    }
}