package com.example.examqlhs.model.student;

import com.example.examqlhs.model.Classroom;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String image;

    @ManyToOne
    private Classroom classroom;

    public Student() {
    }

    public Student(Long id, String name, String address, String image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.image = image;
    }

    public Student(Long id, String name, String address, String image, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.image = image;
        this.classroom = classroom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
