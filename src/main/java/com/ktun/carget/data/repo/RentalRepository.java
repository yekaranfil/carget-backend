package com.ktun.carget.data.repo;

import com.ktun.carget.data.domain.Location;
import com.ktun.carget.data.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM rentals WHERE "+
            "coalesce(rentalid,'') ilike :rentalid or " +
            "coalesce(vehicleid_fk,'') ilike :vehicleidfk or " +
            "coalesce(userid_fk,'') ilike :useridfk")
    List<Rental> findByLikeIgnoreCase(
            @Param("rentalid") String rentalId,
            @Param("vehicleidfk") String vehicleIdFk,
            @Param("useridfk") String userIdFk
    );


}
