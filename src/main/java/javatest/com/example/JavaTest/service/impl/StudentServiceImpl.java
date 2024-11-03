package javatest.com.example.JavaTest.service.impl;
import javatest.com.example.JavaTest.model.Student;
import javatest.com.example.JavaTest.model.StudentDTO;
import javatest.com.example.JavaTest.repository.IStudentRepository;
import javatest.com.example.JavaTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private IStudentRepository istudentRepository;

//    @Override
//    @Transactional(readOnly = true)
//    public List<StudentDTO> getAllStudents() {
//        List<Student> students = istudentRepository.findAll();
//        return  students.stream().map(StudentDTO::new).collect(Collectors.toList());
//    }

    @Override
    @Transactional(readOnly = true)
    public Page<StudentDTO> getAllStudents(Pageable pageable) {
        Page<Student> studentsPage = istudentRepository.findAll(pageable);
        return studentsPage.map(StudentDTO::new);
    }


    @Override
    @Transactional
    public Student addStudent(Student student) {
        return istudentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(int id, Student student) {
        Student oldstudent = istudentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        oldstudent.setSname(student.getSname());
        oldstudent.setContact(student.getContact());
        oldstudent.setAge(student.getAge());
        return istudentRepository.save(oldstudent);
    }
}



