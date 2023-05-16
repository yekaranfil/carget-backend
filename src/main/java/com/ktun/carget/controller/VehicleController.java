package com.ktun.carget.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ktun.carget.data.domain.Vehicle;
import com.ktun.carget.dto.LocationDTO;
import com.ktun.carget.dto.UserDTO;
import com.ktun.carget.dto.VehicleDTO;
import com.ktun.carget.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Controller
@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController  implements Serializable {

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


    @GetMapping("/findByLikeIgnoreCase")
    @ResponseBody
    public ResponseEntity<List<Vehicle>> findByLikeIgnoreCase(@RequestParam(required = false, defaultValue = "") String vehicleId,
                                                              @RequestParam(required = false,defaultValue = "") String vehicleClass,
                                                              @RequestParam(required = false,defaultValue = "") String vehicleBrand,
                                                              @RequestParam(required = false,defaultValue = "") String vehicleModel,
                                                              @RequestParam(required = false,defaultValue = "") String vehicleLocationFk,
                                                              @RequestParam(required = false,defaultValue = "") String capacity,
                                                              @RequestParam(required = false,defaultValue = "") String maxdistance,
                                                              @RequestParam(required = false,defaultValue = "") String vehicleColor,
                                                              @RequestParam(required = false,defaultValue = "") String vehicleGearbox,
                                                              @RequestParam(required = false,defaultValue = "") String vehiclePrice,
                                                              @RequestParam(required = false,defaultValue = "") String vehicleFuel)
    {
        return  ResponseEntity.ok(vehicleService.findByLikeIgnoreCase(vehicleId,vehicleClass,vehicleBrand,vehicleModel,vehicleLocationFk,capacity,maxdistance,vehicleColor,vehicleGearbox,vehiclePrice,vehicleFuel));
    }


    @GetMapping("/vehiclesAvailable")
    public ResponseEntity<List<Vehicle>> getAvailableVehicles(
                                                             @RequestParam(value = "startDate", required = true) String startDate,
                                                             @RequestParam(value = "endDate", required = true) String endDate,
                                                             @RequestParam(value = "locationName", required = true) String locationName) {

        return  ResponseEntity.ok(vehicleService.findAvailableVehicles(startDate,endDate,locationName));

    }
}


