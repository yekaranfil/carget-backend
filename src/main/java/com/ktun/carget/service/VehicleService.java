package com.ktun.carget.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ktun.carget.dto.UserDTO;
import com.ktun.carget.dto.VehicleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    VehicleDTO save(VehicleDTO vehicleDTO)  throws JsonProcessingException;

    List<VehicleDTO> getAll();
}
