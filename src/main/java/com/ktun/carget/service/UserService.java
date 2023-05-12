package com.ktun.carget.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ktun.carget.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDTO save(UserDTO userDTO)  throws JsonProcessingException;
    List<UserDTO> getAll();


}
