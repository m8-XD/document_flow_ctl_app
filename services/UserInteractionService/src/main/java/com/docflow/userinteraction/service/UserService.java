package com.docflow.userinteraction.service;

import com.docflow.userinteraction.db.entity.ERole;
import com.docflow.userinteraction.db.entity.User;
import com.docflow.userinteraction.db.repository.UserRepository;
import com.docflow.userinteraction.dto.UserCreateEditDTO;
import com.docflow.userinteraction.dto.UserReadDto;
import com.docflow.userinteraction.mapper.UserDTOMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.kafka.clients.admin.UserScramCredentialUpsertion;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    UserRepository userRepository;
    UserDTOMapper userDTOMapper;

    public Optional<UserReadDto> createUser(UserCreateEditDTO userDTO) {
        User user = userDTOMapper.map(userDTO);
        Optional<User> maybeUser = userRepository.findByUsername(user.getUsername());
        if (maybeUser.isPresent()) {
            if (maybeUser.get().getDeleted_at() == null) {
                log.info("trying to create existing user, aborting...");
                return Optional.empty();
            }
            userRepository.deleteById(maybeUser.get().getId());
            userRepository.flush();
            log.info("user {} have been deleted to create new user with that username", user.getUsername());
        }
        user.setCreated_at(LocalDateTime.now());
        User newUser = userRepository.save(user);
        return Optional.of(userDTOMapper.map(newUser));
    }

    public UUID getUserIdByUsername(String username) {
        return userRepository.getUserIdByUsername(username);
    }

    public List<UserReadDto> getAllUsers() {
        return userRepository.getAllUsers()
                .stream()
                .map(userDTOMapper::map)
                .toList();
    }

    public UserReadDto getUserById(UUID id) {
        return userRepository
                .getUserById(id)
                .map(userDTOMapper::map)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteUserById(UUID id) {
        userRepository.deleteUserById(id);
    }

    public void changeRole(UUID id) {
        Optional<User> maybeUser = userRepository.getUserById(id);
        if (maybeUser.isEmpty()) {
            return;
        }
        ERole role = maybeUser.get().getRole();
        if (role.equals(ERole.USER)) {
            userRepository.makeAdmin(id);
        } else {
            userRepository.makeUser(id);
        }
    }
}
