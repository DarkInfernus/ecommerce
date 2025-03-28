package dev.divyansh.productservicettsevening.inheritance.mappedsuperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MSCInstructorRepository extends JpaRepository<Instructor, Integer> {
    Instructor save(Instructor instructor);
    Instructor findById(int id);
}
