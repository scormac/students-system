package com.students.studentssystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.students.studentssystem.model.Student;
import com.students.studentssystem.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/view-students")
	public String studentsView(Model model) {
		model.addAttribute("studentList", studentService.getAllStudent());
		return "view-students";
	}
	
	@GetMapping("/add-student")
	public String studentRegister(Model model) {
		Student student = new Student();
        model.addAttribute("student", student);
		return "add-student";
	}
	
	@PostMapping("/save")
	public String addStudent(@ModelAttribute("student") Student s) {
		studentService.saveStudent(s);
		return "redirect:/view-students";
	}
	
	@GetMapping("/update-student/{id}")
	public String updateStudent(@PathVariable(value = "id") Long id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "update-student";
	}
	
	@GetMapping("/delete-student/{id}")
	public String deleteStudent(@PathVariable(value = "id") Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/view-students";
	}
}

