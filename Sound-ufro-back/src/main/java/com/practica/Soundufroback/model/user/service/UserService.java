package com.practica.Soundufroback.model.user.service;

import com.practica.Soundufroback.dto.UserSecurityDto;
import com.practica.Soundufroback.model.user.UserModel;
import org.springframework.stereotype.Service;


public interface UserService {
    UserModel findByNickname(String nickName);
    void saveUser(UserSecurityDto userSecurityDto);
}
