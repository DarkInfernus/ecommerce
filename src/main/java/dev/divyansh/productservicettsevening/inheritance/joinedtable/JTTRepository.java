package dev.divyansh.productservicettsevening.inheritance.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JTTRepository extends JpaRepository<Ta, Integer> {
    @Override
    Ta save(Ta ta);
}
