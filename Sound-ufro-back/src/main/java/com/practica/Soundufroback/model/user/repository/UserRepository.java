package com.practica.Soundufroback.model.user.repository;

import com.practica.Soundufroback.dto.UserSecurityDto;
import com.practica.Soundufroback.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
    UserModel findByNickname(String nickName);


}

