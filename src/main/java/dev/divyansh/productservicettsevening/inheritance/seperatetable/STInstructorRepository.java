package dev.divyansh.productservicettsevening.inheritance.seperatetable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STInstructorRepository extends JpaRepository<Instructor, Integer> {
    Instructor save(Instructor instructor);
}
