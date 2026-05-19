package com.smartwaste.backend.controller;

import com.smartwaste.backend.entity.Location;
import com.smartwaste.backend.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
@CrossOrigin("*")
public class LocationController {

    @Autowired
    private LocationRepository repository;

    @PostMapping
    public Location saveLocation(@RequestBody Location location) {
        return repository.save(location);
    }

    @GetMapping
    public List<Location> getLocations() {
        return repository.findAll();
    }
}