package com.smartwaste.backend.controller;

import org.springframework.web.bind.annotation.*;
import com.smartwaste.backend.entity.VehicleData;
import com.smartwaste.backend.service.VehicleService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    // ESP32 sends data
    @PostMapping("/data")
    public VehicleData receiveData(@RequestBody VehicleData data) {
        data.setTimestamp(java.time.LocalDateTime.now());
        return service.saveData(data);
    }

    // Angular gets latest location
    @GetMapping("/latest/{vehicleId}")
    public VehicleData latest(@PathVariable String vehicleId) {
        return service.getLatest(vehicleId);
    }
}