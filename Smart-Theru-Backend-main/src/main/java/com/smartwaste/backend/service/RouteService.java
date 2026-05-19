package com.smartwaste.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartwaste.backend.entity.Route;
import com.smartwaste.backend.repository.RouteRepository;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    /**
     * CREATE NEW ROUTE
     * IMPORTANT: id must be null so Hibernate performs INSERT
     */
    public Route createRoute(Route route) {
        route.setId(null);            // 🔥 CRITICAL FIX
        return routeRepository.save(route);
    }

    /**
     * GET ALL ROUTES
     */
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    /**
     * UPDATE EXISTING ROUTE
     */
    public Route updateRoute(Long id, Route updated) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));

        route.setRouteName(updated.getRouteName());
        route.setActive(updated.isActive());

        return routeRepository.save(route);
    }

    /**
     * DELETE ROUTE
     */
    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }
}
