package kz.iitu.university_management_system.service;

import kz.iitu.university_management_system.entity.Course;
import kz.iitu.university_management_system.entity.Student;
import kz.iitu.university_management_system.repository.CourseRepository;
import kz.iitu.university_management_system.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    // Save student with profile
    public Student saveStudent(Student student) {
        if (student.getProfile() != null) {
            student.getProfile().setStudent(student);
        }
        return studentRepository.save(student);
    }

    // Assign course to student
    public Student assignCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();

        student.getCourses().add(course);
        course.getStudents().add(student);

        return studentRepository.save(student);
    }
}