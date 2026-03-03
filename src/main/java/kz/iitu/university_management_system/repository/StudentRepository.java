package kz.iitu.university_management_system.repository;

import kz.iitu.university_management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}