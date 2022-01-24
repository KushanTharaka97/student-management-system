package com.sms.service.impl;

import com.sms.exception.ResourceNotFoundException;
import com.sms.model.StudentDto;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    //show all students
    @Override
    public List<StudentDto> listAllStd() {
        return studentRepository.findAll();
    }

    //save new student
    @Override
    public StudentDto addStudent(StudentDto studentDetail) {
        return studentRepository.save(studentDetail);
    }

    //find by id
    @Override
    public StudentDto listById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
    }

    //update existing student
    @Override
    public StudentDto updateStudent(long id, StudentDto updatingDto) {
        //search for the id existance
        StudentDto existingStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
        existingStudent.setFirstName(updatingDto.getFirstName());
        existingStudent.setLastName(updatingDto.getLastName());
        existingStudent.setEmail(updatingDto.getEmail());
        studentRepository.save(existingStudent);
        return existingStudent;
    }

    //delete student
    @Override
    public void deleteStudent(long id) {
        //check for existance
        studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
        studentRepository.deleteById(id);

    }
}
