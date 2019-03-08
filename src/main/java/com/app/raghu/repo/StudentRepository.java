package com.app.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
