package com.ktun.carget.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ktun.carget.data.domain.Rental;
import com.ktun.carget.data.domain.User;
import com.ktun.carget.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDTO save(UserDTO userDTO)  throws JsonProcessingException;
    List<UserDTO> getAll();

    List<User> findByLikeIgnoreCase(
          String userId,
          String firstName,
          String lastName,
          String phone,
          String email,
          String age,
          String driverlicence,
          String address,
          String userRole
    );


}
