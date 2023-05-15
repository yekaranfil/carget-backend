package com.ktun.carget.service.Impl;

import com.ktun.carget.data.domain.Location;
import com.ktun.carget.data.domain.Rental;
import com.ktun.carget.data.repo.RentalRepository;
import com.ktun.carget.dto.LocationDTO;
import com.ktun.carget.dto.RentalDTO;
import com.ktun.carget.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public RentalDTO save(RentalDTO rentalDTO) {

        Rental rental = new Rental();

        rental.setRentalId(rentalDTO.getRentalId());
        rental.setUserIdFk(rentalDTO.getUserIdFk());
        rental.setVehicleIdFk(rentalDTO.getVehicleIdFk());
        rental.setRentalStartDate(rentalDTO.getRentalStartDate());
        rental.setRentalEndDate(rentalDTO.getRentalEndDate());
        rental.setCreatedAt(rentalDTO.getCreatedAt());
        rental.setUpdatedAt(rentalDTO.getUpdatedAt());


        final Rental rentalDB = rentalRepository.save(rental);

        rentalDTO.setRentalId(rentalDB.getRentalId());
        return rentalDTO;
    }

    @Override
    public List<RentalDTO> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        List<RentalDTO> rentalDTOS = new ArrayList<>();

        rentals.forEach(it -> {
            RentalDTO rentalDTO =new RentalDTO();
            rentalDTO.setRentalId(it.getRentalId());
            rentalDTO.setUserIdFk(it.getUserIdFk());
            rentalDTO.setVehicleIdFk(it.getVehicleIdFk());
            rentalDTO.setRentalStartDate(it.getRentalStartDate());
            rentalDTO.setRentalEndDate(it.getRentalEndDate());
            rentalDTO.setCreatedAt(it.getCreatedAt());
            rentalDTO.setUpdatedAt(it.getUpdatedAt());
            rentalDTOS.add(rentalDTO);

        });
        return rentalDTOS;
    }

    @Override
    public List<Rental> findByLikeIgnoreCase(String rentalId, String vehicleIdFk, String userIdFk) {


        return rentalRepository.findByLikeIgnoreCase(rentalId,vehicleIdFk,userIdFk);
    }

}
