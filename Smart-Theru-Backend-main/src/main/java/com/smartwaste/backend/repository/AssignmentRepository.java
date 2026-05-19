package com.smartwaste.backend.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smartwaste.backend.entity.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByCollectorId(Long collectorId);

    void deleteByCollectorId(Long collectorId); // ✅ add this
    long countByCompletedTrue();
    long countByCompletedFalse();
    long countByAssignedDateBetween(LocalDate from, LocalDate to);

    long countByCompletedTrueAndAssignedDateBetween(LocalDate from, LocalDate to);

    long countByCompletedFalseAndAssignedDateBetween(LocalDate from, LocalDate to);
}