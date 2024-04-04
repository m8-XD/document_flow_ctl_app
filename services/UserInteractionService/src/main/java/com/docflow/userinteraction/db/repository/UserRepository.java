package com.docflow.userinteraction.db.repository;

import com.docflow.userinteraction.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.deleted_at IS NULL")
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.deleted_at IS NULL")
    List<User> getAllUsers();

    @Query("SELECT u FROM User u WHERE u.id = :id AND u.deleted_at IS NULL")
    Optional<User> getUserById(UUID id);
}
