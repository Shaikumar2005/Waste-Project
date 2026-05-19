package com.smartwaste.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartwaste.backend.entity.Collector;

public interface CollectorRepository extends JpaRepository<Collector, Long> {

    boolean existsByVehicleId(String vehicleId);
}