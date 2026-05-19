package com.smartwaste.backend.service;

import org.springframework.stereotype.Service;
import com.smartwaste.backend.entity.VehicleData;
import com.smartwaste.backend.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    public VehicleData saveData(VehicleData data) {
        return repo.save(data);
    }

    public VehicleData getLatest(String vehicleId) {
        return repo.findTopByVehicleIdOrderByTimestampDesc(vehicleId);
    }
}