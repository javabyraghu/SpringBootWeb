package com.app.raghu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.raghu.model.Student;
import com.app.raghu.repo.StudentRepository;
import com.app.raghu.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repo;
	
	@Override
	public Integer saveStudent(Student student) {
		return repo.save(student).getStdId();
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Student getStudentById(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

}
