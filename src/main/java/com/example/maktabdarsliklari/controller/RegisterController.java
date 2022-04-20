package com.example.maktabdarsliklari.controller;

import com.example.maktabdarsliklari.dto.LoginDTO;
import com.example.maktabdarsliklari.entity.User;
import com.example.maktabdarsliklari.entity.enums.RoleEnum;
import com.example.maktabdarsliklari.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegisterController {
    final PasswordEncoder passwordEncoder;
    final UserRepository userRepository;


    @PostMapping()
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        User user=new User();
        user.setRoleName(RoleEnum.USER);
        user.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
        user.setFullName(loginDTO.getName());
        userRepository.save(user);

        return ResponseEntity.ok().body("ok");
    }
}
