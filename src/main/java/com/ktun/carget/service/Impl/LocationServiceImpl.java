package com.ktun.carget.service.Impl;

import com.ktun.carget.data.domain.Location;
import com.ktun.carget.data.repo.LocationRepository;
import com.ktun.carget.dto.LocationDTO;
import com.ktun.carget.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationDTO save(LocationDTO locationDTO) {

        Location location = new Location();

        location.setLocationId(location.getLocationId());
        location.setLocationName(locationDTO.getLocationName());
        location.setCreatedAt(locationDTO.getCreatedAt());
        location.setUpdatedAt(locationDTO.getUpdatedAt());


        final Location locationDB = locationRepository.save(location);

        locationDTO.setLocationId(locationDB.getLocationId());
        return locationDTO;
    }

    @Override
    public List<LocationDTO> getAll() {
        List<Location> locations = locationRepository.findAll();
        List<LocationDTO> locationDTOS = new ArrayList<>();

        locations.forEach(it -> {
            LocationDTO locationDTO =new LocationDTO();
            locationDTO.setLocationId(it.getLocationId());
            locationDTO.setLocationName(it.getLocationName());
            locationDTO.setCreatedAt(it.getCreatedAt());
            locationDTO.setUpdatedAt(it.getUpdatedAt());
            locationDTOS.add(locationDTO);

        });
        return locationDTOS;
    }

    @Override
    public List<Location> findByLikeIgnoreCase(String locationId, String locationName) {
        return locationRepository.findByLikeIgnoreCase(locationId,locationName);
    }

}
