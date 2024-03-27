package com.docflow.userinteraction.mapper;

import com.docflow.userinteraction.db.entity.ERole;
import com.docflow.userinteraction.db.entity.User;
import com.docflow.userinteraction.dto.UserCreateEditDTO;
import com.docflow.userinteraction.dto.UserReadDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
@Component
public class UserDTOMapper {

    PasswordEncoder passwordEncoder;

    public User map(UserCreateEditDTO from) {
        return User.builder()
            .username(from.getUsername())
            .password(passwordEncoder.encode(from.getPassword()))
            .role(ERole.USER)
            .created_at(LocalDateTime.now())
            .build();
    }

    public UserReadDto map(User user) {
        return UserReadDto.builder()
            .id(user.getId())
            .username(user.getUsername())
            .passwordEnc(user.getPassword())
            .role(user.getRole())
            .createdAt(user.getCreated_at())
            .build();
    }
}
