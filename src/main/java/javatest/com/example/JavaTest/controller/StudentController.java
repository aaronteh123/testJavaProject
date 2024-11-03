package javatest.com.example.JavaTest.controller;
import javatest.com.example.JavaTest.model.Student;
import javatest.com.example.JavaTest.model.StudentDTO;
import javatest.com.example.JavaTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Page<StudentDTO>> getStudents(
            @PageableDefault(size = 10) Pageable pageable) {
        Page<StudentDTO> studentPage = studentService.getAllStudents(pageable);
        return ResponseEntity.ok(studentPage);
    }

    @PostMapping( produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student result = studentService.addStudent(student);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student studentDetails) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentDetails));
    }

}
