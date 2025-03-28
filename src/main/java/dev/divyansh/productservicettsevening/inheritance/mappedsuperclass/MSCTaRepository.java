package dev.divyansh.productservicettsevening.inheritance.mappedsuperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MSCTaRepository extends JpaRepository<Ta, Integer> {
    Ta save(Ta ta);
    Ta findById(int id);
}
