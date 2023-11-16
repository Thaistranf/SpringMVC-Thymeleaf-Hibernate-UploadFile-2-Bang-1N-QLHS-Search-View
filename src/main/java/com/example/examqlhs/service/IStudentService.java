package com.example.examqlhs.service;

import com.example.examqlhs.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Iterable<Student> findAll();

    void save(Student student);

    Optional<Student> findById(Long id);

    void remove(Long id);

    List<Student> search(String keyword);
}
