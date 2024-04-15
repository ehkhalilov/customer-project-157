package com.example.customerproject157.service;

import com.example.customerproject157.dao.UserRepository;
import com.example.customerproject157.exception.NotFoundException;
import com.example.customerproject157.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserUtil userUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userEntity = userRepository.findByName(username).orElseThrow(
                () -> new NotFoundException("USER_NOT_FOUND")
        );

        return userUtil.getUserDetails(userEntity);
    }
}
