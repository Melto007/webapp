package com.webapp.webapp.contollers;

import com.webapp.webapp.models.Student;
import com.webapp.webapp.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/student")
    public Student post(
            @RequestBody Student student
    ) {
        return studentRepository.save(student);
    }

    @GetMapping("/students")
    public List<Student> get() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{studenId}")
    public Student getStudentById(
            @PathVariable("studenId") Integer id
    ) {
        return studentRepository.findById(id)
                .orElse(new Student());
    }

    @GetMapping("/student/search/{student-name}")
    public List<Student> getStudentByName(
            @PathVariable("student-name") String name
    ) {
        return studentRepository.findAllByFirstnameContaining(name);
    }
}
