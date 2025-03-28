package dev.divyansh.productservicettsevening.inheritance.singletable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface STUserRepository extends JpaRepository<User, Integer> {
    User save(User user);
    Optional<User> findById(int id);
}
