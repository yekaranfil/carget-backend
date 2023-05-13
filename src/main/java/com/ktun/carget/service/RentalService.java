package com.ktun.carget.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ktun.carget.dto.LocationDTO;
import com.ktun.carget.dto.RentalDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface RentalService {

    RentalDTO save(RentalDTO rentalDTO) throws JsonProcessingException;
    List<RentalDTO> getAll();
}
