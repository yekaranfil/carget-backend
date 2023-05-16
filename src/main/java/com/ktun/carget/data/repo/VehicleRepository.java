package com.ktun.carget.data.repo;

import com.ktun.carget.data.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM vehicles WHERE "+
            "coalesce(vehicleid,'') ilike :vehicleid or " +
            "coalesce(vehicle_class,'') ilike :vehicleclass or " +
            "coalesce(vehicle_brand,'') ilike :vehiclebrand or " +
            "coalesce(vehicle_model,'') ilike :vehiclemodel or " +
            "coalesce(vehicle_location_fk,'') ilike :vehiclelocationfk or " +
            "coalesce(capacity,'') ilike :capacity or " +
            "coalesce(max_distance,'') ilike :maxdistance or " +
            "coalesce(vehicle_color,'') ilike :vehiclecolor or " +
            "coalesce(vehicle_gearbox,'') ilike :vehiclegearbox or " +
            "coalesce(vehicle_price,'') ilike :vehicleprice or " +
            "coalesce(vehicle_fuel,'') ilike :vehiclefuel"
    )
    List<Vehicle> findByLikeIgnoreCase(
            @Param("vehicleid") String vehicleId,
            @Param("vehicleclass") String vehicleClass,
            @Param("vehiclebrand") String vehicleBrand,
            @Param("vehiclemodel") String vehicleModel,
            @Param("vehiclelocationfk") String vehicleLocationFk,
            @Param("capacity") String capacity,
            @Param("maxdistance") String maxdistance,
            @Param("vehiclecolor") String vehicleColor,
            @Param("vehiclegearbox") String vehicleGearbox,
            @Param("vehicleprice") String vehiclePrice,
            @Param("vehiclefuel") String vehicleFuel
    );


    @Query(value = "SELECT * FROM vehicles " +
            "WHERE vehicleid NOT IN (" +
            "  SELECT vehicleid_fk FROM rentals " +
            "  WHERE (:startDate BETWEEN rental_start_date AND rental_end_date) " +
            "    OR (:endDate BETWEEN rental_start_date AND rental_end_date)" +
            ") " +
            "AND vehicle_location_fk = (" +
            "  SELECT locationid FROM locations " +
            "  WHERE location_name = :locationName" +
            ")", nativeQuery = true)
    List<Vehicle> findAvailableVehicles(@Param("startDate") ZonedDateTime startDate,
                                        @Param("endDate") ZonedDateTime endDate,
                                        @Param("locationName") String locationName);

}
