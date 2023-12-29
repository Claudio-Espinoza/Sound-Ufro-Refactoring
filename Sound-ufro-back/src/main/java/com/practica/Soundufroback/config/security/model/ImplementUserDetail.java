package com.practica.Soundufroback.config.security.model;

import com.practica.Soundufroback.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@AllArgsConstructor
public class ImplementUserDetail implements UserDetails {

    private UserModel UserSecurityDto;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(UserSecurityDto.getRole().toString()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return UserSecurityDto.getPassword();
    }

    @Override
    public String getUsername() {
        return UserSecurityDto.getNickname();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
