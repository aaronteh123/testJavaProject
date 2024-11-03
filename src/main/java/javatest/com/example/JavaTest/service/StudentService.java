package javatest.com.example.JavaTest.service;

import javatest.com.example.JavaTest.model.Student;
import javatest.com.example.JavaTest.model.StudentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
//    List<StudentDTO> getAllStudents();
    Page<StudentDTO>  getAllStudents(Pageable pageable);
    Student addStudent(Student student);

    Student updateStudent(int id, Student studentDetails);
}
