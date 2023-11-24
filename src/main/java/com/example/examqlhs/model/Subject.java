package com.example.examqlhs.model;

import com.example.examqlhs.model.student.Student;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    private Long id;
    private String subjectName;
    @ManyToOne
    private Student student;
    public Subject() {
    }

    public Subject(Long id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
