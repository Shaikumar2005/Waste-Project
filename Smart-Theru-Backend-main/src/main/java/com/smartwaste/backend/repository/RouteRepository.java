package com.smartwaste.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartwaste.backend.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
    // No extra methods needed for now
}