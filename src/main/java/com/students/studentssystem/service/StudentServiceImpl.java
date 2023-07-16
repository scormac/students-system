package com.students.studentssystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.studentssystem.model.Student;
import com.students.studentssystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public void saveStudent(Student student) {
		studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		Optional<Student> optionalStudent = studentRepo.findById(id);
        	Student student = null;
        	if (optionalStudent.isPresent())
            		student = optionalStudent.get();
        	else
            		throw new RuntimeException("Student not found for id :: " + id);
        	return student;
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepo.deleteById(id);		
	}
}
