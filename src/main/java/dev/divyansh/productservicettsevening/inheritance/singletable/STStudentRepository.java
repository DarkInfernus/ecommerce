package dev.divyansh.productservicettsevening.inheritance.singletable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface STStudentRepository extends JpaRepository<Student, Integer> {
    Student save(Student student);
    Optional<Student> findById(int id);
}
