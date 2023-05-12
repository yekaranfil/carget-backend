package com.ktun.carget.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ktun.carget.data.repo.UserRepository;
import com.ktun.carget.dto.UserDTO;
import com.ktun.carget.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/setUser")
    @ResponseBody
    public ResponseEntity<UserDTO> saveUserData(@RequestBody UserDTO userDTO) {

        try {
            return ResponseEntity.ok((UserDTO) userService.save(userDTO));


        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserDTO>> GetAll() {
        return ResponseEntity.ok(userService.getAll());
    }
}
