package com.smartwaste.backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LocationController {

    private double latitude;
    private double longitude;

    // Receive GPS Data from ESP32
    @PostMapping("/location")
    public String receiveLocation(@RequestBody Map<String, Object> data) {

        latitude = Double.parseDouble(data.get("latitude").toString());
        longitude = Double.parseDouble(data.get("longitude").toString());

        System.out.println("Location Updated");
        System.out.println(latitude);
        System.out.println(longitude);

        return "Location Received Successfully";
    }

    // Send Location to Frontend
    @GetMapping("/location")
    public Map<String, Double> getLocation() {

        Map<String, Double> response = new HashMap<>();

        response.put("latitude", latitude);
        response.put("longitude", longitude);

        return response;
    }
}