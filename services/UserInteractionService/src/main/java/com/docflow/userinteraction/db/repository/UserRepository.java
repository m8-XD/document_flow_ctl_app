package com.docflow.userinteraction.db.repository;

import com.docflow.userinteraction.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.deleted_at IS NULL")
    List<User> getAllUsers();

    @Query("SELECT u FROM User u WHERE u.id = :id AND u.deleted_at IS NULL")
    Optional<User> getUserById(UUID id);

    @Modifying
    @Query("UPDATE User u SET u.deleted_at = current_timestamp WHERE u.id = :id")
    void deleteUserById(UUID id);

    @Modifying
    @Query("UPDATE User u SET u.role = 'USER' WHERE u.id = :id")
    void makeUser(UUID id);

    @Modifying
    @Query("UPDATE User u SET u.role = 'ADMIN' WHERE u.id = :id")
    void makeAdmin(UUID id);

    @Query("SELECT u.id FROM User u WHERE u.username = :username AND u.deleted_at IS NULL")
    UUID getUserIdByUsername(String username);
}
