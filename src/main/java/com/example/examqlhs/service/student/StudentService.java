package com.example.examqlhs.service.student;

import com.example.examqlhs.model.student.Student;
import com.example.examqlhs.repository.StudentRepository;
import com.example.examqlhs.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> search(String keyword) {
        return studentRepository.findStudentByNameContaining(keyword);
    }
}
