package dev.divyansh.productservicettsevening.inheritance.seperatetable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STUserRepository extends JpaRepository<User, Integer> {
    User save(User user);
}
