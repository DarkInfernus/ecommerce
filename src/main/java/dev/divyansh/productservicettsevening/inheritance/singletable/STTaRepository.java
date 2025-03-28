package dev.divyansh.productservicettsevening.inheritance.singletable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface STTaRepository extends JpaRepository<Ta, Integer> {
    Ta save(Ta ta);
    Optional<Ta> findById(int id);
}
