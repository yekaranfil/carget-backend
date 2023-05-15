package com.ktun.carget.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ktun.carget.data.domain.Location;
import com.ktun.carget.data.repo.LocationRepository;
import com.ktun.carget.data.repo.UserRepository;
import com.ktun.carget.dto.LocationDTO;
import com.ktun.carget.dto.UserDTO;
import com.ktun.carget.service.LocationService;
import com.ktun.carget.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Controller
@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController implements Serializable {

    private final LocationService locationService;
    private final LocationRepository locationRepository;

    @PostMapping("/setLocation")
    @ResponseBody
    public ResponseEntity<LocationDTO> saveUserData(@RequestBody LocationDTO locationDTO) {

        try {
            return ResponseEntity.ok((LocationDTO) locationService.save(locationDTO));


        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAllLocation")
    public ResponseEntity<List<LocationDTO>> GetAll() {
        return ResponseEntity.ok(locationService.getAll());
    }

    @GetMapping("/findByLikeIgnoreCase")
    @ResponseBody
    public ResponseEntity<List<Location>> findByLikeIgnoreCase( @RequestParam(required = false, defaultValue = "") String locationId,
                                                                @RequestParam(required = false,defaultValue = "") String locationName){
        return  ResponseEntity.ok(locationService.findByLikeIgnoreCase(locationId , locationName));
    }
}
