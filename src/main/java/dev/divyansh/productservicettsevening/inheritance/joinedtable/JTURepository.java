package dev.divyansh.productservicettsevening.inheritance.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JTURepository extends JpaRepository<User, Integer> {
    @Override
    User save(User user);
}
