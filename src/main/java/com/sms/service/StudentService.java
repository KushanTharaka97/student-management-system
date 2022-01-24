package com.sms.service;

import com.sms.model.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentService {
    public List<StudentDto> listAllStd();
    public StudentDto addStudent(StudentDto studentDetail);
    public StudentDto listById(long id);
    public StudentDto updateStudent(long id, StudentDto updatingDto);
    public void deleteStudent(long id);
}
