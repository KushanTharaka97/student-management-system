package com.sms.repository;

import com.sms.model.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentDto, Long> {
}
