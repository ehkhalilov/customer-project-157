package com.example.customerproject157.util;

import com.example.customerproject157.dao.RoleEntity;
import com.example.customerproject157.dao.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserUtil {

    public UserDetails getUserDetails(UserEntity userEntity) {

        return new User(
                userEntity.getName(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                true, true, true,
                getAuthorities(userEntity)
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(UserEntity userEntity) {
        List<RoleEntity> roles = userEntity.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (RoleEntity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole().toString()));
        }

        return authorities;
    }
}
