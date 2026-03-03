package kz.iitu.university_management_system.service;

import kz.iitu.university_management_system.entity.Course;
import kz.iitu.university_management_system.entity.Lesson;
import kz.iitu.university_management_system.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course addLesson(Long courseId, Lesson lesson) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        lesson.setCourse(course);
        course.getLessons().add(lesson);
        return courseRepository.save(course);
    }
}