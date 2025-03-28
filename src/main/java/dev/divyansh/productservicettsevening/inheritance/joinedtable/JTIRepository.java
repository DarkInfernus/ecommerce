package dev.divyansh.productservicettsevening.inheritance.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JTIRepository extends JpaRepository<Instructor, Integer> {
    @Override
    Instructor save(Instructor instructor);

    @Override
    Optional<Instructor> findById(Integer integer);
}
