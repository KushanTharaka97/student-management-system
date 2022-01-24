package com.sms.controller;

import com.sms.model.StudentDto;
import com.sms.service.StudentService;
import com.sms.service.impl.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController
//@RequestMapping("/api/std")
@Controller
public class StudentController {
    private StudentServiceImpl studentServiceImpl;
    public StudentController(StudentServiceImpl studentServiceImpl) {
        super();
        this.studentServiceImpl = studentServiceImpl;
    }

    //all the students details are getting
//    @GetMapping("getall")
    @GetMapping("/students")
    public String  getAllStudent(Model model){
        model.addAttribute("students", studentServiceImpl.listAllStd());
        return "students";
    }

    //add new student to the database - POST
    @GetMapping("/insert")
    public String insertNewStud(Model model){
        StudentDto student = new StudentDto();
        model.addAttribute("student", student);
        return "create_student";
    }

    //select and show details of the students that search from the "id" - GET
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> showStudent(@PathVariable(name = "id") long id){
        return new ResponseEntity<StudentDto>(studentServiceImpl.listById(id), HttpStatus.OK);
    }
    //update the student - PUT
    @PutMapping("update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable(name = "id") long id,@RequestBody StudentDto studentInfo){
        return new ResponseEntity<StudentDto>(studentServiceImpl.updateStudent(id, studentInfo), HttpStatus.OK);
    }
    //delete the student  - DELETE
    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable(name = "id") long id){
        studentServiceImpl.deleteStudent(id);
    }
}
