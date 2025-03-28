package dev.divyansh.productservicettsevening.inheritance.mappedsuperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MSCStudentsRepository extends JpaRepository<Student, Integer> {
    Student save(Student student);
    Student findById(int id);
}
