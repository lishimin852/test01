package com.crow.service;

import com.crow.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> selectAllStudent();

    void addStudent(Student student);
}
