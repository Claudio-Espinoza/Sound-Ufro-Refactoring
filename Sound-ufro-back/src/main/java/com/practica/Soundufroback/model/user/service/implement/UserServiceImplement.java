package com.practica.Soundufroback.model.user.service.implement;

import com.practica.Soundufroback.dto.UserSecurityDto;
import com.practica.Soundufroback.model.user.UserModel;
import com.practica.Soundufroback.model.user.repository.UserRepository;
import com.practica.Soundufroback.model.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserModel findByNickname(String nickName) throws NullPointerException {
         return userRepository.findByNickname(nickName);
    }

    @Override
    public void saveUser(UserSecurityDto userSecurityDto) {
        UserModel userModel= new UserModel(
                userSecurityDto.getNickname(),
                userSecurityDto.getPassword(),
                userSecurityDto.getCorreo(),
                userSecurityDto.getRole()
        );

        userRepository.save(userModel);
    }


}
