package com.ktun.carget.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ktun.carget.dto.LocationDTO;
import com.ktun.carget.dto.UserDTO;
import com.ktun.carget.dto.VehicleDTO;
import com.ktun.carget.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/setVehicle")
    @ResponseBody
    public ResponseEntity<VehicleDTO> saveUserData(@RequestBody VehicleDTO vehicleDTO) {

        try {
            return ResponseEntity.ok((VehicleDTO) vehicleService.save(vehicleDTO));


        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAllVehicle")
    public ResponseEntity<List<VehicleDTO>> GetAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }
}
