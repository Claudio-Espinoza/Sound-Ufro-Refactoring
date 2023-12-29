package com.practica.Soundufroback.config.security.model;

import com.practica.Soundufroback.dto.UserSecurityDto;
import com.practica.Soundufroback.model.user.UserModel;
import com.practica.Soundufroback.model.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImplementUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userSecurityDto = userService.findByNickname(username);

        if (userSecurityDto != null) {
            return new ImplementUserDetail(userSecurityDto);
        }

        throw new UsernameNotFoundException("Usuario no encontrado");
    }
}
