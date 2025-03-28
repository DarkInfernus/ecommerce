package dev.divyansh.productservicettsevening.inheritance.seperatetable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STTaRepository extends JpaRepository<Ta, Integer> {
    Ta save(Ta ta);
}
