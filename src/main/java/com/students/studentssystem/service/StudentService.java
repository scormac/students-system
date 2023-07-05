package com.students.studentssystem.service;

import java.util.List;

import com.students.studentssystem.model.Student;

public interface StudentService {
	
	void saveStudent(Student student);
	
	List<Student> getAllStudent();
	
	Student getStudentById(Long id);
	
	void deleteStudentById(Long id);

}
