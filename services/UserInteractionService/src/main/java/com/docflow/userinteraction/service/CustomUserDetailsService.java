package com.docflow.userinteraction.service;

import com.docflow.userinteraction.db.entity.MyUserPrincipal;
import com.docflow.userinteraction.db.entity.User;
import com.docflow.userinteraction.db.repository.UserRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty() || user.get().getDeleted_at() != null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user.get());
    }
}
