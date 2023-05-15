package com.ktun.carget.data.repo;

import com.ktun.carget.data.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM locations WHERE "+
            "coalesce(locationid,'') ilike %:locationId% and " +
            "coalesce(location_name,'') ilike %:locationName%")
    List<Location> findByLikeIgnoreCase(
            @Param("locationId") String locationId,
            @Param("locationName") String locationName);


}
