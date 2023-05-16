package com.ktun.carget.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ktun.carget.data.domain.Vehicle;
import com.ktun.carget.dto.UserDTO;
import com.ktun.carget.dto.VehicleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    VehicleDTO save(VehicleDTO vehicleDTO)  throws JsonProcessingException;

    List<VehicleDTO> getAll();

    List<Vehicle> findByLikeIgnoreCase(
            String vehicleId,
            String vehicleClass,
            String vehicleBrand,
            String vehicleModel,
            String vehicleLocationFk,
            String capacity,
            String maxdistance,
            String vehicleColor,
            String vehicleGearbox,
            String vehiclePrice,
            String vehicleFuel
    );

    List<Vehicle> findAvailableVehicles(String startDate,
                                        String endDate,
                                        String locationName);
}
