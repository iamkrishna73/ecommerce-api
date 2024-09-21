package io.iamkrishna73.ecommerce.repositories;

import io.iamkrishna73.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
}
