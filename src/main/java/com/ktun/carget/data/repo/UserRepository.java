package com.ktun.carget.data.repo;

import com.ktun.carget.data.domain.Rental;
import com.ktun.carget.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE "+
            "coalesce(userid,'') ilike %:userid% and " +
            "coalesce(firstname,'') ilike %:firstname% and " +
            "coalesce(lastname,'') ilike %:lastname% and " +
            "coalesce(phone,'') ilike %:phone% and " +
            "coalesce(email,'') ilike %:email% and " +
            "coalesce(age,'') ilike %:age% and " +
            "coalesce(driver_licence,'') ilike %:driverlicence% and " +
            "coalesce(address,'') ilike %:address%"
    )
    List<User> findByLikeIgnoreCase(
            @Param("userid") String userId,
            @Param("firstname") String firstName,
            @Param("lastname") String lastName,
            @Param("phone") String phone,
            @Param("email") String email,
            @Param("age") String age,
            @Param("driverlicence") String driverlicence,
            @Param("address") String address
    );
}
