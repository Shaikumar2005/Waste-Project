package com.smartwaste.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartwaste.backend.entity.Route;
import com.smartwaste.backend.entity.RoutePoint;
import com.smartwaste.backend.service.RouteMapService;
import com.smartwaste.backend.service.RouteService;

@RestController
@RequestMapping("/api/route-map")
@CrossOrigin("*")
public class RouteMapController {

    private final RouteMapService service;

    public RouteMapController(RouteMapService service) {
        this.service = service;
    }

    // Save points from map
    @PostMapping("/{routeId}/points")
    public void savePoints(@PathVariable Long routeId,
                            @RequestBody List<RoutePoint> points) {
        service.saveRoutePoints(routeId, points);
    }

    // Fetch points for map drawing
    @GetMapping("/{routeId}/points")
    public List<RoutePoint> getPoints(@PathVariable Long routeId) {
        return service.getRoutePoints(routeId);
    }
}