package com.example.examqlhs.model.student;

import com.example.examqlhs.model.Classroom;
import org.springframework.web.multipart.MultipartFile;

public class StudentForm {
    private Long id;
    private String name;
    private String address;
    private MultipartFile image;
    private Classroom classroom;
    public StudentForm() {
    }

    public StudentForm(Long id, String name, String address, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.image = image;
    }

    public StudentForm(Long id, String name, String address, MultipartFile image, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.image = image;
        this.classroom = classroom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
