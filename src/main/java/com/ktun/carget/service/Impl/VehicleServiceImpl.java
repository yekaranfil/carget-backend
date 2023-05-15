package com.ktun.carget.service.Impl;

import com.ktun.carget.data.domain.Location;
import com.ktun.carget.data.domain.User;
import com.ktun.carget.data.domain.Vehicle;
import com.ktun.carget.data.repo.VehicleRepository;
import com.ktun.carget.dto.LocationDTO;
import com.ktun.carget.dto.VehicleDTO;
import com.ktun.carget.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements  VehicleService {

    @Autowired
    private final VehicleRepository vehicleRepository;


    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    public VehicleDTO save(VehicleDTO vehicleDTO) {
            Vehicle vehicle = new Vehicle();

            vehicle.setVehicleId(vehicleDTO.getVehicleId());
            vehicle.setVehicleClass(vehicleDTO.getVehicleClass());
            vehicle.setVehicleModel(vehicleDTO.getVehicleModel());
            vehicle.setVehicleBrand(vehicleDTO.getVehicleBrand());
            vehicle.setVehicleLocationFk(vehicleDTO.getVehicleLocationFk());
            vehicle.setVehicleCapacity(vehicleDTO.getVehicleCapacity());
            vehicle.setVehicleMaxDistance(vehicleDTO.getVehicleMaxDistance());
            vehicle.setVehicleColor(vehicleDTO.getVehicleColor());
            vehicle.setVehicleGearbox(vehicleDTO.getVehicleGearbox());
            vehicle.setVehiclePrice(vehicleDTO.getVehiclePrice());
            vehicle.setVehicleFuel(vehicleDTO.getVehicleFuel());
            vehicle.setVehicleImage(vehicleDTO.getVehicleImage());
            vehicle.setCreatedAt(vehicleDTO.getCreatedAt());
            vehicle.setUpdatedAt(vehicleDTO.getUpdatedAt());

            final Vehicle vehicleDB = vehicleRepository.save(vehicle);
            vehicleDTO.setVehicleId(vehicleDB.getVehicleId());

            return vehicleDTO;

    }

    @Override
    public List<VehicleDTO> getAll() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();

        vehicles.forEach(it -> {
            VehicleDTO vehicleDTO =new VehicleDTO();
            vehicleDTO.setVehicleId(it.getVehicleId());
            vehicleDTO.setVehicleClass(it.getVehicleClass());
            vehicleDTO.setVehicleModel(it.getVehicleModel());
            vehicleDTO.setVehicleBrand(it.getVehicleBrand());
            vehicleDTO.setVehicleLocationFk(it.getVehicleLocationFk());
            vehicleDTO.setVehicleCapacity(it.getVehicleCapacity());
            vehicleDTO.setVehicleMaxDistance(it.getVehicleMaxDistance());
            vehicleDTO.setVehicleColor(it.getVehicleColor());
            vehicleDTO.setVehicleGearbox(it.getVehicleGearbox());
            vehicleDTO.setVehiclePrice(it.getVehiclePrice());
            vehicleDTO.setVehicleFuel(it.getVehicleFuel());
            vehicleDTO.setVehicleImage(it.getVehicleImage());
            vehicleDTO.setCreatedAt(it.getCreatedAt());
            vehicleDTO.setUpdatedAt(it.getUpdatedAt());
            vehicleDTOS.add(vehicleDTO);

        });
        return vehicleDTOS;
    }

    @Override
    public List<Vehicle> findByLikeIgnoreCase(String vehicleId, String vehicleClass, String vehicleBrand, String vehicleModel, String vehicleLocationFk, String capacity, String maxdistance, String vehicleColor, String vehicleGearbox, String vehiclePrice, String vehicleFuel) {
        return vehicleRepository.findByLikeIgnoreCase(vehicleId,vehicleClass,vehicleBrand,vehicleModel,vehicleLocationFk,capacity,maxdistance,vehicleColor,vehicleGearbox,vehiclePrice,vehicleFuel);

    }
}
