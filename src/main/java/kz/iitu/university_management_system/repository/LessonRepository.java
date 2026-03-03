package kz.iitu.university_management_system.repository;

import kz.iitu.university_management_system.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}