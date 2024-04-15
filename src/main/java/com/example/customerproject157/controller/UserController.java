package com.example.customerproject157.controller;


import com.example.customerproject157.model.UserDto;
import com.example.customerproject157.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserDto userDto) {
        userService.register(userDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid UserDto userDto) {
        return userService.login(userDto);
    }

}
