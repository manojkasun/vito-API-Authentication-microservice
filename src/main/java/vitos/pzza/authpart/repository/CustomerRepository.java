package vitos.pzza.authpart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitos.pzza.authpart.entity.CustomerEntity;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByEmail(String email);
    Optional<CustomerEntity> findByUsernameOrEmail(String username, String email);
    Optional<CustomerEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}