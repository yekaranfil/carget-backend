package com.ktun.carget.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ktun.carget.data.repo.RentalRepository;
import com.ktun.carget.dto.RentalDTO;
import com.ktun.carget.dto.UserDTO;
import com.ktun.carget.dto.VehicleDTO;
import com.ktun.carget.service.RentalService;
import com.ktun.carget.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Controller
@RestController
@RequestMapping("/rental")
@RequiredArgsConstructor
public class RentalController implements Serializable {

    private final RentalService rentalService;

    @PostMapping("/setRental")
    @ResponseBody
    public ResponseEntity<RentalDTO> saveUserData(@RequestBody RentalDTO rentalDTO) {

        try {
            return ResponseEntity.ok((RentalDTO) rentalService.save(rentalDTO));


        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAllRental")
    public ResponseEntity<List<RentalDTO>> GetAll() {
        return ResponseEntity.ok(rentalService.getAll());
    }
}
