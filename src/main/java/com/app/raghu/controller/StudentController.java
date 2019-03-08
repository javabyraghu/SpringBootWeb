package com.app.raghu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.raghu.model.Student;
import com.app.raghu.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@RequestMapping("/register")
	public String showRegister(Model model) {
		Student s=new Student();
		s.setStdName("AA");
		model.addAttribute("student", s);
		return "StudentRegister";
	}
	//student/insert
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student,Model model) {
		Integer stdId=service.saveStudent(student);
		model.addAttribute("message", stdId+" Data Submitted");
		model.addAttribute("student", new Student());
		return "StudentRegister";
	}
	
	@RequestMapping("/all")
	public String showAllStudents(Model model) {
		model.addAttribute("list", service.getAllStudents());
		return "StudentData";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Integer id,Model model) {
		service.deleteStudent(id);
		model.addAttribute("list", service.getAllStudents());
		return "StudentData";
	}
	
	
	@RequestMapping("/edit/{id}")
	public String editStudent(@PathVariable Integer id,Model model) {
		model.addAttribute("student", service.getStudentById(id));
		return "StudentRegister";
	}
}
