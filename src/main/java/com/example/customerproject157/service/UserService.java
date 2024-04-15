package com.example.customerproject157.service;

import com.example.customerproject157.dao.RoleEntity;
import com.example.customerproject157.dao.UserEntity;
import com.example.customerproject157.dao.UserRepository;
import com.example.customerproject157.exception.NotFoundException;
import com.example.customerproject157.model.Role;
import com.example.customerproject157.model.UserDto;
import com.example.customerproject157.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserUtil util;

    public void register(UserDto userDto) {
        var user = UserEntity.builder()
                .name(userDto.getName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .enabled(true)
                .build();

        var role = RoleEntity.builder()
                .role(Role.ROLE_USER)
                .build();

        user.setRoles(List.of(role));
        role.setUsers(List.of(user));

        userRepository.save(user);
    }

    public String login(UserDto userDto) {
        var userEntity = userRepository.findByName(userDto.getName()).orElseThrow(
                () -> new NotFoundException("USER_NOT_FOUND")
        );
        return jwtService.generateToken(util.getUserDetails(userEntity));
    }
}
