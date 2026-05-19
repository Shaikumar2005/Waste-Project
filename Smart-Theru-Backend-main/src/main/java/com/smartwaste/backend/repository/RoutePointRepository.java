package com.smartwaste.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartwaste.backend.entity.RoutePoint;

public interface RoutePointRepository extends JpaRepository<RoutePoint, Long> {

    // Fetch all checkpoints of a route (for live map)
    List<RoutePoint> findByRouteId(Long routeId);
}