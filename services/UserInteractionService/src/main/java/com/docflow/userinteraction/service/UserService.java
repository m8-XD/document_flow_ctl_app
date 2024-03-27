package com.docflow.userinteraction.service;

import com.docflow.userinteraction.db.entity.User;
import com.docflow.userinteraction.db.repository.UserRepository;
import com.docflow.userinteraction.dto.UserCreateEditDTO;
import com.docflow.userinteraction.dto.UserReadDto;
import com.docflow.userinteraction.mapper.UserDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;
    UserDTOMapper userDTOMapper;

    public Optional<UserReadDto> createUser(UserCreateEditDTO userDTO) {
        User user = userDTOMapper.map(userDTO);
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return Optional.empty();
        }
        User newUser = userRepository.save(user);
        return Optional.of(userDTOMapper.map(newUser));
    }

}
