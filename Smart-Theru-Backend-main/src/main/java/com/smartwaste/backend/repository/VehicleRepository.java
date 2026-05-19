package com.smartwaste.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartwaste.backend.entity.VehicleData;

public interface VehicleRepository 
       extends JpaRepository<VehicleData, Integer> {

    VehicleData findTopByVehicleIdOrderByTimestampDesc(String vehicleId);
}