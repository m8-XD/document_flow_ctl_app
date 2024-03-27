package com.docflow.userinteraction.db.entity;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;


@AllArgsConstructor
public class MyUserPrincipal implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(user.getRole());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getDeleted_at() == null;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getDeleted_at() == null;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getDeleted_at() == null;
    }

    @Override
    public boolean isEnabled() {
        return user.getDeleted_at() == null;
    }
}
