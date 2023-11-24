package com.example.examqlhs.service.student;

import com.example.examqlhs.model.student.Student;
import com.example.examqlhs.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IStudentService extends IGeneralService<Student> {
    List<Student> search(String keyword);
}
