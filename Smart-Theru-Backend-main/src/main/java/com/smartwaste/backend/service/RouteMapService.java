package com.smartwaste.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartwaste.backend.entity.Route;
import com.smartwaste.backend.entity.RoutePoint;
import com.smartwaste.backend.repository.RoutePointRepository;
import com.smartwaste.backend.repository.RouteRepository;

@Service
public class RouteMapService {

    private final RouteRepository routeRepo;
    private final RoutePointRepository pointRepo;

    public RouteMapService(RouteRepository routeRepo,
                           RoutePointRepository pointRepo) {
        this.routeRepo = routeRepo;
        this.pointRepo = pointRepo;
    }

    public void saveRoutePoints(Long routeId, List<RoutePoint> points) {
        Route route = routeRepo.findById(routeId).orElseThrow();

        int seq = 1;
        for (RoutePoint p : points) {
            p.setRoute(route);
            p.setSequenceNo(seq++);
            pointRepo.save(p);
        }
    }

    public List<RoutePoint> getRoutePoints(Long routeId) {
        return pointRepo.findByRouteId(routeId);
    }
}