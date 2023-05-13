package com.ktun.carget.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ktun.carget.dto.LocationDTO;
import com.ktun.carget.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface LocationService {
    LocationDTO save(LocationDTO locationDTO) throws JsonProcessingException;

    List<LocationDTO> getAll();

}
