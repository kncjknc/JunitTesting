package ApiTesting.ForJunit.controller;

import ApiTesting.ForJunit.entity.Student;
import ApiTesting.ForJunit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add/Student")
    public Student add(@RequestBody Student student){
       return studentService.addStud(student);
    }

    @GetMapping("/getStud/{id}")
    public Student getStud(@PathVariable int id){
       return studentService.getStud(id);
    }

    @DeleteMapping("/deleteId/{id}")
    public String deleteStud(@PathVariable int id){
        return studentService.deleteStud(id);
    }
}