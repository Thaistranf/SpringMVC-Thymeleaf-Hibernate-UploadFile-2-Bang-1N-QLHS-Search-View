package com.example.examqlhs.model;

import javax.persistence.*;

@Entity
@Table(name = "Class")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String className;

    public Classroom() {
    }

    public Classroom(Long id, String className) {
        this.id = id;
        this.className = className;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
