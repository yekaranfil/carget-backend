package com.ktun.carget.service.Impl;

import com.ktun.carget.data.domain.Rental;
import com.ktun.carget.data.domain.User;
import com.ktun.carget.data.repo.UserRepository;
import com.ktun.carget.dto.UserDTO;
import com.ktun.carget.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.DataTruncation;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO save(UserDTO userDTO) {

        User user = new User();

        user.setUserId(userDTO.getUserId());
        user.setUserFirstName(userDTO.getUserFirstName());
        user.setUserLastName(userDTO.getUserLastName());
        user.setUserPhone(userDTO.getUserPhone());
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserAge(userDTO.getUserAge());
        user.setDriverLicence(userDTO.getDriverLicence());
        user.setUserImage(userDTO.getUserImage());
        user.setUserAddress(userDTO.getUserAddress());
        user.setUserPassword(userDTO.getUserPassword());
        user.setBirthday(userDTO.getBirthday());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setUpdatedAt(userDTO.getUpdatedAt());
        user.setUserRole(userDTO.getUserRole());

        final User userDB = userRepository.save(user);

        userDTO.setUserId(userDB.getUserId());
        return userDTO;
    }



    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();

        users.forEach(it -> {
            UserDTO userDTO =new UserDTO();
            userDTO.setUserId(it.getUserId());
            userDTO.setUserFirstName(it.getUserFirstName());
            userDTO.setUserLastName(it.getUserLastName());
            userDTO.setUserPhone(it.getUserPhone());
            userDTO.setUserAge(it.getUserAge());
            userDTO.setUserEmail(it.getUserEmail());
            userDTO.setUserAddress(it.getUserAddress());
            userDTO.setDriverLicence(it.getDriverLicence());
            userDTO.setUserPassword(it.getUserPassword());
            userDTO.setBirthday(it.getBirthday());
            userDTO.setUserImage(it.getUserImage());
            userDTO.setCreatedAt(it.getCreatedAt());
            userDTO.setUpdatedAt(it.getUpdatedAt());
            userDTO.setUserRole(it.getUserRole());
            userDTOS.add(userDTO);
        });
        return userDTOS;
    }

    @Override
    public List<User> findByLikeIgnoreCase(String userId, String firstName, String lastName, String phone, String email, String age, String driverlicence, String address, String userRole) {
        return userRepository.findByLikeIgnoreCase(userId,firstName,lastName,phone,email,age,driverlicence,address,userRole);
    }

}
