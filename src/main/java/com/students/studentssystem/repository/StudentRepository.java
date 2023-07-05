package com.students.studentssystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.studentssystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
