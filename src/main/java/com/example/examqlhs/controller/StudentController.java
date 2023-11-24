package com.example.examqlhs.controller;

import com.example.examqlhs.model.Classroom;
import com.example.examqlhs.model.student.Student;
import com.example.examqlhs.model.student.StudentForm;
import com.example.examqlhs.service.classroom.IClassroomService;
import com.example.examqlhs.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    // Dùng kiểu dữ liệu là "IStudentService" vì cấu hình @Bean trong AppConfiguration là "IStudentService"
    // thì mới lấy được dữ liệu trong vài trường hợp hãm loz
    private IStudentService studentService;
    @Autowired
    // Dùng kiểu dữ liệu là "IClassroomService" vì cấu hình @Bean trong AppConfiguration là "IClassroomService"
    // thì mới lấy được dữ liệu trong vài trường hợp hãm loz
    private IClassroomService classroomService;
    @ModelAttribute("classList")    //Khai bao "classList" de lay ra ds classroom dung duoc o nhieu .html khac nhau trong views
    public Iterable<Classroom> classrooms(){
        return classroomService.findAll();
    }

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("studentList", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("newStudent", new StudentForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute StudentForm studentForm){
        MultipartFile multipartFile = studentForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        Student student = new Student(studentForm.getId(),studentForm.getName(), studentForm.getAddress(), fileName, studentForm.getClassroom());
        studentService.save(student);
        return ("redirect:/students");
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/student/update");
        Student student = studentService.findById(id).get();
        modelAndView.addObject("studentUp", student);
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute StudentForm studentForm){
        Student student = studentService.findById(id).get();
        Student student1 = null;
        MultipartFile multipartFile = studentForm.getImage();

        if (!multipartFile.isEmpty()){
            String fileName = multipartFile.getOriginalFilename();
            try {
                FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
            } catch (IOException ex) {
                System.out.println(ex);
            }
            student1 = new Student(studentForm.getId(),studentForm.getName(), studentForm.getAddress(), fileName, studentForm.getClassroom());
        } else {
            student1 = new Student(studentForm.getId(), studentForm.getName(),studentForm.getAddress(), student.getImage(), studentForm.getClassroom());
        }

        studentService.save(student1);
        return ("redirect:/students");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        studentService.remove(id);
        return ("redirect:/students");
    }

    @GetMapping("/view/{id}")
    public String View(@PathVariable Long id, Model model){
        model.addAttribute("studentView", studentService.findById(id).get());
        return "/student/view";
    }

    @PostMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model){
        List<Student> searchStudent = studentService.search(keyword);
        model.addAttribute("searchStudent", searchStudent);
        return "/student/list";
    }
}
