package vitos.pzza.authpart.repository;

import org.springframework.data.repository.CrudRepository;
import vitos.pzza.authpart.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Boolean existsByEmail(String email);
}

