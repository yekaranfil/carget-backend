package com.ktun.carget.data.repo;

import com.ktun.carget.data.domain.Rental;
import com.ktun.carget.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE "+
            "coalesce(userid,'') ilike :userid or " +
            "coalesce(firstname,'') ilike :firstname or " +
            "coalesce(lastname,'') ilike :lastname or " +
            "coalesce(phone,'') ilike :phone or " +
            "coalesce(email,'') ilike :email or " +
            "coalesce(age,'') ilike :age or " +
            "coalesce(driver_licence,'') ilike :driverlicence or " +
            "coalesce(address,'') ilike :address or " +
            "coalesce(user_role,'') ilike :userrole"
    )
    List<User> findByLikeIgnoreCase(
            @Param("userid") String userId,
            @Param("firstname") String firstName,
            @Param("lastname") String lastName,
            @Param("phone") String phone,
            @Param("email") String email,
            @Param("age") String age,
            @Param("driverlicence") String driverlicence,
            @Param("address") String address,
            @Param("userrole") String userRole
    );
}
