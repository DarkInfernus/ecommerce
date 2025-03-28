package dev.divyansh.productservicettsevening.inheritance.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JTSRepository extends JpaRepository<Student, Integer> {
    @Override
    Student save(Student student);
}
