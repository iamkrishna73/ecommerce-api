package io.iamkrishna73.ecommerce.repositories;

import io.iamkrishna73.ecommerce.entity.AppRole;
import io.iamkrishna73.ecommerce.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
     Optional<Role> findByRoleName(AppRole appRole);
}
