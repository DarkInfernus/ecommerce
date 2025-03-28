package dev.divyansh.productservicettsevening.inheritance.singletable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface STInstructorRepository extends JpaRepository<Instructor, Integer> {
    Instructor save(Instructor instructor);
    Optional<Instructor> findById(int id);
}
